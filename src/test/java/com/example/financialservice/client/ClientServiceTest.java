package com.example.financialservice.client;

import com.example.financialservice.entity.Client;
import com.example.financialservice.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientServiceTest {
    @Autowired
    ClientService clientService;

    public void testCreate() {
        Client client = new Client();
        client.setLastname("Ivanov");
        client.setFirstname("Ivan");
        client.setMiddleName("Ivanovich");
        client.setCode("codeword");

        clientService.createClient(client);

        assertNotNull(clientService.findClientById(client.getClientId()));

    }

    @Test
    public void readAllClientsTest() {
        List<Client> list = clientService.findAllClients();
        assertThat(list).size().isGreaterThan(0);
    }

}

