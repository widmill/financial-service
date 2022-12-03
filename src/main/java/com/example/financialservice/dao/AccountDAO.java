package com.example.financialservice.dao;

import com.example.financialservice.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AccountDAO {

    private final SessionFactory sessionFactory;

    public AccountDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Account findAccountById(long accountId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Account.class, accountId);

    }

    @Transactional
    public List<Account> findAccountsByClientId(long clientId) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(
                        "select a from Account a where a.clientId = :clientId order by a.creationDate", Account.class)
                .setParameter("clientId", clientId).getResultList();

    }
}
