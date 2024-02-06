package com.devsu.test.infraestructure.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.devsu.test.domain.models.Movement;
import com.devsu.test.domain.repositories.MovementRepository;
import com.devsu.test.infraestructure.persistence.MovementContext;

/**
 * The Class MovementsRepositoryImpl.
 * 
 * @author David Sepulveda
 */
@Component
public class MovementsRepositoryImpl implements MovementRepository {

    /** The movement context. */
    private final MovementContext movementContext;

    /**
     * Instantiates a new movements repository impl.
     *
     * @param movementContext the movement context
     */
    public MovementsRepositoryImpl(final MovementContext movementContext) {
        this.movementContext = movementContext;
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the movement
     */
    @Override
    public Movement findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return this.movementContext.findById(id).orElse(null);
    }

    /**
     * Find all.
     *
     * @return the list
     */
    @Override
    public List<Movement> findAll() {
        return this.movementContext.findAll();
    }

    /**
     * Save.
     *
     * @param movement the movement
     * @return the movement
     */
    @Override
    public Movement save(Movement movement) {
        if (movement == null) {
            throw new IllegalArgumentException("Movement cannot be null");
        }
        return movementContext.save(movement);
    }


    /**
     * Report movements by client.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @param identification the identification
     * @return the list
     */
    @Override
    public List<Object[]> reportMovementsByClient(LocalDate startDate, LocalDate endDate, String identification) {
        return movementContext.findMovementsByClientAndDateRange(startDate, endDate, identification);
    }

    /**
     * Delete.
     *
     * @param movement the movement
     */
    @Override
    public void delete(Movement movement) {
        if (movement == null) {
            throw new IllegalArgumentException("Movement cannot be null");
        }
        this.movementContext.delete(movement);
    }

}
