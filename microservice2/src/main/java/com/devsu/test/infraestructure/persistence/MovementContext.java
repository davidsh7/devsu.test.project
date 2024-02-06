package com.devsu.test.infraestructure.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devsu.test.domain.models.Movement;

/**
 * The Interface MovementContext.
 */
@Repository
public interface MovementContext extends JpaRepository<Movement, Long> {

    /**
     * Find movements by client and date range.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @param identification the identification
     * @return the list
     */
    @Query(value = "SELECT m.movementid, m.date, c.name, a.accountNumber, a.accountType, m.type, " +
            "CASE WHEN m.type = 'DEPOSIT' THEN - (m.amount - m.balance) " +
            "     WHEN m.type = 'WITHDRAWAL' THEN -(m.amount) + m.balance " +
            "     ELSE 0 " +
            "END AS initialbalance, " +
            "a.status, m.amount, m.balance " +
            "FROM movements m " +
            "INNER JOIN accounts a ON m.accountId = a.accountId " +
            "INNER JOIN clients c ON a.clientId = c.clientId " +
            "WHERE m.date BETWEEN :startDate AND :endDate AND c.identification = :identification", nativeQuery = true)
    List<Object[]> findMovementsByClientAndDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("identification") String identification);
}