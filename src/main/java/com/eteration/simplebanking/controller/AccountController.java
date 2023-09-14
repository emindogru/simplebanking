package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// This class is a place holder you can change the complete implementation
@RestController("/v1")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable("accountNumber") String accountId, @RequestBody DepositTransaction transaction) {
        Account account = service.findAccount(accountId);
        account.deposit(transaction.getAmount());
        TransactionStatus status = new TransactionStatus("OK");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable("accountNumber") String accountId, @RequestBody WithdrawalTransaction transaction) {
        Account account = service.findAccount(accountId);
        account.withdraw(transaction.getAmount());
        TransactionStatus status = new TransactionStatus("OK");
        return new ResponseEntity<>(status, HttpStatus.OK);


    }
    public ResponseEntity<Account> getAccount(String accountId) {
        Account account = service.findAccount(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

}