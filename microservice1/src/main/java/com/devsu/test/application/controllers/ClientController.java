package com.devsu.test.application.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.test.application.requests.ClientAddRequest;
import com.devsu.test.application.requests.ClientUpdateRequest;
import com.devsu.test.application.responses.ClientIdResponse;
import com.devsu.test.application.responses.ClientResponse;
import com.devsu.test.application.services.ClientService;

import jakarta.validation.Valid;

/**
 * The Class ClientController.
 */
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    /** The client service. */
    private final ClientService clientService;

    /**
     * Instantiates a new client controller.
     *
     * @param clientService the client service
     */
    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Adds the client.
     *
     * @param request the request
     * @return the client id response
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ClientIdResponse addClient(@Valid @RequestBody final ClientAddRequest request) {
        return this.clientService.addClient(request);
    }

    /**
     * Gets the client.
     *
     * @param clientId the client id
     * @return the client
     */
    @GetMapping("/{id}")
    public ClientResponse getClient(@PathVariable(value = "id") String clientId) {
        return this.clientService.getClient(Long.parseLong(clientId));
    }

    /**
     * Gets the all clients.
     *
     * @return the all clients
     */
    @GetMapping
    public List<ClientResponse> getAllClients() {
        return this.clientService.getAllClients();
    }

    /**
     * Update client.
     *
     * @param request the request
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@Valid @RequestBody final ClientUpdateRequest request) {
        this.clientService.updateClient(request);
    }

    /**
     * Delete client.
     *
     * @param clientId the client id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable(value = "id") long clientId) {
        this.clientService.deleteClient(clientId);
    }

}