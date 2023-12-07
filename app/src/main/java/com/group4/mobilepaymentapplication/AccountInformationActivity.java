package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountInformationActivity extends AppCompatActivity {

    private EditText change_account_name, change_account_email, change_password;
    private Button saveChangesButton;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);

        change_account_name = findViewById(R.id.change_account_name);
        change_account_email = findViewById(R.id.change_account_email);
        change_password = findViewById(R.id.change_password);
        userPreferences = new UserPreferences(this);

        // Load existing data
        loadExistingData();

        saveChangesButton = findViewById(R.id.save_changes_button);

        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentName = userPreferences.getUserName(); // Assuming this method exists
                String currentEmail = userPreferences.getUserEmail(); // Assuming this method exists
                String currentPassword = userPreferences.getUserPassword(); // Assuming this method exists

                String newName = change_account_name.getText().toString();
                String newEmail = change_account_email.getText().toString();
                String newPassword = change_password.getText().toString();

                // Update only if the field is changed
                if (!newName.isEmpty()) {
                    currentName = newName;
                }
                if (!newEmail.isEmpty()) {
                    currentEmail = newEmail;
                }
                if (!newPassword.isEmpty()) {
                    currentPassword = newPassword;
                }

                userPreferences.saveUser(currentName, currentEmail, currentPassword);
                Toast.makeText(AccountInformationActivity.this, "Changes Saved", Toast.LENGTH_SHORT).show();
                // Optionally navigate to another activity
                Intent intent = new Intent(AccountInformationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadExistingData() {
        // Assuming these methods exist in userPreferences
        change_account_name.setText(userPreferences.getUserName());
        change_account_email.setText(userPreferences.getUserEmail());
        change_password.setText(userPreferences.getUserPassword());
    }
}
