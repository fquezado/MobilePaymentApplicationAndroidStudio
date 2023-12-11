package com.group4.mobilepaymentapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class UserPreferences {
    private SharedPreferences sharedPreferences;
    private List<User> users;

    public UserPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        users = new ArrayList<>();
        // Load user data from shared preferences
        loadUsersFromSharedPreferences();
    }

    public boolean saveUser(User user) {
        if (users != null) {
            String email = user.getEmail();
            // Check if email already exists
            for (User existingUser : users) {
                if (existingUser.getEmail().equals(email)) {
                    Log.d("UserPreferences", "Email already exists: " + email);
                    return false; // Email already exists, do not save
                }
            }
            // Email is unique, add user and save
            users.add(user);
            saveUsersToSharedPreferences();
            Log.d("UserPreferences", "Saved new user: " + user);
            return true; // User saved successfully
        } else {
            Log.e("UserPreferences", "Users list is null! Cannot save user.");
            return false;
        }
    }


    public User getUser(int index) {
        if (index >= 0 && index < users.size()) {
            return users.get(index);
        } else {
            Log.d("UserPreferences", "Invalid user index: " + index);
            return null;
        }
    }

    public String getSavedEmail() {
        return sharedPreferences.getString("LOGGED_IN_USER_EMAIL", "");
    }


    private void loadUsersFromSharedPreferences() {
        String jsonString = sharedPreferences.getString("USERS", "");
        if (jsonString != null && !jsonString.isEmpty()) {
            try {
                users = new Gson().fromJson(jsonString, new TypeToken<List<User>>(){}.getType());
                Log.d("UserPreferences", "Loaded users: " + users);
            } catch (Exception e) {
                Log.e("UserPreferences", "Error loading users: " + e.getMessage());
                users = new ArrayList<>();
            }
        } else {
            Log.d("UserPreferences", "No user data found in shared preferences");
            users = new ArrayList<>();
        }
        Log.d("UserPreferences", "Users after loading from prefs: " + users);
    }


    public User getCurrentUser() {
        String loggedInUserEmail = sharedPreferences.getString("LOGGED_IN_USER_EMAIL", "");
        Log.d("UserPreferences", "Current logged-in user email: " + loggedInUserEmail);

        if (!loggedInUserEmail.isEmpty()) {
            for (User user : users) {
                Log.d("UserPreferences", "Checking user: " + user.getEmail());
                if (user.getEmail().equals(loggedInUserEmail)) {
                    Log.d("UserPreferences", "Match found: " + user.getEmail());
                    return user;
                }
            }
            Log.d("UserPreferences", "No user found with email: " + loggedInUserEmail);
        } else {
            Log.d("UserPreferences", "No logged-in user email found");
        }
        return null;
    }



    public List<User> getUsers() {
        return users;
    }

    private void saveUsersToSharedPreferences() {
        if (users != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            // Convert users list to JSON string
            String jsonString = new Gson().toJson(users);
            editor.putString("USERS", jsonString);
            editor.apply();
            Log.d("UserPreferences", "Saved users to shared preferences: " + users.size());
        } else {
            Log.e("UserPreferences", "Users list is null! Cannot save to shared preferences.");
        }
    }


}
