package com.group4.mobilepaymentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        setContentView(R.layout.activity_pay);


        paymentMethodSpinner = findViewById(R.id.payment_method_spinner);
        populatePaymentMethodSpinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();

        if (menuId == R.id.settings) {
            Intent homeIntent = new Intent(this, SettingsActivity.class);
            startActivity(homeIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void populatePaymentMethodSpinner() {
        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<CreditCard> cards = db.getAllCards();
        ArrayList<BankAccount> bankAccounts = db.getAllBankAccounts();
        List<String> paymentOptions = new ArrayList<>();

        for (CreditCard card : cards) {
            // Format as needed, e.g., "Credit Card: [Card Number]"
            paymentOptions.add("Credit/Debit Card: " + card.getCardNumber());
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
