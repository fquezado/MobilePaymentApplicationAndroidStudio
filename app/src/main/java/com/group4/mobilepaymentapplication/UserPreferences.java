package com.group4.mobilepaymentapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {
    private SharedPreferences sharedPreferences;

    public UserPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
    }

    // Modified to include the phone number
    public void saveUser(String name, String email, String password, String phone) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME", name);
        editor.putString("EMAIL", email);
        editor.putString("PASSWORD", password);
        editor.putString("PHONE", phone); // Add this line
        editor.apply();
    }

    // Modified to include the phone number
    public String[] getUser() {
        String name = sharedPreferences.getString("NAME", null);
        String email = sharedPreferences.getString("EMAIL", null);
        String password = sharedPreferences.getString("PASSWORD", null);
        String phone = sharedPreferences.getString("PHONE", null); // Add this line
        return new String[]{name, email, password, phone}; // Include phone in the return
    }
}


