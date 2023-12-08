package com.group4.mobilepaymentapplication;

public class Transaction {
    private int id;
    private String amount;
    private String paymentMethod;
    private String date;

    public Transaction(String amount, String paymentMethod, String date) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    // Getters
    public String getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getDate() {
        return date;
    }

    // Setters (if needed)
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
