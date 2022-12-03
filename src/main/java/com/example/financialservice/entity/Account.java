package com.example.financialservice.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long AccountId;

    @Column(name = "client_id")
    private long clientId;

    @Column(name = "account_number")
    private BigDecimal accountNumber;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "valid_until")
    private Timestamp validUntil;

    public Account(long accountId, long clientId, BigDecimal accountNumber, BigDecimal amount, String accountType, Timestamp openingDate, Timestamp validUntil) {
        AccountId = accountId;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.accountType = accountType;
        this.creationDate = openingDate;
        this.validUntil = validUntil;
    }

    public Account() {

    }

    public long getAccountId() {
        return AccountId;
    }

    public void setAccountId(long accountId) {
        AccountId = accountId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(BigDecimal accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp openingDate) {
        this.creationDate = openingDate;
    }

    public Timestamp getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Timestamp validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountId=" + AccountId +
                ", clientId=" + clientId +
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", accountType='" + accountType + '\'' +
                ", openingDate=" + creationDate +
                ", validUntil=" + validUntil +
                '}';
    }
}
