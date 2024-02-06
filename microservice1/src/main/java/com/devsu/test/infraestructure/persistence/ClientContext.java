package com.devsu.test.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devsu.test.domain.models.Client;

/**
 * The Interface ClientContext.
 * 
 * @author David Sepulveda
 */
@Repository
public interface ClientContext extends JpaRepository<Client, Long> {

    /**
     * Find by identification.
     *
     * @param identification the identification
     * @return the client
     */
    @Query("SELECT c FROM Client c WHERE c.identification = :identification ")
    Client findByIdentification(@Param("identification") String identification);
}
