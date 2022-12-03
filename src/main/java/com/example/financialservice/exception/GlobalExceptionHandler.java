package com.example.financialservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public Object entityNotFoundHandler(EntityNotFoundException ex) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());
        body.put("code", HttpURLConnection.HTTP_NOT_FOUND);

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionTypeDoesNotExist.class)
    public Object wrongTransactionTypeHandler(TransactionTypeDoesNotExist ex) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());
        body.put("code", HttpURLConnection.HTTP_BAD_REQUEST);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(AccountDoesntBelongToClientException.class)
    public Object accountOwnHandler(AccountDoesntBelongToClientException ex) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());
        body.put("code", HttpURLConnection.HTTP_BAD_REQUEST);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredAccountException.class)
    public Object expiredAccountHandler(ExpiredAccountException ex) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("message", ex.getMessage());
        body.put("timestamp", LocalDateTime.now());
        body.put("code", HttpURLConnection.HTTP_BAD_REQUEST);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}

