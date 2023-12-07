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

public class RequestActivity extends AppCompatActivity {

    private Spinner requestMethodSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        requestMethodSpinner = findViewById(R.id.request_method_spinner);
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
        List<String> requestOptions = new ArrayList<>();

        for (CreditCard card : cards) {
            // format as needed
            requestOptions.add("Credit/Debit Card: " + card.getCardNumber());
        }

        for (BankAccount account : bankAccounts) {
            // format as needed
            requestOptions.add("Bank Account: " + account.getAccountNumber());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, requestOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        requestMethodSpinner.setAdapter(adapter);
    }

}