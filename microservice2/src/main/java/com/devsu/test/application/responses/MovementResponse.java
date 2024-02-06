package com.devsu.test.application.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The Class MovementResponse.
 * 
 * @author David Sepulveda
 */
public class MovementResponse {

    /** The movement id. */
    private Long movementId;
    
    /** The date. */
    private LocalDateTime date;

    /** The client. */
    private String client;

    /** The account number. */
    private String accountNumber;

    /** The account type. */
    private String accountType;

    /** The movement type. */
    private String movementType;

    /** The initial balance. */
    private BigDecimal initialBalance;

    /** The status. */
    private boolean status;

    /** The amount. */
    private BigDecimal amount;

    /** The available balance. */
    private BigDecimal availableBalance;
    
    /**
     * Gets the movement id.
     *
     * @return the movement id
     */
    public Long getMovementId() {
        return movementId;
    }

    /**
     * Sets the movement id.
     *
     * @param movementId the new movement id
     */
    public void setMovementId(Long movementId) {
        this.movementId = movementId;
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Gets the client.
     *
     * @return the client
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets the client.
     *
     * @param client the new client
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * Gets the account number.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber the new account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the account type.
     *
     * @return the account type
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Sets the account type.
     *
     * @param accountType the new account type
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * Gets the movement type.
     *
     * @return the movement type
     */
    public String getMovementType() {
        return movementType;
    }

    /**
     * Sets the movement type.
     *
     * @param movementType the new movement type
     */
    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    /**
     * Gets the initial balance.
     *
     * @return the initial balance
     */
    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    /**
     * Sets the initial balance.
     *
     * @param initialBalance the new initial balance
     */
    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    /**
     * Checks if is status.
     *
     * @return true, if is status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets the available balance.
     *
     * @return the available balance
     */
    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    /**
     * Sets the available balance.
     *
     * @param availableBalance the new available balance
     */
    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

}
