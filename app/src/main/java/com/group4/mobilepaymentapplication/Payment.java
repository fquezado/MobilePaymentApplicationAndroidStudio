package com.group4.mobilepaymentapplication;

public interface Payment {
    void processPayment();
}

// CreditCard class implementing the Payment interface
class CreditCard implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card Payment");
    }
}

// DebitCard class implementing the Payment interface
class DebitCard implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing Debit Card Payment");
    }
}

// BankAccount class implementing the Payment interface
class BankAccount implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing Bank Account Payment");
    }
}

// PaymentFactory interface
interface PaymentFactory {
    Payment createPayment();
}

// Concrete CreditCardFactory class implementing the PaymentFactory interface
class CreditCardFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new CreditCard();
    }
}

// Concrete DebitCardFactory class implementing the PaymentFactory interface
class DebitCardFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new DebitCard();
    }
}

// Concrete BankAccountFactory class implementing the PaymentFactory interface
class BankAccountFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new BankAccount();
    }
}

