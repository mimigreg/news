package fr.michot.news.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
public class AbstractApi {
    @ExceptionHandler()
    public ResponseEntity<Exception> handleIOException(Exception ex) {
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // Utile uniquement si SpringSecurity est utilisé par annotations
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ResponseBody
    public String handleAccessDeniedFailure(AccessDeniedException exception) {
        return exception.getLocalizedMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ObjectError> handleValidationFailure(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getAllErrors();
    }

}
