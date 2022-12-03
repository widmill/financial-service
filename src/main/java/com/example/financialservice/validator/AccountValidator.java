package com.example.financialservice.validator;

import com.example.financialservice.entity.Account;
import com.example.financialservice.exception.EntityNotFoundException;

public class AccountValidator {

    public static void ifExists(Account account) {
        if (account == null) {
            throw new EntityNotFoundException("Счет клиента с данным идентификатором не был найден.");
        }
    }
}
