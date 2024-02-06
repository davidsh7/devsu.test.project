package com.devsu.test.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * The Class Movement.
 */
@Entity
@Table(name = "Movements")
public class Movement {

    /** The movement id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "movements_seq")
    @SequenceGenerator(name = "movements_seq", sequenceName = "MOVEMENTS_SEQ", allocationSize = 1)
    @Column(name = "movementid")
    private Long movementId;

    /** The date. */
    @Column(name = "date")
    private LocalDateTime date;

    /** The type. */
    @Column(name = "type")
    private String type;

    /** The amount. */
    @Column(name = "amount")
    private BigDecimal amount;

    /** The balance. */
    @Column(name = "balance")
    private BigDecimal balance;

    /** The account id. */
    @Column(name = "accountid")
    private Long accountId;

    /**
     * On create.
     */
    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }

    /**
     * Instantiates a new movement.
     */
    public Movement() {
    }

    /**
     * Instantiates a new movement.
     *
     * @param type the type
     * @param amount the amount
     * @param balance the balance
     * @param accountId the account id
     */
    public Movement(String type, BigDecimal amount, BigDecimal balance, Long accountId) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.accountId = accountId;
    }

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
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
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
     * Gets the balance.
     *
     * @return the balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Sets the balance.
     *
     * @param balance the new balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

}