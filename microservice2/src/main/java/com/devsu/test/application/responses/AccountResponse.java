package com.devsu.test.application.responses;

import java.math.BigDecimal;

/**
 * The Class AccountResponse.
 * 
 * @author David Sepulveda
 */
public class AccountResponse {

    /** The account id. */
    private Long accountId;

    /** The account number. */
    private String accountNumber;

    /** The account type. */
    private String accountType;

    /** The initial balance. */
    private BigDecimal initialBalance;

    /** The status. */
    private boolean status;

    /** The client id. */
    private Long clientId;

    /**
     * Gets the account id.
     *
     * @return the account id
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the account id.
     *
     * @param accountId the new account id
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
     * Gets the client id.
     *
     * @return the client id
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * Sets the client id.
     *
     * @param clientId the new client id
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

}