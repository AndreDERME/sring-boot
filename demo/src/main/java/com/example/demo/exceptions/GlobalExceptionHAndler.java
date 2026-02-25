package com.example.demo.exceptions;


import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHAndler {

    @ExceptionHandler (RecursoNaoEncontradoExceptions.class)
    public ResponseEntity <Object> handlerRecursoNaoEncontrado (RecursoNaoEncontradoExceptions ex) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDate.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Recurso não encontrado");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

     @ExceptionHandler (Exception.class)
    public ResponseEntity <Object> handlerGenericExption (RecursoNaoEncontradoExceptions ex) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("timestamp", LocalDate.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "ERRO NO SERVIDOR");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
