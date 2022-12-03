package com.example.financialservice.controller;

import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.Client;
import com.example.financialservice.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Map<Client, List<Account>> findAccountByClientId(@PathVariable long id) {
        return accountService.findAccountByClientId(id);
    }
}
