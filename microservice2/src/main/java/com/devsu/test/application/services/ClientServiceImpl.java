package com.devsu.test.application.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.devsu.test.application.exception.ConflictException;
import com.devsu.test.application.exception.InternalException;
import com.devsu.test.application.exception.ResourceNotFoundException;
import com.devsu.test.application.responses.ClientResponse;

/**
 * The Class ClientServiceImpl.
 * 
 * @author David Sepulveda
 */
@Service
public class ClientServiceImpl {

    /** The Constant CLIENT. */
    private static final String CLIENT = "Client ";

    /** The Constant CLIENT_NOT_FOUND. */
    private static final String CLIENT_NOT_FOUND = " not found";
    
    /** The Constant CLIENT_INACTIVE. */
    private static final String CLIENT_INACTIVE = " is inactive";

    /** The Constant ERROR_CLIENT. */
    private static final String ERROR_CLIENT = "Error consulting client";

    /** The microservice 1 url. */
    @Value("${microservice1.url}")
    private String microservice1Url;

    /** The rest template. */
    private final RestTemplate restTemplate;

    /** The logger. */
    private Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    /**
     * Instantiates a new client service impl.
     *
     * @param restTemplate the rest template
     */
    public ClientServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Validate client existence.
     *
     * @param clientId the client id
     * @return the client response
     */
    @SuppressWarnings("deprecation")
    public ClientResponse validateClientExistence(Long clientId) {
        String url = microservice1Url + "/api/clients/" + clientId;

        try {
            ClientResponse clientResponse = restTemplate.getForObject(url, ClientResponse.class);
            
            if (clientResponse == null) {
                throw new ResourceNotFoundException(new StringBuilder().append(CLIENT)
                        .append(clientId)
                        .append(CLIENT_NOT_FOUND)
                        .toString());
            }
            
            if(!clientResponse.isStatus()) {
                throw new ConflictException(new StringBuilder().append(CLIENT)
                        .append(clientId)
                        .append(CLIENT_INACTIVE)
                        .toString());
            }

            return clientResponse;
        } catch (HttpClientErrorException ex) {
            if (ex.getRawStatusCode() == 404) {
                throw new ResourceNotFoundException(new StringBuilder().append(CLIENT)
                        .append(clientId)
                        .append(CLIENT_NOT_FOUND)
                        .toString());
            } else {
                logger.error(ex.getMessage());
                throw new InternalException(ERROR_CLIENT);
            }
        }

    }
}