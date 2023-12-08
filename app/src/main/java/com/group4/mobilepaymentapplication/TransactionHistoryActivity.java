package com.group4.mobilepaymentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        RecyclerView recyclerView = findViewById(R.id.transactionRecyclerView);
        TransactionHistoryDatabaseHelper dbHelper = new TransactionHistoryDatabaseHelper(this);
        List<Transaction> transactions = dbHelper.getAllTransactions();

        TransactionHistoryRecyclerAdapter adapter = new TransactionHistoryRecyclerAdapter(transactions);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    public static class SplashPageActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_page);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}