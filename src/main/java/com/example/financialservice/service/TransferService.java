package com.example.financialservice.service;

import com.example.financialservice.constant.TransactionResults;
import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.Transaction;
import com.example.financialservice.exception.AccountDoesntBelongToClientException;
import com.example.financialservice.util.WithdrawalUtil;
import com.example.financialservice.validator.AccountValidator;
import com.example.financialservice.validator.DateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class TransferService {

    private final AccountService accountService;
    private final TransactionService transactionService;
    private static final Logger log = LoggerFactory.getLogger(TransferService.class);

    public TransferService(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    public String transferBetweenClientAccounts(Transaction transaction) {
        Account initialAccount = accountService.findAccountById(transaction.getInitialAccountId());
        Account transferAccount = accountService.findAccountById(transaction.getAccountId());
        AccountValidator.ifExists(initialAccount);
        DateValidator.checkDate(initialAccount.getCreationDate());
        AccountValidator.ifExists(transferAccount);
        DateValidator.checkDate(transferAccount.getCreationDate());

        log.info("Transfer from {} to {}", initialAccount, transferAccount);

        BigDecimal initialAmount = initialAccount.getAmount();
        BigDecimal transferAmount = transaction.getAmount();

        if (initialAccount.getClientId() != transferAccount.getClientId()) {
            throw new AccountDoesntBelongToClientException("Счет не принадлежит клиенту.");
        }

        if (WithdrawalUtil.ifNotBelowZero(initialAmount, transferAmount)) {
            initialAccount.setAmount(initialAmount.subtract(transferAmount));
            transferAccount.setAmount(transferAccount.getAmount().add(transferAmount));
            transaction.setResult(TransactionResults.SUCCESSFUL);
        } else {
            transaction.setResult(TransactionResults.NOT_ENOUGH_MONEY);
        }

        transaction.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        transactionService.saveTransaction(transaction);

        log.info("Saved transaction = {}", transaction);

        return transaction.getResult();
    }

    public String transferBetweenClientsAccounts(Transaction transaction) {
        Account initialAccount = accountService.findAccountById(transaction.getInitialAccountId());
        Account transferAccount = accountService.findAccountById(transaction.getAccountId());
        AccountValidator.ifExists(initialAccount);
        DateValidator.checkDate(initialAccount.getCreationDate());
        AccountValidator.ifExists(transferAccount);
        DateValidator.checkDate(transferAccount.getCreationDate());

        log.info("Transfer from {} to {}", initialAccount, transferAccount);

        BigDecimal initialAmount = initialAccount.getAmount();
        BigDecimal transferAmount = transaction.getAmount();

        if (WithdrawalUtil.ifNotBelowZero(initialAmount, transferAmount)) {
            initialAccount.setAmount(initialAmount.subtract(transferAmount));
            transferAccount.setAmount(transferAccount.getAmount().add(transferAmount));
            transaction.setResult(TransactionResults.SUCCESSFUL);
        } else {
            transaction.setResult(TransactionResults.NOT_ENOUGH_MONEY);
        }

        transaction.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        transactionService.saveTransaction(transaction);

        log.info("Saved transaction = {}", transaction);

        return transaction.getResult();
    }
}
