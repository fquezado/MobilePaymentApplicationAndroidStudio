package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddDebitInfoActivity extends AppCompatActivity {

    private String debitCardInfo;
    private Button debitButton;

    private CreditCard creditCard;

    private ArrayList<CreditCard> cardList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_debit_info);

        debitButton = findViewById(R.id.saveDebitInfoButton);

        cardList = new ArrayList<>();
        PaymentOptionsDatabaseHelper db = new PaymentOptionsDatabaseHelper(this);

        debitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText cardNumberEditText = findViewById(R.id.debitCardNumberEditText);
                EditText cardHolderNameEditText = findViewById(R.id.debitCardHolderNameEditText);
                EditText expirationDateEditText = findViewById(R.id.debitExpirationDateEditText);
                EditText cvvEditText = findViewById(R.id.debitCVVEditText);
                String cardNumber = cardNumberEditText.getText().toString();
                String cardName = cardHolderNameEditText.getText().toString();
                String expiryDate = expirationDateEditText.getText().toString();
                String cvv = cvvEditText.getText().toString();

                if (cardNumber.isEmpty() || cardName.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty())
                {
                    Toast.makeText(AddDebitInfoActivity.this, "Fill all fields!!", Toast.LENGTH_SHORT).show();
                }
                else if (cardNumber.length() != 16)
                {
                    Toast.makeText(AddDebitInfoActivity.this, "Enter a valid card Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    creditCard = new CreditCard(cardHolderNameEditText.getText().toString(), cardNumberEditText.getText().toString(),
                            expirationDateEditText.getText().toString(), cvvEditText.getText().toString());

                    db.addCard(creditCard);
                    Intent intent = new Intent(AddDebitInfoActivity.this, ExistingPaymentsActivity.class);
                    startActivity(intent);
                }



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