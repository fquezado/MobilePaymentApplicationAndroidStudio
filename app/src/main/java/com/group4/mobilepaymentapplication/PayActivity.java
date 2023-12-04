package com.group4.mobilepaymentapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class PayActivity extends AppCompatActivity {

    private Spinner paymentMethodSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay); // Adjust this if your layout name is different

        paymentMethodSpinner = findViewById(R.id.payment_method_spinner);
        populatePaymentMethodSpinner();
    }

    private void populatePaymentMethodSpinner() {
        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<CreditCard> cards = db.getAllCards();
        ArrayList<BankAccount> bankAccounts = db.getAllBankAccounts();
        List<String> paymentOptions = new ArrayList<>();

        for (CreditCard card : cards) {
            // Format as needed, e.g., "Credit Card: [Card Number]"
            paymentOptions.add("Credit Card: " + card.getCardNumber());
        }

        for (BankAccount account : bankAccounts) {
            // Format as needed, e.g., "Bank Account: [Account Holder Name]"
            paymentOptions.add("Bank Account: " + account.getAccountNumber());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paymentOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentMethodSpinner.setAdapter(adapter);
    }
}
