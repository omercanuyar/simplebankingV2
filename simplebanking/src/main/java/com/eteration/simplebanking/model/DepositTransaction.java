package com.eteration.simplebanking.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositTransaction extends Transaction {

    @JsonCreator
    public DepositTransaction(@JsonProperty("amount") double amount) {
        super(amount);
    }

    @Override
    public void process(Account account) {
        // Mevcut hesaba para yatırılır
        account.deposit(getAmount());
    }
}