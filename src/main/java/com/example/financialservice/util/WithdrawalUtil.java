package com.example.financialservice.util;

import java.math.BigDecimal;

public class WithdrawalUtil {

    public static boolean ifNotBelowZero(BigDecimal accountSum, BigDecimal withdrawalSum) {
        return (accountSum.subtract(withdrawalSum)).compareTo(BigDecimal.ZERO) >= 0;
    }
}
