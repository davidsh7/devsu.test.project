package com.devsu.test.domain.repositories;

import java.time.LocalDate;
import java.util.List;

import com.devsu.test.domain.models.Movement;

/**
 * The Interface MovementRepository.
 * 
 * @author David Sepulveda
 */
public interface MovementRepository {

    /**
     * Find by id.
     *
     * @param id the id
     * @return the movement
     */
    Movement findById(Long id);

    /**
     * Find all.
     *
     * @return the list
     */
    List<Movement> findAll();

    /**
     * Save.
     *
     * @param movement the movement
     * @return the movement
     */
    Movement save(Movement movement);
    
    /**
     * Report movements by client.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @param identification the identification
     * @return the list
     */
    List<Object[]> reportMovementsByClient(LocalDate startDate, LocalDate endDate, String identification);
    
    /**
     * Delete.
     *
     * @param movement the movement
     */
    void delete(Movement movement);

}
