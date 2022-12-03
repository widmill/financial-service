package com.example.financialservice.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "cash_warrant")
public class CashWarrant {

    @Id
    @Column(name = "warrant_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "warrant_type")
    //0 - снятие, 1 - пополнение
    private int type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "account_id")
    private long accountId;

    @Column(name = "warrant_result")
    private String result;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    public CashWarrant(long id, int type, BigDecimal amount, long accountId, String result, Timestamp creationDate) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.accountId = accountId;
        this.result = result;
        this.creationDate = creationDate;
    }

    public CashWarrant() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "CashWarrant{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", accountId=" + accountId +
                ", result='" + result + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
