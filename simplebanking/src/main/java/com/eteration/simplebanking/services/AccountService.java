package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    // Basit bir veri saklama yöntemi olarak bir HashMap kullanıyoruz.
    // Bu ileride bir veri tabanı ile değiştirilebilir.
    private final Map<String, Account> accountRepository = new HashMap<>();

    // Hesap oluşturup repository'ye ekleme
    public void createAccount(Account account) {
        accountRepository.put(account.getAccountNumber(), account);
    }

    // Hesabı hesap numarasına göre bulma
    public Account findAccount(String accountNumber) {
        return accountRepository.get(accountNumber);
    }

    // Hesaba para yatırma işlemi
    public void credit(String accountNumber, double amount) throws InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.post(new DepositTransaction(amount));
        }
    }

    // Hesaptan para çekme işlemi
    public void debit(String accountNumber, double amount) throws InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.post(new WithdrawalTransaction(amount));
        }
    }
}