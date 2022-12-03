package com.example.financialservice.transaction;

import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.Transaction;
import com.example.financialservice.service.TransactionService;
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
public class TransactionServiceTest {

    @Autowired
    TransactionService transactionService;

    @Test
    public void findAllTransactionsByAccountIdTest() {
        Map<Account, List<Transaction>> list = transactionService.findTransactionByAccountId(1L);

        assertThat(list).isNotEmpty();

    }
}
