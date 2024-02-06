package com.devsu.test.application.requests;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * The Class AccountAddRequest.
 * 
 * @author David Sepulveda
 */
public class AccountAddRequest {

    /** The account number. */
    @NotNull(message = "The accountNumber cannot be null")
    @Size(min = 6, max = 12, message = "The accountNumber must be between {min} and {max} characters long")
    private String accountNumber;

    /** The account type. */
    @NotNull(message = "The accountType cannot be null")
    private AccountType accountType;

    /** The initial balance. */
    @NotNull(message = "The initialBalance cannot be null")
    private BigDecimal initialBalance;

    /** The client id. */
    @NotNull(message = "The clientId cannot be null")
    private Long clientId;

    /**
     * Instantiates a new account add request.
     *
     * @param accountNumber the account number
     * @param accountType the account type
     * @param initialBalance the initial balance
     * @param clientId the client id
     */
    @JsonCreator
    public AccountAddRequest(@JsonProperty(value = "accountNumber", required = true) final String accountNumber,
            @JsonProperty(value = "accountType", required = true) final AccountType accountType,
            @JsonProperty(value = "initialBalance", required = true) final BigDecimal initialBalance,
            @JsonProperty(value = "clientId", required = true) final Long clientId) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.clientId = clientId;
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
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets the account type.
     *
     * @param accountType the new account type
     */
    public void setAccountType(AccountType accountType) {
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