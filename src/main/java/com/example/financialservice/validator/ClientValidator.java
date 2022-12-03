package com.example.financialservice.validator;

import com.example.financialservice.entity.Client;
import com.example.financialservice.exception.EntityNotFoundException;

public class ClientValidator {

    public static void ifExists(Client client) {
        if (client == null) {
            throw new EntityNotFoundException("Клиент не был найден.");
        }
    }
}
