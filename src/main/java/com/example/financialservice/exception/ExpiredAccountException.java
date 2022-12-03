package com.example.financialservice.exception;

public class ExpiredAccountException extends RuntimeException{
    public ExpiredAccountException(String message) {
        super(message);
    }
}
