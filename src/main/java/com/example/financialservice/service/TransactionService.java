package com.example.financialservice.service;

import com.example.financialservice.dao.TransactionDAO;
import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.Transaction;
import com.example.financialservice.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    private final TransactionDAO transactionDAO;
    private final AccountService accountService;
    private final static Logger log = LoggerFactory.getLogger(TransactionService.class);

    public TransactionService(TransactionDAO transactionDAO, AccountService accountService) {
        this.transactionDAO = transactionDAO;
        this.accountService = accountService;
    }

    public Map<Account, List<Transaction>> findTransactionByAccountId(long accountId) {

        Account account = accountService.findAccountById(accountId);

        log.info("Looking for account {}", accountId);

        Map<Account, List<Transaction>> accountWithTransactions = new HashMap<>();
        List<Transaction> transactions = transactionDAO.findTransactionsByAccountId(accountId);

        if (transactions.isEmpty()) {
            throw new EntityNotFoundException("Операции не были найдены.");
        }

        accountWithTransactions.put(account, transactions);

        log.info("Transactions found = {}", accountWithTransactions);

        return accountWithTransactions;
    }

    public void saveTransaction(Transaction transaction) {
        transactionDAO.saveTransaction(transaction);
    }

}
