package com.group4.mobilepaymentapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class ResetUsersReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.group4.mobilepaymentapplication.RESET_USERS".equals(intent.getAction())) {
            // Create an intent that will open your MainActivity (or another activity) to handle the reset
            Intent resetIntent = new Intent(context, MainActivity.class);
            resetIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            resetIntent.putExtra("reset_action", true); // An extra flag to indicate reset action is required

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, resetIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            createNotification(context, pendingIntent);
        }
    }

    private void createNotification(Context context, PendingIntent pendingIntent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "reset_channel_id";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Reset Channel";
            String description = "Channel for User Reset Notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelId, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }

        Notification notification = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(com.google.android.material.R.drawable.mtrl_checkbox_button) // Replace with your app's notification icon
                .setContentTitle("Reset Users")
                .setContentText("Tap to reset user data.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        notificationManager.notify(1, notification);
    }
}

