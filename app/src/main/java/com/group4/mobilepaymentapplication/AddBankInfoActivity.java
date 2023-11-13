package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBankInfoActivity extends AppCompatActivity {

    private String bankAccountInfo;
    private Button bankButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_bank_info);

        Button bankButton = findViewById(R.id.saveBankInfoButton);

        bankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBankInfo();
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
}