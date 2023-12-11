package com.group4.mobilepaymentapplication;

// ... [Other imports]
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView registerTextView;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UserPreferences
        userPreferences = new UserPreferences(this);

        // Find UI elements
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerTextView = findViewById(R.id.registerTextView);

        // Login button click listener
        loginButton.setOnClickListener(v -> {
            userPreferences = new UserPreferences(this);
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            Log.d("LoginActivity", "Attempting login with email: " + email);

            if (!email.isEmpty() && !password.isEmpty()) {
                User currentUser = userPreferences.getCurrentUser();
                Log.d("LoginActivity", "Fetched user: " + (currentUser != null ? currentUser.getEmail() : "null"));

                if (currentUser != null && currentUser.getEmail().equals(email)) {
                    if (currentUser.getPassword().equals(password)) {
                        // Login successful
                        Log.d("LoginActivity", "Login successful");

                        // Storing the email in shared preferences
                        SharedPreferences.Editor editor = getSharedPreferences("UserPrefs", MODE_PRIVATE).edit();
                        editor.putString("LOGGED_IN_USER_EMAIL", email);
                        editor.apply();
                        Log.d("LoginActivity", "Logged-in user email stored: " + email);

                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        // Invalid password
                        Log.d("LoginActivity", "Invalid password entered");
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // User not found or email mismatch
                    Log.d("LoginActivity", "User not found or email mismatch");
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Missing fields
                Log.d("LoginActivity", "Email or password fields are empty");
                Toast.makeText(LoginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });

        // Register text view click listener
        registerTextView.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}