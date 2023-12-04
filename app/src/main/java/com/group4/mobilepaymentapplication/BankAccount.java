package com.group4.mobilepaymentapplication;

// BankAccount class

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private String routingNumber;

    // Constructor
    public BankAccount(String accountHolderName, String accountNumber, String routingNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    // Getters and Setters
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }
}

