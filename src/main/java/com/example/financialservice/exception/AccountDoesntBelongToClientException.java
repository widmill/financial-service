package com.example.financialservice.exception;

public class AccountDoesntBelongToClientException extends RuntimeException{
    public AccountDoesntBelongToClientException(String message) {
        super(message);
    }
}
