package com.example.service02_random_no_generator;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class RunningApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
             NotificationHelper.initializeChannels(getApplicationContext());
        }
    }
}
