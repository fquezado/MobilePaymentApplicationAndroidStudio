package com.group4.mobilepaymentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        // Sample data for transactions - Simulating the data in a similar structure
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Grocery", "$50", "12/11/2023"));
        transactions.add(new Transaction("Clothing", "$80", "10/11/2023"));
        transactions.add(new Transaction("Books", "$30", "08/11/2023"));

//        TransactionAdapter adapter = new TransactionAdapter(this, transactions);
//        ListView listView = findViewById(R.id.transactionListView);
//        listView.setAdapter(adapter);

        // Adding a back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Find the button and set a click listener to navigate back to the ProfileActivity
//        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Navigate back to ProfileActivity
//                Intent intent = new Intent(TransactionHistoryActivity.this, ProfileActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    // Define a class to represent a transaction in Java
    public class Transaction {
        private String title;
        private String payment;
        private String date;

        public Transaction(String title, String payment, String date) {
            this.title = title;
            this.payment = payment;
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public String getPayment() {
            return payment;
        }

        public String getDate() {
            return date;
        }
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