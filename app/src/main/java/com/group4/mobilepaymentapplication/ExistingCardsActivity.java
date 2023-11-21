package com.group4.mobilepaymentapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExistingCardsActivity extends AppCompatActivity {


    private ArrayList<PaymentCard> cardList;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_payment_methods);
        recyclerView = findViewById(R.id.recyclerCardView);
        cardList = getIntent().getParcelableArrayListExtra("cardList");
        setAdapter();
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
