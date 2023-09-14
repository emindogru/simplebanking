package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Account implements Serializable {

    private String owner;
    private String accountNumber;
    private double balance;
    @OneToMany(targetEntity = Transaction.class,cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();
    @Id
    private String id;

    public Account(String getOwner, String accountNumber) {
        this.owner = getOwner;
        this.accountNumber = accountNumber;
        this.balance = 0.0; // Başlangıçta bakiye sıfır olacak şekilde
    }

    public Account() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        double newBalance = this.balance + amount;
        setBalance(newBalance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            double newBalance = balance - amount;
            setBalance(newBalance);
        } else {
            throw new InsufficientBalanceException("Para çekme için yeterli bakiye yok.");
        }
    }
    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void post(Transaction transaction) {
        transaction.execute(this);
        this.getTransactions().add(transaction);
    }
}
