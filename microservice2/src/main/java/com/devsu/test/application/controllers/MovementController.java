package com.devsu.test.application.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.test.application.requests.MovementAddRequest;
import com.devsu.test.application.responses.MovementResponse;
import com.devsu.test.application.services.MovementService;

import jakarta.validation.Valid;

/**
 * The Class MovementController.
 * 
 * @author David Sepulveda
 */
@RestController
@RequestMapping("api/movements")
public class MovementController {

    /** The movement service. */
    private final MovementService movementService;

    /**
     * Instantiates a new movement controller.
     *
     * @param movementService the movement service
     */
    public MovementController(final MovementService movementService) {
        this.movementService = movementService;
    }

    /**
     * Adds the movement.
     *
     * @param request the request
     * @return the movement response
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MovementResponse addMovement(@Valid @RequestBody final MovementAddRequest request) {
        return this.movementService.addMovement(request);
    }
    
    /**
     * Gets the movement.
     *
     * @param movementId the movement id
     * @return the movement
     */
    @GetMapping("/{id}")
    public MovementResponse getMovement(@PathVariable(value = "id") String movementId) {
        return this.movementService.getMovement(Long.parseLong(movementId));
    }

    /**
     * Delete movement.
     *
     * @param movementId the movement id
     */
    @DeleteMapping("/{id}")
    public void deleteMovement(@PathVariable(value = "id") long movementId) {
        this.movementService.deleteMovement(movementId);
    }

}