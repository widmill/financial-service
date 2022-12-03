package com.example.financialservice.controller;

import com.example.financialservice.entity.Client;
import com.example.financialservice.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable long id) {
        return clientService.findClientById(id);
    }

    @PostMapping
    public long createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }
}
