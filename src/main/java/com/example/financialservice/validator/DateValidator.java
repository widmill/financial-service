package com.example.financialservice.validator;

import com.example.financialservice.exception.ExpiredAccountException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateValidator {

    public static void checkDate(Timestamp date) {
        if (date.after(Timestamp.valueOf(LocalDateTime.now()))) {
            throw new ExpiredAccountException("Срок действия счета истёк");
        }
    }
}
