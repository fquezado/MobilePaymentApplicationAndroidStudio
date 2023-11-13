package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPaymentActivity extends AppCompatActivity {

    private String bankAccountInfo;
    private String creditCardInfo;
    private String debitCardInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);

        Button bankButton = findViewById(R.id.saveBankInfoButton);
        Button creditButton = findViewById(R.id.saveCreditInfoButton);
        Button debitButton = findViewById(R.id.saveDebitInfoButton);

        bankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBankInfo();
            }
        });

        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCreditInfo();
            }
        });

        debitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDebitInfo();
            }
        });
    }

    private void saveBankInfo() {
        EditText accountHolderNameEditText = findViewById(R.id.bankAccountHolderNameEditText);
        EditText accountNumberEditText = findViewById(R.id.bankAccountNumberEditText);
        EditText routingNumberEditText = findViewById(R.id.bankRoutingNumberEditText);

        bankAccountInfo = "Account Holder Name: " + accountHolderNameEditText.getText().toString() +
                "\nAccount Number: " + accountNumberEditText.getText().toString() +
                "\nRouting Number: " + routingNumberEditText.getText().toString();

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
