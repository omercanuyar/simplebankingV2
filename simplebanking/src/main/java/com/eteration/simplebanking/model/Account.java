package com.eteration.simplebanking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {

    private String owner;
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0.0; // Başlangıç bakiyesi 0 olarak ayarlanır
        this.transactions = new ArrayList<>();
    }

    public String getOwner() {
        return owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        this.balance += amount;
        // Mevcut bakiye arttıkça bir DepositTransaction kaydedilebilir
        DepositTransaction depositTransaction = new DepositTransaction(amount);
        depositTransaction.setApprovalCode(generateApprovalCode());
        transactions.add(depositTransaction);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (this.balance < amount) {
            throw new InsufficientBalanceException("Yetersiz bakiye.");
        }
        this.balance -= amount;
        // Çekim işlemi sonrası WithdrawalTransaction kaydedilebilir
        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(amount);
        withdrawalTransaction.setApprovalCode(generateApprovalCode());
        transactions.add(withdrawalTransaction);
    }

    // Bir işlem hesabın işlemlerine post edildiğinde işlenir
    public void post(Transaction transaction) throws InsufficientBalanceException {
        transaction.process(this); // İşlem türüne göre işlenir
    }

    private String generateApprovalCode() {
        // Benzersiz bir onay kodu üretme mantığı (örnek: UUID, zaman damgası vb.)
            return "APPROVED_" + UUID.randomUUID();
    }
}