package com.devsu.test.application.responses;

import java.util.Date;

/**
 * The Class ErrorDetails.
 * 
 * @author David Sepulveda
 */
public class ExceptionResponse {

    /** The timestamp. */
    private Date timestamp;

    /** The status. */
    private String status;

    /** The error. */
    private String error;

    /** The message. */
    private String message;

    /** The details. */
    private String path;

    /**
     * Instantiates a new error details.
     *
     * @param timestamp the timestamp
     * @param status the status
     * @param error the error
     * @param message   the message
     * @param path      the path
     */
    public ExceptionResponse(Date timestamp, String status, String error, String message, String path) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path.replace("uri=", "");
    }

    /**
     * Gets the timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the error.
     *
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the details.
     *
     * @return the details
     */
    public String getPath() {
        return path;
    }
}
