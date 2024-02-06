package com.devsu.test.application.services;

import java.time.LocalDate;
import java.util.List;

import com.devsu.test.application.requests.MovementAddRequest;
import com.devsu.test.application.responses.MovementResponse;

/**
 * The Interface MovementService.
 * 
 * @author David Sepulveda
 */
public interface MovementService {

    /**
     * Gets the movement.
     *
     * @param movementId the movement id
     * @return the movement
     */
    MovementResponse getMovement(Long movementId);
    
    /**
     * Adds the movement.
     *
     * @param request the request
     * @return the movement response
     */
    MovementResponse addMovement(MovementAddRequest request);

    /**
     * Gets the report movements by client.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @param identification the identification
     * @return the report movements by client
     */
    List<MovementResponse> getReportMovementsByClient(LocalDate startDate, LocalDate endDate, String identification);
    
    
    /**
     * Delete account.
     *
     * @param movementId the movement id
     */
    void deleteMovement(Long movementId);
    
}
