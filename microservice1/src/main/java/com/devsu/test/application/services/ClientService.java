package com.devsu.test.application.services;

import java.util.List;

import com.devsu.test.application.requests.ClientAddRequest;
import com.devsu.test.application.requests.ClientUpdateRequest;
import com.devsu.test.application.responses.ClientIdResponse;
import com.devsu.test.application.responses.ClientResponse;


/**
 * The Class ClientService.
 *
 * @author David Sepulveda
 */
public interface ClientService {

    /**
     * Gets the client.
     *
     * @param clientId the client id
     * @return the client
     */
    ClientResponse getClient(Long clientId);


    /**
     * Adds the client.
     *
     * @param client the client
     * @return the client id response
     */
    ClientIdResponse addClient(ClientAddRequest request);
    
    
    /**
     * Update client.
     *
     * @param client the client
     */
    void updateClient(ClientUpdateRequest request);


    /**
     * Gets the all clients.
     *
     * @return the all clients
     */
    List<ClientResponse> getAllClients();


    /**
     * Delete client.
     *
     * @param client the client
     */
    void deleteClient(Long clientId);

}
