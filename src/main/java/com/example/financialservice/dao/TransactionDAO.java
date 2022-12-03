package com.example.financialservice.dao;

import com.example.financialservice.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TransactionDAO {

    private final SessionFactory sessionFactory;

    public TransactionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Transaction> findTransactionsByAccountId(long accountId) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(
                        "select t from Transaction t where t.accountId = :accountId order by t.creationDate", Transaction.class)
                .setParameter("accountId", accountId).getResultList();

    }

    @Transactional
    public void saveTransaction(Transaction transaction) {
        Session session = sessionFactory.getCurrentSession();

        session.save(transaction);
    }
}
