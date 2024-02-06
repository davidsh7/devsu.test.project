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
public class MovementUpdateRequest {

    /** The movement id. */
    @NotNull(message = "The movementId cannot be null")
    private Long movementId;

    /** The amount. */
    @NotNull(message = "The amount cannot be null")
    private BigDecimal amount;

    /**
     * Instantiates a new movement add request.
     *
     * @param movementId the movement id
     * @param accountId  the account id
     * @param amount     the amount
     */
    @JsonCreator
    public MovementUpdateRequest(@JsonProperty(value = "movementId", required = true) final Long movementId,
            @JsonProperty(value = "amount", required = true) final BigDecimal amount) {
        this.movementId = movementId;
        this.amount = amount;
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