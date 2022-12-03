package com.example.financialservice.controller;


import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.Transaction;
import com.example.financialservice.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{accountId}")
    Map<Account, List<Transaction>> findTransactionByAccountId(@PathVariable long accountId) {
        return transactionService.findTransactionByAccountId(accountId);
    }
}
