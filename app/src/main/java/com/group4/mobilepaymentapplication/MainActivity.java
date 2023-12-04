package com.group4.mobilepaymentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button PayButtonMainPage;
    private TextView welcomeTextView;

    private Button receiveButton;
    private UserPreferences userPreferences;

    private ImageButton settingsButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();

        if (menuId == R.id.settings) {
            Intent homeIntent = new Intent(this, SettingsActivity.class);
            startActivity(homeIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
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


        PayButtonMainPage = findViewById(R.id.PayButtonMainPage);

        settingsButton = findViewById(R.id.settingsButton);

        receiveButton = findViewById(R.id.ReceiveButtonMainPage);



        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        receiveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, ReceiveActivity.class);
                startActivity(intent);
            }
        });

        PayButtonMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PayActivity.class);
                startActivity(intent);
            }
        });
    }
}
