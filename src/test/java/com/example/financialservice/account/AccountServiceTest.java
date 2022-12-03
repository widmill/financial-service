package com.example.financialservice.account;

import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.Client;
import com.example.financialservice.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Test
    public void findAccountsByClientIdTest() {
        Map<Client, List<Account>> list = accountService.findAccountByClientId(1L);
        assertThat(list).isNotEmpty();
    }
}
