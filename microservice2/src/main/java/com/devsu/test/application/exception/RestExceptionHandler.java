package com.devsu.test.application.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devsu.test.application.responses.ExceptionResponse;


/**
 * The Class RestExceptionHandler.
 * 
 * @author David Sepulveda
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
    /** The Constant FORMAT_COMMA. */
    private static final String FORMAT_COMMA = "%s, %s";
    
    /** The Constant FORMAT_POINTS. */
    private static final String FORMAT_POINTS = "%s: %s";
    
    /** The Constant MESSAGE_INVALID_FORMAT. */
    public static final String MESSAGE_INVALID_FORMAT = "Invalid request field(s) format";
    
    /** The Constant ERROR_BAD_REQUEST. */
    private static final String ERROR_BAD_REQUEST = "Bad Request";
    
    /**
     * Handle http message not readable.
     *
     * @param ex the ex
     * @param headers the headers
     * @param status the status
     * @param request the request
     * @return the response entity
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(@NonNull HttpMessageNotReadableException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        String message = String.format(FORMAT_POINTS, MESSAGE_INVALID_FORMAT, ex.getMessage());
        ExceptionResponse errorDetails = new ExceptionResponse(new Date(), "400", ERROR_BAD_REQUEST, message, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, headers, status);
    }
    
    /**
     * Handle method argument not valid.
     *
     * @param ex the ex
     * @param headers the headers
     * @param status the status
     * @param request the request
     * @return the response entity
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<String> errors = new ArrayList<>(fieldErrors.size() + globalErrors.size());
        String error;
        for (FieldError fieldError : fieldErrors) {
            error = String.format(FORMAT_COMMA, fieldError.getField(), fieldError.getDefaultMessage());
            errors.add(error);
        }
        for (ObjectError objectError : globalErrors) {
            error = String.format(FORMAT_COMMA, objectError.getObjectName(), objectError.getDefaultMessage());
            errors.add(error);
        }
        String message = String.format(FORMAT_POINTS, MESSAGE_INVALID_FORMAT,
                errors.stream().map(Object::toString).collect(Collectors.joining(", ")));
        ExceptionResponse errorDetails = new ExceptionResponse(new Date(), "400", ERROR_BAD_REQUEST, message, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, headers, status);
    }
    
    /**
     * Handle http media type not supported.
     *
     * @param ex the ex
     * @param headers the headers
     * @param status the status
     * @param request the request
     * @return the response entity
     */
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(@NonNull HttpMediaTypeNotSupportedException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode  status, @NonNull WebRequest request) {
        String unsupported = new StringBuilder("Unsupported content type: ").append(ex.getContentType()).toString();
        String supported = new StringBuilder("Unsupported content type: ").append(MediaType.toString(ex.getSupportedMediaTypes())).toString();
        String message = String.format(FORMAT_COMMA, unsupported, supported);
        ExceptionResponse errorDetails = new ExceptionResponse(new Date(), "415", "Unsupported Media type", message, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, headers, status);
    }
    
    /**
     * Handle access denied exception.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(new Date(), "403", "Access Denied", "Access denied", request.getDescription(false));
        return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
    
    /**
     * Handlerbad credentials exception.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handlebadCredentialsException(BadCredentialsException ex, WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(new Date(), "401", "Authentication Unauthorized", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    /**
     * Handler bad arguments exception.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(BadArgumentsException.class)
    public final ResponseEntity<Object> handleBadArgumentsException(BadArgumentsException ex, WebRequest request) {
      ExceptionResponse errorDetails = new ExceptionResponse(new Date(), "400", ERROR_BAD_REQUEST, ex.getLocalizedMessage(), request.getDescription(false));
      return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handler resource not found exception.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
         ExceptionResponse errorDetails = new ExceptionResponse(new Date(), "404", "Not Found", ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Handleglobal exception.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleglobalException(Exception ex, WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(new Date(), "500", "Internal Server Error", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * Handler conflict exception.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(ConflictException.class)
    public final ResponseEntity<Object> handleConflictException(ConflictException ex, WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(new Date(), "409", "Conflict", ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.CONFLICT);
    }

}
