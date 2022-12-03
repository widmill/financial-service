package com.example.financialservice.exception;

public class TransactionTypeDoesNotExist extends RuntimeException{
    public TransactionTypeDoesNotExist(String message) {
        super(message);
    }
}
