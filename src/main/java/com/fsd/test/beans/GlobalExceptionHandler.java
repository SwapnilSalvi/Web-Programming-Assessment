package com.fsd.test.beans;

import com.fsd.test.exceptions.EntityAlredyExistException;
import com.fsd.test.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException) {
        Map<String,Object> response = new HashMap<>();
        response.put("message", entityNotFoundException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityAlredyExistException.class})
    public ResponseEntity<Object> handleEntityAlreadyExistException(EntityAlredyExistException entityAlredyExistException) {
        Map<String,Object> response = new HashMap<>();
        response.put("message", entityAlredyExistException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException runtimeException) {
        Map<String,Object> response = new HashMap<>();
        response.put("message", runtimeException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
