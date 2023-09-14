package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import java.time.LocalDateTime;
import java.util.UUID;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(double amount) {
        super(amount);
        setDate(LocalDateTime.now());
        setAmount(amount);
        setType(getClass().getName());
        setApprovalCode(UUID.randomUUID().toString());
    }

    @Override
    public void execute(Account account) throws InsufficientBalanceException {
        account.withdraw(getAmount());
    }
}



