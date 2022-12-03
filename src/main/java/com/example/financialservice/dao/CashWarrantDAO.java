package com.example.financialservice.dao;

import com.example.financialservice.entity.CashWarrant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CashWarrantDAO {

    private final SessionFactory sessionFactory;

    public CashWarrantDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<CashWarrant> findWarrantsByAccountId(long accountId) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(
                        "select c from CashWarrant c where c.accountId = :accountId order by c.creationDate", CashWarrant.class)
                .setParameter("accountId", accountId).getResultList();

    }

    @Transactional
    public long saveCashWarrant(CashWarrant cashWarrant) {
        Session session = sessionFactory.getCurrentSession();

        session.save(cashWarrant);

        return cashWarrant.getId();

    }
}
