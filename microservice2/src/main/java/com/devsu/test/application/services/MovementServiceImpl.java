package com.devsu.test.application.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.test.application.exception.ConflictException;
import com.devsu.test.application.exception.InternalException;
import com.devsu.test.application.exception.ResourceNotFoundException;
import com.devsu.test.application.requests.MovementAddRequest;
import com.devsu.test.application.requests.MovementType;
import com.devsu.test.application.responses.ClientResponse;
import com.devsu.test.application.responses.MovementResponse;
import com.devsu.test.domain.models.Account;
import com.devsu.test.domain.models.Movement;
import com.devsu.test.domain.repositories.AccountRepository;
import com.devsu.test.domain.repositories.MovementRepository;

import jakarta.transaction.Transactional;

/**
 * The Class MovementServiceImpl.
 * 
 * @author David Sepulveda
 */
@Service
public class MovementServiceImpl implements MovementService {

    /** The Constant ACCOUNT. */
    private static final String ACCOUNT = "Account ";

    /** The Constant MOVEMENT. */
    private static final String MOVEMENT = "Movement ";

    /** The Constant ACCOUNT_NOT_FOUND. */
    private static final String NOT_FOUND = " not found";

    /** The Constant ACCOUNT_NOT_BALANCE. */
    private static final String ACCOUNT_NOT_BALANCE = "Unavailable balance";

    /** The Constant MOVEMENT_NOT_EXECUTED. */
    private static final String MOVEMENT_NOT_EXECUTED = "No movement was executed";

    /** The Constant ACCOUNT_INACTIVE. */
    private static final String ACCOUNT_INACTIVE = " is inactive";

    /** The movement repository. */
    private final MovementRepository movementRepository;

    /** The account repository. */
    private final AccountRepository accountRepository;

    /** The client service. */
    private final ClientServiceImpl clientService;

    /**
     * Instantiates a new movement service impl.
     *
     * @param movementRepository the movement repository
     * @param accountRepository  the account repository
     * @param clientService      the client service
     */
    public MovementServiceImpl(MovementRepository movementRepository, AccountRepository accountRepository,
            ClientServiceImpl clientService) {
        this.movementRepository = movementRepository;
        this.accountRepository = accountRepository;
        this.clientService = clientService;
    }

    /**
     * Gets the movement.
     *
     * @param movementId the movement id
     * @return the movement
     */
    @Override
    public MovementResponse getMovement(Long movementId) {
        Movement movement = getMovementById(movementId);

        Account account = getAccount(movement.getAccountId());

        ClientResponse clientResponse = this.clientService.validateClientExistence(account.getClientId());

        return createMovementResponse(movement, account, clientResponse);
    }

    /**
     * Adds the movement.
     *
     * @param request the request
     * @return the movement response
     */
    @Override
    @Transactional(rollbackOn = InternalException.class)
    public MovementResponse addMovement(MovementAddRequest request) {

        Long accountId = request.getAccountId();
        Account account = getAccount(accountId);

        validateRequest(request.getAmount());

        validateAvailableBalance(request.getAmount(), account);

        ClientResponse clientResponse = this.clientService.validateClientExistence(account.getClientId());

        Movement movement = createMovement(request.getAmount(), account);

        movement = saveMovementAndAccount(account, movement);

        return createMovementResponse(movement, account, clientResponse);

    }

    /**
     * Delete movement.W
     *
     * @param movementId the movement id
     */
    @Override
    @Transactional(rollbackOn = InternalException.class)
    public void deleteMovement(Long movementId) {
        Movement existingMovement = getMovementById(movementId);
        Account account = getAccount(existingMovement.getAccountId());

        BigDecimal movementAmount = existingMovement.getAmount();
        boolean isWithdrawalExisting = movementAmount.compareTo(BigDecimal.ZERO) < 0;

        movementRepository.delete(existingMovement);

        if (isWithdrawalExisting) {
            account.setInitialBalance(account.getInitialBalance().add(movementAmount.abs()));
        } else {
            account.setInitialBalance(account.getInitialBalance().subtract(movementAmount));
        }

        accountRepository.save(account);
    }

    /**
     * Gets the movement by id.
     *
     * @param movementId the movement id
     * @return the movement by id
     */
    private Movement getMovementById(Long movementId) {
        Movement movement = movementRepository.findById(movementId);
        if (movement == null) {
            throw new ResourceNotFoundException(
                    new StringBuilder().append(MOVEMENT).append(movementId).append(NOT_FOUND).toString());
        }
        return movement;
    }

    /**
     * Validate request.
     *
     * @param amount the amount
     */
    private void validateRequest(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            throw new ConflictException(MOVEMENT_NOT_EXECUTED);
        }
    }

    /**
     * Validate available balance.
     *
     * @param amount  the amount
     * @param account the account
     */
    private void validateAvailableBalance(BigDecimal amount, Account account) {
        BigDecimal initialBalance = account.getInitialBalance();
        if (amount.compareTo(BigDecimal.ZERO) < 0 && initialBalance.compareTo(amount.abs()) < 0) {
            throw new ConflictException(ACCOUNT_NOT_BALANCE);
        }
    }
    
    /**
     * Gets the account.
     *
     * @param accountId the account id
     * @return the account
     */
    private Account getAccount(Long accountId) {
        Account account = accountRepository.findById(accountId);
        if (account == null) {
            throw new ResourceNotFoundException(
                    new StringBuilder().append(ACCOUNT).append(accountId).append(NOT_FOUND).toString());
        }
        if (!account.getStatus()) {
            throw new ConflictException(
                    new StringBuilder().append(ACCOUNT).append(accountId).append(ACCOUNT_INACTIVE).toString());
        }
        return account;
    }

    /**
     * Creates the movement.
     *
     * @param amount  the amount
     * @param account the account
     * @return the movement
     */
    private Movement createMovement(BigDecimal amount, Account account) {
        BigDecimal initialBalance = account.getInitialBalance();
        BigDecimal newBalance;

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            newBalance = initialBalance.subtract(amount.abs());
        } else {
            newBalance = initialBalance.add(amount);
        }

        Movement movement = new Movement();
        movement.setAccountId(account.getAccountId());
        movement.setAmount(amount);
        movement.setBalance(newBalance);
        movement.setType(
                amount.compareTo(BigDecimal.ZERO) < 0 ? MovementType.WITHDRAWAL.name() : MovementType.DEPOSIT.name());

        return movement;
    }

    /**
     * Save movement and account.
     *
     * @param account  the account
     * @param movement the movement
     * @return the movement
     */
    private Movement saveMovementAndAccount(Account account, Movement movement) {
        movement = movementRepository.save(movement);
        account.setInitialBalance(movement.getBalance());
        accountRepository.save(account);
        return movement;
    }

    /**
     * Creates the movement response.
     *
     * @param movement the movement
     * @param account  the account
     * @param client   the client
     * @return the movement response
     */
    private MovementResponse createMovementResponse(Movement movement, Account account, ClientResponse client) {
        MovementResponse movementResponse = new MovementResponse();
        movementResponse.setMovementId(movement.getMovementId());
        movementResponse.setDate(movement.getDate());
        movementResponse.setAccountNumber(account.getAccountNumber());
        movementResponse.setClient(client.getName());
        movementResponse.setAccountType(account.getAccountType());
        movementResponse.setStatus(account.getStatus());
        movementResponse.setInitialBalance(account.getInitialBalance());
        movementResponse.setAmount(movement.getAmount());
        movementResponse.setAvailableBalance(movement.getBalance());
        movementResponse.setMovementType(movement.getType());
        return movementResponse;
    }

    /**
     * Gets the report movements by client.
     *
     * @param startDate      the start date
     * @param endDate        the end date
     * @param identification the identification
     * @return the report movements by client
     */
    @Override
    public List<MovementResponse> getReportMovementsByClient(LocalDate startDate, LocalDate endDate,
            String identification) {

        List<Object[]> result = this.movementRepository.reportMovementsByClient(startDate, endDate, identification);

        List<MovementResponse> movementResponses = new ArrayList<>();

        for (Object[] row : result) {
            Long movementId = ((Number) row[0]).longValue();
            Timestamp timestamp = (Timestamp) row[1];
            LocalDateTime date = timestamp.toLocalDateTime();
            String name = (String) row[2];
            String accountNumber = (String) row[3];
            String accountType = (String) row[4];
            String type = (String) row[5];
            BigDecimal initialBalance = (BigDecimal) row[6];
            boolean status = (boolean) row[7];
            BigDecimal amount = (BigDecimal) row[8];
            BigDecimal availableBalance = (BigDecimal) row[9];

            MovementResponse movementResponse = new MovementResponse();
            movementResponse.setMovementId(movementId);
            movementResponse.setDate(date);
            movementResponse.setClient(name);
            movementResponse.setAccountNumber(accountNumber);
            movementResponse.setAccountType(accountType);
            movementResponse.setMovementType(type);
            movementResponse.setInitialBalance(initialBalance);
            movementResponse.setStatus(status);
            movementResponse.setAmount(amount);
            movementResponse.setAvailableBalance(availableBalance);

            movementResponses.add(movementResponse);
        }

        return movementResponses;

    }

}
