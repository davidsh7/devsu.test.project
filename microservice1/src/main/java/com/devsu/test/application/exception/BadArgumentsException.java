package com.devsu.test.application.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * The Class BadArgumentsException.
 * 
 * @author David Sepulveda
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadArgumentsException  extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /**
     * Instantiates a new bad arguments exception.
     *
     * @param message the message
     */
    public BadArgumentsException (String message) {
        super(message);
    }
}
