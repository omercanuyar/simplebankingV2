package com.eteration.simplebanking.model;

public class BillPaymentTransaction extends Transaction {

    private String payee;

    public BillPaymentTransaction(double amount, String payee) {
        super(amount);
        this.payee = payee;
    }

    public String getPayee() {
        return payee;
    }

    @Override
    public void process(Account account) throws InsufficientBalanceException {

        if (account.getBalance() >= this.getAmount()) {
            account.setBalance(account.getBalance() - this.getAmount());
        } else {
            throw new InsufficientBalanceException("Insufficient balance for bill payment to " + payee);
        }
    }
}
