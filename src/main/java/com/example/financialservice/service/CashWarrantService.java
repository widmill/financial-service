package com.example.financialservice.service;

import com.example.financialservice.constant.CashWarrantTypes;
import com.example.financialservice.constant.TransactionResults;
import com.example.financialservice.dao.CashWarrantDAO;
import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.CashWarrant;
import com.example.financialservice.entity.Transaction;
import com.example.financialservice.exception.EntityNotFoundException;
import com.example.financialservice.exception.TransactionTypeDoesNotExist;
import com.example.financialservice.util.WithdrawalUtil;
import com.example.financialservice.validator.AccountValidator;
import com.example.financialservice.validator.DateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CashWarrantService {

    private final CashWarrantDAO cashWarrantDAO;
    private final AccountService accountService;
    private final TransactionService transactionService;
    private final ClientService clientService;

    private final static Logger log = LoggerFactory.getLogger(TransactionService.class);

    public CashWarrantService(CashWarrantDAO cashWarrantDAO, AccountService accountService,
                              TransactionService transactionService, ClientService clientService) {
        this.cashWarrantDAO = cashWarrantDAO;
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.clientService = clientService;
    }

    public Map<Account, List<CashWarrant>> findWarrantsByAccountId(long accountId) {

        Account account = accountService.findAccountById(accountId);

        log.info("Looking for warrant {}", accountId);

        Map<Account, List<CashWarrant>> accountWithWarrants = new HashMap<>();
        List<CashWarrant> warrants = cashWarrantDAO.findWarrantsByAccountId(accountId);

        if (warrants.isEmpty()) {
            throw new EntityNotFoundException("Чеки для этого счета не были найдены.");
        }

        accountWithWarrants.put(account, warrants);

        log.info("Cash warrants found = {}", accountWithWarrants);

        return accountWithWarrants;
    }

    public String createCashWarrant(CashWarrant cashWarrant) {
        Account account = accountService.findAccountById(cashWarrant.getAccountId());
        AccountValidator.ifExists(account);
        DateValidator.checkDate(account.getCreationDate());
        BigDecimal accountSum = account.getAmount();
        BigDecimal warrantSum = cashWarrant.getAmount();

        if (cashWarrant.getType() == CashWarrantTypes.WITHDRAWAL) {

            if (WithdrawalUtil.ifNotBelowZero(accountSum, warrantSum)) {
                account.setAmount((accountSum.subtract(warrantSum)));
                cashWarrant.setResult(TransactionResults.SUCCESSFUL);
            } else {
                cashWarrant.setResult(TransactionResults.NOT_ENOUGH_MONEY);
            }

        } else if (cashWarrant.getType() == CashWarrantTypes.REPLENISHMENT) {
            account.setAmount(accountSum.add(warrantSum));
            cashWarrant.setResult(TransactionResults.SUCCESSFUL);
        } else {
            throw new TransactionTypeDoesNotExist("Данный тип транзакций не поддерживается.");
        }

        cashWarrant.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        cashWarrantDAO.saveCashWarrant(cashWarrant);

        Transaction transaction = new Transaction(null, cashWarrant.getCreationDate(), warrantSum, cashWarrant.getType(),
                cashWarrant.getAccountId(), cashWarrant.getId(), null, cashWarrant.getResult());

        transactionService.saveTransaction(transaction);

        return cashWarrant.getResult();
    }
}
