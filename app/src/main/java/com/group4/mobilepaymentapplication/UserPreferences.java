package com.group4.mobilepaymentapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {
    private SharedPreferences sharedPreferences;

    public UserPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
    }

    // Modified to include the phone number
    public void saveUser(String name, String email, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME", name);
        editor.putString("EMAIL", email);
        editor.putString("PASSWORD", password);
        editor.apply();
    }

    // Modified to include the phone number
    public String[] getUser() {
        String name = sharedPreferences.getString("NAME", null);
        String email = sharedPreferences.getString("EMAIL", null);
        String password = sharedPreferences.getString("PASSWORD", null);
        return new String[]{name, email, password};
    }
}


