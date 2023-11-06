package com.group4.mobilepaymentapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {
    private SharedPreferences sharedPreferences;

    public UserPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
    }

    public void saveUser(String email, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("EMAIL", email);
        editor.putString("PASSWORD", password);
        editor.apply();
    }

    public String[] getUser() {
        String email = sharedPreferences.getString("EMAIL", null);
        String password = sharedPreferences.getString("PASSWORD", null);
        return new String[]{email, password};
    }
}

