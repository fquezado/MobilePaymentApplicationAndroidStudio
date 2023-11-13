package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCreditInfoActivity extends AppCompatActivity {


    private String creditCardInfo;
    private Button creditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_credit_info);

        Button creditButton = findViewById(R.id.saveCreditInfoButton);

        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCreditInfo();
            }
        });
    }

    private void saveCreditInfo() {
        EditText cardNumberEditText = findViewById(R.id.creditCardNumberEditText);
        EditText cardHolderNameEditText = findViewById(R.id.creditCardHolderNameEditText);
        EditText expirationDateEditText = findViewById(R.id.creditExpirationDateEditText);
        EditText cvvEditText = findViewById(R.id.creditCVVEditText);

        creditCardInfo = "Card Number: " + cardNumberEditText.getText().toString() +
                "\nCardholder Name: " + cardHolderNameEditText.getText().toString() +
                "\nExpiration Date: " + expirationDateEditText.getText().toString() +
                "\nCVV: " + cvvEditText.getText().toString();

    }
}

