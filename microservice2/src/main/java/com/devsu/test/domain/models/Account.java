package com.devsu.test.domain.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * The Class Account.
 *
 * @author David Sepulveda
 */
@Entity
@Table(name = "Accounts")
public class Account {

    /** The account id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "accounts_seq")
    @SequenceGenerator(name = "accounts_seq", sequenceName = "ACCOUNTS_SEQ", allocationSize = 1)
    @Column(name = "accountid")
    private Long accountId;

    /** The account number. */
    @Column(name = "accountnumber")
    private String accountNumber;

    /** The account type. */
    @Column(name = "accounttype")
    private String accountType;

    /** The initial balance. */
    @Column(name = "initialbalance")
    private BigDecimal initialBalance;

    /** The status. */
    @Column(name = "status")
    private boolean status;

    /** The client id. */
    @Column(name = "clientid")
    private Long clientId;

    /**
     * Instantiates a new account.
     */
    public Account() {
    }

    /**
     * Instantiates a new account.
     *
     * @param accountNumber  the account number
     * @param accountType    the account type
     * @param initialBalance the initial balance
     * @param status         the status
     * @param clientId       the client id
     */
    public Account(String accountNumber, String accountType, BigDecimal initialBalance, boolean status, Long clientId) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.status = status;
        this.clientId = clientId;
    }

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
     * Gets the status.
     *
     * @return the status
     */
    public boolean getStatus() {
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