package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPaymentActivity extends AppCompatActivity {

    private Button addCreditButton;
    private Button addDebitButton;
    private Button addBankAccountButton;

    private Button backButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);

        Button addCreditButton = findViewById(R.id.addCreditButton);
        Button addDebitButton = findViewById(R.id.addDebitButton);
        Button addBankAccountButton = findViewById(R.id.addBankAccountButton);
        Button backButton = findViewById(R.id.backButton);


        addCreditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPaymentActivity.this, AddCreditInfoActivity.class);
                startActivity(intent);
            }
        });

        addDebitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPaymentActivity.this, AddDebitInfoActivity.class);
                startActivity(intent);
            }
        });

        addBankAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPaymentActivity.this, AddBankInfoActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPaymentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }
        );


    }
}
/*


        Button bankButton = findViewById(R.id.saveBankInfoButton);

        bankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBankInfo();
            }
        });


    private void saveBankInfo() {
        EditText accountHolderNameEditText = findViewById(R.id.bankAccountHolderNameEditText);
        EditText accountNumberEditText = findViewById(R.id.bankAccountNumberEditText);
        EditText routingNumberEditText = findViewById(R.id.bankRoutingNumberEditText);

        bankAccountInfo = "Account Holder Name: " + accountHolderNameEditText.getText().toString() +
                "\nAccount Number: " + accountNumberEditText.getText().toString() +
                "\nRouting Number: " + routingNumberEditText.getText().toString();

    }


 */
