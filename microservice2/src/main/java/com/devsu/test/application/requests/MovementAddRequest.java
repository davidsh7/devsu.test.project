package com.devsu.test.application.requests;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * The Class MovementAddRequest.
 * 
 * @author David Sepulveda
 */
public class MovementAddRequest {

    /** The account id. */
    @NotNull(message = "The accountId cannot be null")
    private Long accountId;

    /** The amount. */
    @NotNull(message = "The amount cannot be null")
    private BigDecimal amount;

    /**
     * Instantiates a new movement add request.
     *
     * @param accountId the account id
     * @param amount the amount
     */
    @JsonCreator
    public MovementAddRequest(@JsonProperty(value = "accountId", required = true) final Long accountId,
            @JsonProperty(value = "amount", required = true) final BigDecimal amount) {
        this.accountId = accountId;
        this.amount = amount;
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
}