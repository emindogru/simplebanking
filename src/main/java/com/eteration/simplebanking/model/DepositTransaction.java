package com.eteration.simplebanking.model;


import java.time.LocalDateTime;
import java.util.UUID;

// This class is a place holder you can change the complete implementation
public class DepositTransaction extends Transaction {


    public DepositTransaction(double amount) {
        super(amount);
        setDate(LocalDateTime.now());
        setAmount(amount);
        setType(getClass().getName());
        setApprovalCode(UUID.randomUUID().toString());
    }

    @Override
    public void execute(Account account) {
        account.deposit(getAmount());
    }
}
