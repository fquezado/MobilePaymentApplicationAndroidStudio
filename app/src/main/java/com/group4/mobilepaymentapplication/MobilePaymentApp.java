package com.group4.mobilepaymentapplication;

// Client code
public class MobilePaymentApp {
    public static void main(String[] args) {
        // Create CreditCard payment
        PaymentFactory creditCardFactory = new CreditCardFactory();
        Payment creditCardPayment = creditCardFactory.createPayment();
        creditCardPayment.processPayment();

        // Create DebitCard payment
        PaymentFactory debitCardFactory = new DebitCardFactory();
        Payment debitCardPayment = debitCardFactory.createPayment();
        debitCardPayment.processPayment();

        // Create BankAccount payment
        PaymentFactory bankAccountFactory = new BankAccountFactory();
        Payment bankAccountPayment = bankAccountFactory.createPayment();
        bankAccountPayment.processPayment();
    }
}
