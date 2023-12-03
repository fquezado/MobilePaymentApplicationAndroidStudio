package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddCreditInfoActivity extends AppCompatActivity {


    private String creditCardInfo;
    private Button creditButton;

    private PaymentCard paymentCard;

    private ArrayList<PaymentCard> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_credit_info);

        Button creditButton = findViewById(R.id.saveCreditInfoButton);

        cardList = new ArrayList<>();
        DatabaseHelper db = new DatabaseHelper(this);

        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText cardNumberEditText = findViewById(R.id.creditCardNumberEditText);
                EditText cardHolderNameEditText = findViewById(R.id.creditCardHolderNameEditText);
                EditText expirationDateEditText = findViewById(R.id.creditExpirationDateEditText);
                EditText cvvEditText = findViewById(R.id.creditCVVEditText);
                String cardNumber = cardNumberEditText.getText().toString();
                String cardName = cardHolderNameEditText.getText().toString();
                String expiryDate = expirationDateEditText.getText().toString();
                String cvv = cvvEditText.getText().toString();

                if (cardNumber.isEmpty() || cardName.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty())
                {
                    Toast.makeText(AddCreditInfoActivity.this, "Fill all fields!!", Toast.LENGTH_SHORT).show();
                }
                else if (cardNumber.length() != 16)
                {
                    Toast.makeText(AddCreditInfoActivity.this, "Enter a valid card Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    paymentCard = new PaymentCard(cardHolderNameEditText.getText().toString(), cardNumberEditText.getText().toString(),
                            expirationDateEditText.getText().toString(), cvvEditText.getText().toString());
                    db.addCard(paymentCard);
                    Intent intent = new Intent(AddCreditInfoActivity.this, ExistingCardsActivity.class);
                    startActivity(intent);
                }


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

