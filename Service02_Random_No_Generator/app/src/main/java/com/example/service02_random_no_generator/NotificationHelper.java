package com.example.service02_random_no_generator;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class NotificationHelper {

    private static final String CHANNEL_ID = "n101";
    private static final String CHANNEL_NAME = "Foreground Service Notification";
    private static final String CHANNEL_DESCRIPTION = "Your service is running";

    // Create a notification channel
    public static void createNotificationChannel(Context context) {
        // Check if the device is running Android 8.0 (API level 26) or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);

            // Configure the notification channel
            notificationChannel.setDescription(CHANNEL_DESCRIPTION);

            // Register the channel with the system
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    // You can call this method from your application setup, e.g., in your Application class
    public static void initializeChannels(Context context) {
        createNotificationChannel(context);
        // Add more channels if needed
    }
}
