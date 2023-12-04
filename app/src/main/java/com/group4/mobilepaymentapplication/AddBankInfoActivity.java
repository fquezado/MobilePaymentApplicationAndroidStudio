package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class AddBankInfoActivity extends AppCompatActivity {

    private Button bankButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_bank_info);

        bankButton = findViewById(R.id.saveBankInfoButton);

        bankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText accountHolderNameEditText = findViewById(R.id.bankAccountHolderNameEditText);
                EditText accountNumberEditText = findViewById(R.id.bankAccountNumberEditText);
                EditText routingNumberEditText = findViewById(R.id.bankRoutingNumberEditText);

                String accountHolderName = accountHolderNameEditText.getText().toString();
                String accountNumber = accountNumberEditText.getText().toString();
                String routingNumber = routingNumberEditText.getText().toString();

                if (accountHolderName.isEmpty() || accountNumber.isEmpty() || routingNumber.isEmpty()) {
                    Toast.makeText(AddBankInfoActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                } else if (accountNumber.length() != 12) {
                    Toast.makeText(AddBankInfoActivity.this, "Enter a valid account number", Toast.LENGTH_SHORT).show();
                } else if (routingNumber.length() != 12) {
                    Toast.makeText(AddBankInfoActivity.this, "Enter a valid routing number", Toast.LENGTH_SHORT).show();
                } else {
                    BankAccount account = new BankAccount(accountHolderName, accountNumber, routingNumber);
                    DatabaseHelper db = new DatabaseHelper(AddBankInfoActivity.this);
                    db.addBankAccount(account);
                    Toast.makeText(AddBankInfoActivity.this, "Bank account added successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddBankInfoActivity.this, ExistingPaymentsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void saveBankInfo() {
        EditText accountHolderNameEditText = findViewById(R.id.bankAccountHolderNameEditText);
        EditText accountNumberEditText = findViewById(R.id.bankAccountNumberEditText);
        EditText routingNumberEditText = findViewById(R.id.bankRoutingNumberEditText);

        String accountHolderName = accountHolderNameEditText.getText().toString();
        String accountNumber = accountNumberEditText.getText().toString();
        String routingNumber = routingNumberEditText.getText().toString();

        BankAccount account = new BankAccount(accountHolderName, accountNumber, routingNumber);
        DatabaseHelper db = new DatabaseHelper(this);
        db.addBankAccount(account);
    }

}