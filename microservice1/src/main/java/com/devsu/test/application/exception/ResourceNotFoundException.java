package com.devsu.test.application.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * The Class ResourceNotFoundException.
 * 
 * @author David Sepulveda
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new resource not found exception.
     *
     * @param message the message
     */
    public ResourceNotFoundException(final String message) {
        super(message);
    }

}
