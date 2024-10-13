package com.eteration.simplebanking.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WithdrawalTransaction extends Transaction {

    @JsonCreator
    public WithdrawalTransaction(@JsonProperty("amount") double amount) {
        super(amount); // Transaction sınıfının constructor'ını çağırır
    }

    @Override
    public void process(Account account) throws InsufficientBalanceException {
        // Hesaptan para çekilir, yetersiz bakiye varsa exception fırlatır
        account.withdraw(getAmount());
    }
}