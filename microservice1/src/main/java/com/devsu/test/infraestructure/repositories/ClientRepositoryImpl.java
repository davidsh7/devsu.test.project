package com.devsu.test.infraestructure.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.devsu.test.domain.models.Client;
import com.devsu.test.domain.repositories.ClientRepository;
import com.devsu.test.infraestructure.persistence.ClientContext;

/**
 * The Class ClientRepositoryImpl.
 * 
 * @author David Sepulveda
 */
@Component
public class ClientRepositoryImpl implements ClientRepository {

    /** The client context. */
    private final ClientContext clientContext;

    /**
     * Instantiates a new client repository impl.
     *
     * @param clientContext the client context
     */

    public ClientRepositoryImpl(final ClientContext clientContext) {
        this.clientContext = clientContext;
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the client
     */
    @Override
    public Client findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return this.clientContext.findById(id).orElse(null);
    }

    
    /**
     * Find by identification.
     *
     * @param identification the identification
     * @return the client
     */
    @Override
    public Client findByIdentification(String identification) {
        return this.clientContext.findByIdentification(identification);
    }
    
    /**
     * Find all.
     *
     * @return the list
     */
    @Override
    public List<Client> findAll() {
        return clientContext.findAll();
    }

    /**
     * Save.
     *
     * @param client the client
     * @return the client
     */
    @Override
    public Client save(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        return clientContext.save(client);
    }

    /**
     * Delete.
     *
     * @param client the client
     */
    @Override
    public void delete(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        this.clientContext.delete(client);
    }



}
