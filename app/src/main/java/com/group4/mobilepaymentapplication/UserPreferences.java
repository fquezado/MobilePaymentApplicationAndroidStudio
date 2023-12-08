package com.group4.mobilepaymentapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {
    private SharedPreferences sharedPreferences;

    public UserPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
    }

    public void saveUser(String name, String email, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME", name);
        editor.putString("EMAIL", email);
        editor.putString("PASSWORD", password);
        //editor.putInt("ID", id);
        editor.apply();
    }

    public String getUserName() {
        return sharedPreferences.getString("NAME", ""); // Default to empty string if not found
    }

    public String getUserEmail() {
        return sharedPreferences.getString("EMAIL", ""); // Default to empty string if not found
    }

    public String getUserPassword() {
        return sharedPreferences.getString("PASSWORD", ""); // Default to empty string if not found
    }
}
