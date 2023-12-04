package com.group4.mobilepaymentapplication;

public interface Payment {
    void processPayment();
}

// CreditCardInfo class implementing the Payment interface
class CreditCardInfo implements Payment {
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
class BankAccountInfo implements Payment {
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
        return new CreditCardInfo();
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
        return new BankAccountInfo();
    }
}

