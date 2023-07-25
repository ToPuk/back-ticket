package com.mxo.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(RequestValidationException.class)
    public ResponseEntity<ApiError> handleException(
        RequestValidationException requestValidationException,
        HttpServletRequest httpServletRequest
    ) {
        ApiError apiError = new ApiError(
            httpServletRequest.getRequestURI(),
            requestValidationException.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
            LocalDateTime.now()
        );
        return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiError> handleException(
        DuplicateResourceException duplicateResourceException,
        HttpServletRequest httpServletRequest
    ) {
        ApiError apiError = new ApiError(
            httpServletRequest.getRequestURI(),
            duplicateResourceException.getMessage(),
            HttpStatus.CONFLICT.value(),
            LocalDateTime.now()
        );
        return new ResponseEntity<ApiError>(apiError, HttpStatus.CONFLICT);
    }  

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleException(
        ResourceNotFoundException resourceNotFoundException,
        HttpServletRequest httpServletRequest
    ) {
        ApiError apiError = new ApiError(
            httpServletRequest.getRequestURI(),
            resourceNotFoundException.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            LocalDateTime.now()
        );
        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    }    

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<ApiError> handleException(
        InsufficientAuthenticationException insufficientAuthenticationException,
        HttpServletRequest httpServletRequest
    ) {
        ApiError apiError = new ApiError(
            httpServletRequest.getRequestURI(),
            insufficientAuthenticationException.getMessage(),
            HttpStatus.FORBIDDEN.value(),
            LocalDateTime.now()
        );
        return new ResponseEntity<ApiError>(apiError, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleException(
        BadCredentialsException exception, 
        HttpServletRequest httpServletRequest
    ) {
        ApiError apiError = new ApiError(
            httpServletRequest.getRequestURI(), 
            exception.getMessage(),
            HttpStatus.UNAUTHORIZED.value(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleException(
        HttpMessageNotReadableException httpMessageNotReadableException,
        HttpServletRequest httpServletRequest
    ) {
        ApiError apiError = new ApiError(
            httpServletRequest.getRequestURI(),
            httpMessageNotReadableException.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
            LocalDateTime.now()
        );
        return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(
        Exception exception, 
        HttpServletRequest httpServletRequest
    ) {
        ApiError apiError = new ApiError(
            httpServletRequest.getRequestURI(), 
            exception.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
