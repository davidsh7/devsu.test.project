package com.devsu.test.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.test.application.exception.ConflictException;
import com.devsu.test.application.exception.ResourceNotFoundException;
import com.devsu.test.application.requests.ClientAddRequest;
import com.devsu.test.application.requests.ClientUpdateRequest;
import com.devsu.test.application.responses.ClientIdResponse;
import com.devsu.test.application.responses.ClientResponse;
import com.devsu.test.domain.models.Client;
import com.devsu.test.domain.repositories.ClientRepository;

/**
 * The Class ClientServiceImpl.
 *
 * @author David Sepulveda
 */
@Service
public class ClientServiceImpl implements ClientService {

    /** The Constant CLIENT. */
    private static final String CLIENT = "Client ";

    /** The Constant CLIENT_NOT_FOUND. */
    private static final String CLIENT_NOT_FOUND = " not found";
    
    private static final String CLIENT_EXISTING = " existing";

    /** The client repository. */
    private final ClientRepository clientRepository;

    /**
     * Instantiates a new client service impl.
     *
     * @param clientRepository the client repository
     */
    public ClientServiceImpl(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Gets the client.
     *
     * @param clientId the client id
     * @return the client
     */
    @Override
    public ClientResponse getClient(Long clientId) {
        Client client = this.clientRepository.findById(clientId);
        if (client == null) {
            throw new ResourceNotFoundException(
                    new StringBuilder().append(CLIENT).append(clientId).append(CLIENT_NOT_FOUND).toString());
        }
        ClientResponse response = new ClientResponse();
        response.setClientId(client.getClientId());
        response.setName(client.getName());
        response.setGender(client.getGender());
        response.setAge(client.getAge());
        response.setIdentification(client.getIdentification());
        response.setAddress(client.getAddress());
        response.setPhone(client.getPhone());
        response.setStatus(client.getStatus());
        return response;
    }

    /**
     * Adds the client.
     *
     * @param request the request
     * @return the client id response
     */
    @Override
    public ClientIdResponse addClient(ClientAddRequest request) {
        
        Client client = this.clientRepository.findByIdentification(request.getIdentification());
        
        if (client != null) {
            throw new ConflictException(new StringBuilder().append(CLIENT).append(request.getIdentification())
                    .append(CLIENT_EXISTING).toString());
        }
        
        ClientIdResponse clientIdDto = new ClientIdResponse();
        client = new Client();
        client.setName(request.getName());
        client.setGender(request.getGender().name());
        client.setAge(request.getAge());
        client.setIdentification(request.getIdentification());
        client.setAddress(request.getAddress());
        client.setPhone(request.getPhone());
        client.setPassword(request.getPassword());
        client.setStatus(true);
        client = this.clientRepository.save(client);
        clientIdDto.setClientId(client.getClientId());
        return clientIdDto;
    }

    /**
     * Update client.
     *
     * @param request the request
     */
    @Override
    public void updateClient(ClientUpdateRequest request) {
        Long clientId = request.getClientId();
        Client client = this.clientRepository.findById(clientId);
        if (client == null) {
            throw new ResourceNotFoundException(
                    new StringBuilder().append(CLIENT).append(clientId).append(CLIENT_NOT_FOUND).toString());
        }
        client.setClientId(request.getClientId());
        client.setName(request.getName());
        client.setGender(request.getGender().name());
        client.setAge(request.getAge());
        client.setIdentification(request.getIdentification());
        client.setAddress(request.getAddress());
        client.setPhone(request.getPhone());
        client.setPassword(request.getPassword());
        client.setStatus(request.getStatus());
        this.clientRepository.save(client);
    }

    /**
     * Delete client.
     *
     * @param clientId the client id
     */
    @Override
    public void deleteClient(Long clientId) {
        Client client = this.clientRepository.findById(clientId);
        if (client == null) {
            throw new ResourceNotFoundException(
                    new StringBuilder().append(CLIENT).append(clientId).append(CLIENT_NOT_FOUND).toString());
        }

        this.clientRepository.delete(client);
    }

    /**
     * Gets the all clients.
     *
     * @return the all clients
     */
    @Override
    public List<ClientResponse> getAllClients() {
        List<Client> listClients = this.clientRepository.findAll();
        return listClients.stream().map(client -> {
            ClientResponse response = new ClientResponse();
            response.setClientId(client.getClientId());
            response.setName(client.getName());
            response.setGender(client.getGender());
            response.setAge(client.getAge());
            response.setIdentification(client.getIdentification());
            response.setAddress(client.getAddress());
            response.setPhone(client.getPhone());
            response.setStatus(client.getStatus());
            return response;
        }).toList();
    }

}