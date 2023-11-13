package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDebitInfoActivity extends AppCompatActivity {

    private String debitCardInfo;
    private Button debitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_debit_info);

        Button debitButton = findViewById(R.id.saveDebitInfoButton);

        debitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDebitInfo();
            }
        });
    }


    private void saveDebitInfo() {
        EditText cardNumberEditText = findViewById(R.id.debitCardNumberEditText);
        EditText cardHolderNameEditText = findViewById(R.id.debitCardHolderNameEditText);
        EditText expirationDateEditText = findViewById(R.id.debitExpirationDateEditText);
        EditText cvvEditText = findViewById(R.id.debitCVVEditText);

        debitCardInfo = "Card Number: " + cardNumberEditText.getText().toString() +
                "\nCardholder Name: " + cardHolderNameEditText.getText().toString() +
                "\nExpiration Date: " + expirationDateEditText.getText().toString() +
                "\nCVV: " + cvvEditText.getText().toString();

    }
}