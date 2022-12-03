package com.example.financialservice.service;

import com.example.financialservice.dao.ClientDAO;
import com.example.financialservice.entity.Client;
import com.example.financialservice.util.PasswordUtil;
import com.example.financialservice.validator.ClientValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ClientService {

    private final ClientDAO clientDAO;
    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public List<Client> findAllClients() {
        log.info("Looking for all clients.");

        return clientDAO.findAllClients();
    }

    public Client findClientById(long id) {
        log.info("Looking for client with id = {}", id);

        Client client = clientDAO.findById(id);

        ClientValidator.ifExists(client);

        log.info("Found = {}", client);

        return client;
    }

    public long createClient(Client client) {
        log.info("Creating client = {}", client);

        client.setCode(PasswordUtil
        .hashThePlainTextPassword(client.getCode(), PasswordUtil.generateSalt(5)
        .get())
        .get());

        return clientDAO.save(client);
    }
}
