package com.eteration.simplebanking.model;

import java.util.Date;

public abstract class Transaction {

    private Date date;
    private double amount;
    private String approvalCode;

    public Transaction(double amount) {
        this.date = new Date(); // İşlem tarihi otomatik olarak oluşturulur.
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    // Her alt sınıfın implement etmesi gereken abstract metod
    public abstract void process(Account account) throws InsufficientBalanceException;
}