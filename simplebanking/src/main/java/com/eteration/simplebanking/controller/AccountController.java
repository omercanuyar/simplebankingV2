package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This class is a placeholder you can change the complete implementation
@RestController
@RequestMapping("/account/v1")
public class AccountController {

    private final AccountService accountService;

    // Constructor injection
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, @RequestBody DepositTransaction depositTransaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        account.post(depositTransaction);
        TransactionStatus status = new TransactionStatus("OK", depositTransaction.getApprovalCode());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, @RequestBody WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountNumber);
        account.post(withdrawalTransaction);
        TransactionStatus status = new TransactionStatus("OK", withdrawalTransaction.getApprovalCode());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        Account account = accountService.findAccount(accountNumber);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}