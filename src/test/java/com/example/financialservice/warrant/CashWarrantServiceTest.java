package com.example.financialservice.warrant;

import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.CashWarrant;
import com.example.financialservice.service.CashWarrantService;
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
public class CashWarrantServiceTest {

    @Autowired
    CashWarrantService cashWarrantService;

    @Test
    public void findAllTransactionsByAccountIdTest() {
        Map<Account, List<CashWarrant>> list = cashWarrantService.findWarrantsByAccountId(1L);

        assertThat(list).isNotEmpty();

    }
}
