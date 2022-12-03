package com.example.financialservice.controller;

import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.CashWarrant;
import com.example.financialservice.exception.EntityNotFoundException;
import com.example.financialservice.service.CashWarrantService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/warrants")
public class CashWarrantController {

    public final CashWarrantService cashWarrantService;

    public CashWarrantController(CashWarrantService cashWarrantService) {
        this.cashWarrantService = cashWarrantService;
    }

    @GetMapping("/{accountId}")
    public Map<Account, List<CashWarrant>> findWarrantsByAccountId(@PathVariable long accountId) {
        return cashWarrantService.findWarrantsByAccountId(accountId);
    }

    @PostMapping
    public String createCashWarrant(@RequestBody CashWarrant cashWarrant) {

        return cashWarrantService.createCashWarrant(cashWarrant);
    }
}
