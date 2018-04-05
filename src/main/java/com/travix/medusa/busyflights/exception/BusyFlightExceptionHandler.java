package com.travix.medusa.busyflights.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Busy flight exception handler.
 */
@ControllerAdvice
public class BusyFlightExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusyFlightExceptionHandler.class);

    /**
     * Handle bind exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler({BindException.class})
    public ResponseEntity<?> handleBindException(BindException ex) {
        LOGGER.error("Handling BindingException with message ({}})", ex.getMessage());
        return new ResponseEntity<Object>("Bad Request", HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle method argument not valid exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        LOGGER.error("Handling MethodArgumentNotValidException with message ({}})", ex.getMessage());
        return new ResponseEntity<Object>("Bad Request", HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle http message not readable exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        LOGGER.error("Handling HttpMessageNotReadableException with message ({}})", ex.getMessage());
        return new ResponseEntity<Object>("Bad Request", HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle exception.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleException(Exception ex) {
        LOGGER.error("Handling unknown Exception of type ({}) with message ({}})", ex.getClass().getName(), ex.getMessage());
        return new ResponseEntity<Object>("Bad Request", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
