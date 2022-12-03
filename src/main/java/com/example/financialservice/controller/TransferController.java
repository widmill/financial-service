package com.example.financialservice.controller;

import com.example.financialservice.entity.Transaction;
import com.example.financialservice.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/client")
    public String transferBetweenClientAccounts(@RequestBody Transaction transaction) {
        return transferService.transferBetweenClientAccounts(transaction);
    }

    @PostMapping("/clients")
    public String transferBetweenClientsAccounts(@RequestBody Transaction transaction) {
        return transferService.transferBetweenClientsAccounts(transaction);
    }
}
