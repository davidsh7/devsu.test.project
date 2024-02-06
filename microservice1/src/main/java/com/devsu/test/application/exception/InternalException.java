package com.devsu.test.application.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * The Class InternalException.
 * 
 * @author David Sepulveda
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalException extends RuntimeException {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new internal exception.
     *
     * @param message the message
     */
    public InternalException(String message) {
        super(message);
    }
}
