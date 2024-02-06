package com.devsu.test.application.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * The Class ConflictException.
 * 
 * @author David Sepulveda
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /**
     * Instantiates a new conflict exception.
     *
     * @param message the message
     */
    public ConflictException(String message) {
        super(message);
    }
}