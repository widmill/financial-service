package com.example.financialservice.service;

import com.example.financialservice.dao.AccountDAO;
import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.Client;
import com.example.financialservice.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    private final ClientService clientService;
    private final AccountDAO accountDAO;
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    public AccountService(ClientService clientService, AccountDAO accountDAO) {
        this.clientService = clientService;
        this.accountDAO = accountDAO;
    }

    public Map<Client, List<Account>> findAccountByClientId(long id) {

        Client client = clientService.findClientById(id);

        log.info("Looking for accounts for client with {}", id);

        Map<Client, List<Account>> clientWithAccounts = new HashMap<>();
        List<Account> accounts = accountDAO.findAccountsByClientId(id);

        if (accounts.isEmpty()) {
            throw new EntityNotFoundException("Счета не были найдены.");
        }

        clientWithAccounts.put(client, accounts);

        log.info("Accounts found = {}", clientWithAccounts);

        return clientWithAccounts;
    }

    public Account findAccountById(long accountId) {

        Account account = accountDAO.findAccountById(accountId);

        if (account == null) {
            throw new EntityNotFoundException("Счет с таким индетификатором не был найден.");
        }

        return account;
    }
}
