package com.example.financialservice.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "transaction_type")
    private int type;

    @Column(name = "account_id")
    private long accountId;

    @Column(name = "warrant_id")
    private Long cashWarrantId;

    @Column(name = "initial_account_id")
    private Long initialAccountId;

    @Column(name = "transaction_result")
    private String result;

    public Transaction(Long transactionId, Timestamp creationDate, BigDecimal amount, int type,
                       long accountId, Long cashWarrantId, Long initialAccountId, String result) {
        this.transactionId = transactionId;
        this.creationDate = creationDate;
        this.amount = amount;
        this.type = type;
        this.accountId = accountId;
        this.cashWarrantId = cashWarrantId;
        this.initialAccountId = initialAccountId;
        this.result = result;
    }

    public Transaction() {

    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Long getCashWarrantId() {
        return cashWarrantId;
    }

    public void setCashWarrantId(Long cashWarrantId) {
        this.cashWarrantId = cashWarrantId;
    }

    public Long getInitialAccountId() {
        return initialAccountId;
    }

    public void setInitialAccountId(Long initialAccountId) {
        this.initialAccountId = initialAccountId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", creationDate=" + creationDate +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", accountId=" + accountId +
                ", cashWarrantId=" + cashWarrantId +
                ", initialAccountId=" + initialAccountId +
                ", result='" + result + '\'' +
                '}';
    }
}
