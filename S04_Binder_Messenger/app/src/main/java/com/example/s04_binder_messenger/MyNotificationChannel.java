package com.example.s04_binder_messenger;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

public class MyNotificationChannel {
    private String CHANNEL_ID = null;
    MyNotificationChannel(String CHANNEL_ID){
        this.CHANNEL_ID = CHANNEL_ID;
    }
    NotificationChannel createNotificationChannel(){
        String description = "This is channel description";
        CharSequence name = "Message Channel";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,name,importance);
            channel.setDescription(description);
            return channel;

        }
        return null;
    }
}