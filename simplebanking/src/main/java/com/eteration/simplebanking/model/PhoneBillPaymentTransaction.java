package com.eteration.simplebanking.model;

public class PhoneBillPaymentTransaction extends BillPaymentTransaction {

    private String phoneNumber;

    public PhoneBillPaymentTransaction(double amount, String payee, String phoneNumber) {
        super(amount, payee);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
