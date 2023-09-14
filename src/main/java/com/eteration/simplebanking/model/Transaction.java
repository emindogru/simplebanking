package com.eteration.simplebanking.model;


import org.hibernate.annotations.Parent;

import javax.persistence.*;
import java.time.LocalDateTime;

// This class is a place holder you can change the complete implementation
@Entity
public class Transaction {
    private double amount;
    private LocalDateTime date;
    private String type;
    @Id
    private String approvalCode;
    @ManyToOne(targetEntity = Account.class)
    private Account account;
    public Transaction(double amount){

    }

    public Transaction() {

    }

    public void execute(Account account) throws InsufficientBalanceException{
        throw new RuntimeException("should be overridden");
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }
}