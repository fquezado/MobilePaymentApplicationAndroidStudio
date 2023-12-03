package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AccountInformationActivity extends AppCompatActivity {

    private TextView nameTextView, emailTextView, phoneTextView;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);

        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        phoneTextView = findViewById(R.id.phoneTextView);

        userPreferences = new UserPreferences(this);

        // Retrieve user information
        String[] userInfo = userPreferences.getUser();
        String name = userInfo[0];
        String email = userInfo[1];
        String phone = userInfo[3];

        // Set text in TextViews
        nameTextView.setText("Name: " + name);
        emailTextView.setText("Email: " + email);
        phoneTextView.setText("Phone: " + phone);
    }
}
