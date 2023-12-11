package com.group4.mobilepaymentapplication;

// BankAccount class

public class BankAccount {
    private int userId; // Added userId field
    private String accountHolderName;
    private String accountNumber;
    private String routingNumber;

    // Constructor
    public BankAccount(int userId, String accountHolderName, String accountNumber, String routingNumber) {
        this.userId = userId;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    // Getters and Setters

    public int getUserId() {
        return userId;
    }

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