package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText cardNumberEditText = findViewById(R.id.creditCardNumberEditText);
                EditText cardHolderNameEditText = findViewById(R.id.creditCardHolderNameEditText);
                EditText expirationDateEditText = findViewById(R.id.creditExpirationDateEditText);
                EditText cvvEditText = findViewById(R.id.creditCVVEditText);

                paymentCard = new PaymentCard(cardHolderNameEditText.getText().toString(), cardNumberEditText.getText().toString(),
                        expirationDateEditText.getText().toString(), cvvEditText.getText().toString());
                cardList.add(paymentCard);
                Intent intent = new Intent(AddCreditInfoActivity.this, ExistingCardsActivity.class);
                intent.putExtra("cardList", cardList);
                startActivity(intent);
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

