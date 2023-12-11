package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountInformationActivity extends AppCompatActivity {

    private EditText changeAccountNameEditText, changeAccountEmailEditText, changePasswordEditText;
    private Button saveChangesButton;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);

        changeAccountNameEditText = findViewById(R.id.change_account_name);
        changeAccountEmailEditText = findViewById(R.id.change_account_email);
        changePasswordEditText = findViewById(R.id.change_password);
        userPreferences = new UserPreferences(this);

        // Load existing data for the current user
        loadExistingData();

        saveChangesButton = findViewById(R.id.save_changes_button);

        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current user
                User currentUser = userPreferences.getCurrentUser();

                // Get user input
                String newName = changeAccountNameEditText.getText().toString();
                String newEmail = changeAccountEmailEditText.getText().toString();
                String newPassword = changePasswordEditText.getText().toString();

                // Update user data only if changed
                if (!newName.isEmpty()) {
                    currentUser.setName(newName);
                }
                if (!newEmail.isEmpty()) {
                    currentUser.setEmail(newEmail);
                }
                if (!newPassword.isEmpty()) {
                    currentUser.setPassword(newPassword);
                }

                // Save updated user data
                userPreferences.saveUser(currentUser);
                Toast.makeText(AccountInformationActivity.this, "Changes Saved", Toast.LENGTH_SHORT).show();

                // Optionally navigate to another activity
                Intent intent = new Intent(AccountInformationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadExistingData() {
        // Get the current user
        User currentUser = userPreferences.getCurrentUser();

        changeAccountNameEditText.setText(currentUser.getName());
        changeAccountEmailEditText.setText(currentUser.getEmail());
        changePasswordEditText.setText(currentUser.getPassword());
    }
}
