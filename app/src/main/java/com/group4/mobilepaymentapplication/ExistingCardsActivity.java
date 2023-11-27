package com.group4.mobilepaymentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExistingCardsActivity extends AppCompatActivity {


    private ArrayList<PaymentCard> cardList;
    private RecyclerView recyclerView;

    private Button backButton;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_payment_methods);
        recyclerView = findViewById(R.id.recyclerCardView);
        cardList = getIntent().getParcelableArrayListExtra("cardList");
        CardPreferences.saveCards(this, cardList);
        setAdapter();

        backButton = findViewById(R.id.backButtonRecyclerView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExistingCardsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void setAdapter()
    {
        RecyclerAdapter adapter = new RecyclerAdapter(cardList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }




}
