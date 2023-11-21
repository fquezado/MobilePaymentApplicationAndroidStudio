package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddDebitInfoActivity extends AppCompatActivity {

    private String debitCardInfo;
    private Button debitButton;

    private PaymentCard paymentCard;

    private ArrayList<PaymentCard> cardList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_debit_info);

        debitButton = findViewById(R.id.saveDebitInfoButton);

        debitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText cardNumberEditText = findViewById(R.id.debitCardNumberEditText);
                EditText cardHolderNameEditText = findViewById(R.id.debitCardHolderNameEditText);
                EditText expirationDateEditText = findViewById(R.id.debitExpirationDateEditText);
                EditText cvvEditText = findViewById(R.id.debitCVVEditText);

                cardList = new ArrayList<>();
                paymentCard = new PaymentCard(cardHolderNameEditText.getText().toString(), cardNumberEditText.getText().toString(),
                        expirationDateEditText.getText().toString(), cvvEditText.getText().toString());
                cardList.add(paymentCard);
                Intent intent = new Intent(AddDebitInfoActivity.this, ExistingCardsActivity.class);
                intent.putExtra("cardList", cardList);
                startActivity(intent);
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