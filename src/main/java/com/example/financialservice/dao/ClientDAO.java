package com.example.financialservice.dao;

import com.example.financialservice.entity.Account;
import com.example.financialservice.entity.Client;
import com.example.financialservice.util.PasswordUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ClientDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ClientDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Client> findAllClients() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(
                "select c from Client c", Client.class).getResultList();
    }

    @Transactional
    public Client findById(long id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Client.class, id);
    }

    @Transactional
    public long save(Client client) {
        Session session = sessionFactory.getCurrentSession();

        session.save(client);

        return client.getClientId();
    }
}
