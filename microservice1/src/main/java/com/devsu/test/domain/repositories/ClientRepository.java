package com.devsu.test.domain.repositories;

import java.util.List;

import com.devsu.test.domain.models.Client;

/**
 * The Class ClientRepository.
 *
 * @author David Sepulveda
 */
public interface ClientRepository {


    /**
     * Find by id.
     *
     * @param id the id
     * @return the client
     */
    Client findById(Long id);
    
    
    /**
     * Find by identification.
     *
     * @param identification the identification
     * @return the client
     */
    Client findByIdentification(String identification);

    /**
     * Find all.
     *
     * @return the list
     */
    List<Client> findAll();


    /**
     * Save.
     *
     * @param client the client
     * @return the client
     */
    Client save(Client client);

    /**
     * Delete.
     *
     * @param client the client
     */
    void delete(Client client);

}
