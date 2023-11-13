package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button goToPaymentButton;
    private TextView welcomeTextView;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userPreferences = new UserPreferences(this);

        // Initialize your TextView
        welcomeTextView = findViewById(R.id.HompageText);

        // Retrieve user info
        String[] userInfo = userPreferences.getUser();
        String userName = userInfo[0]; // Assuming the first element is the name

        // Check if userName is not null
        if (userName != null && !userName.isEmpty()) {
            welcomeTextView.setText("Welcome, " + userName + "!");
        } else {
            welcomeTextView.setText("Welcome!");
        }


        goToPaymentButton = findViewById(R.id.goToPaymentButton);

        goToPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddPaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}