package com.devsu.test.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.test.application.exception.ConflictException;
import com.devsu.test.application.exception.ResourceNotFoundException;
import com.devsu.test.application.requests.AccountAddRequest;
import com.devsu.test.application.requests.AccountUpdateRequest;
import com.devsu.test.application.responses.AccountIdResponse;
import com.devsu.test.application.responses.AccountResponse;
import com.devsu.test.domain.models.Account;
import com.devsu.test.domain.repositories.AccountRepository;

/**
 * The Class AccountServiceImpl.
 * 
 * @author David Sepulveda
 */
@Service
public class AccountServiceImpl implements AccountService {

    /** The Constant ACCOUNT. */
    private static final String ACCOUNT = "Account ";

    /** The Constant ACCOUNT_NOT_FOUND. */
    private static final String ACCOUNT_NOT_FOUND = " not found";

    /** The Constant ACCOUNT_EXISTING. */
    private static final String ACCOUNT_EXISTING = " existing";

    /** The account repository. */
    private final AccountRepository accountRepository;

    /** The client service. */
    private final ClientServiceImpl clientService;

    /**
     * Instantiates a new account service impl.
     *
     * @param accountRepository the account repository
     * @param clientService     the client service
     */
    public AccountServiceImpl(AccountRepository accountRepository, ClientServiceImpl clientService) {
        this.accountRepository = accountRepository;
        this.clientService = clientService;
    }

    /**
     * Gets the account.
     *
     * @param accountId the account id
     * @return the account
     */
    @Override
    public AccountResponse getAccount(Long accountId) {
        Account account = getAccountById(accountId);

        AccountResponse response = new AccountResponse();
        response.setAccountId(account.getAccountId());
        response.setAccountNumber(account.getAccountNumber());
        response.setAccountType(account.getAccountType());
        response.setInitialBalance(account.getInitialBalance());
        response.setStatus(account.getStatus());
        response.setClientId(account.getClientId());
        return response;
    }

    /**
     * Adds the account.
     *
     * @param request the request
     * @return the account id response
     */
    @Override
    public AccountIdResponse addAccount(AccountAddRequest request) {

        clientService.validateClientExistence(request.getClientId());

        Account account = this.accountRepository.findByNumberAccountAndType(request.getAccountNumber(),
                request.getAccountType().name());
        if (account != null) {
            throw new ConflictException(new StringBuilder().append(ACCOUNT).append(request.getAccountNumber())
                    .append(ACCOUNT_EXISTING).toString());
        }

        AccountIdResponse clientIdDto = new AccountIdResponse();
        account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setAccountType(request.getAccountType().name());
        account.setInitialBalance(request.getInitialBalance());
        account.setClientId(request.getClientId());
        account.setStatus(true);
        account = this.accountRepository.save(account);
        clientIdDto.setAccountId(account.getAccountId());
        return clientIdDto;
    }

    /**
     * Update account.
     *
     * @param request the request
     */
    @Override
    public void updateAccount(AccountUpdateRequest request) {

        clientService.validateClientExistence(request.getClientId());

        Long accountId = request.getClientId();
        Account account = getAccountById(accountId);

        account.setAccountId(request.getAccountId());
        account.setAccountNumber(request.getAccountNumber());
        account.setAccountType(request.getAccountType().name());
        account.setInitialBalance(request.getInitialBalance());
        account.setClientId(request.getClientId());
        account.setStatus(request.getStatus());
        this.accountRepository.save(account);
    }

    /**
     * Delete account.
     *
     * @param accountId the account id
     */
    @Override
    public void deleteAccount(Long accountId) {
        Account account = getAccountById(accountId);

        this.accountRepository.delete(account);
    }

    /**
     * Gets the all accounts.
     *
     * @return the all accounts
     */
    @Override
    public List<AccountResponse> getAllAccounts() {
        List<Account> listAccounts = this.accountRepository.findAll();
        return listAccounts.stream().map(account -> {
            AccountResponse response = new AccountResponse();
            response.setAccountId(account.getAccountId());
            response.setAccountNumber(account.getAccountNumber());
            response.setAccountType(account.getAccountType());
            response.setInitialBalance(account.getInitialBalance());
            response.setStatus(account.getStatus());
            response.setClientId(account.getClientId());
            return response;
        }).toList();
    }
    
    /**
     * Gets the account by id.
     *
     * @param accountId the account id
     * @return the account by id
     */
    private Account getAccountById(Long accountId) {
        Account account = this.accountRepository.findById(accountId);
        if (account == null) {
            throw new ResourceNotFoundException(
                    new StringBuilder().append(ACCOUNT).append(accountId).append(ACCOUNT_NOT_FOUND).toString());
        }
        return account;
    }

}