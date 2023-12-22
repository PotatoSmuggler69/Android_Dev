package com.example.s03_alltypes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button onStart;
    Button onPause;

    Intent serviceIntent;
    final static String CHANNEL_ID = "101";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating the service intent
        serviceIntent = new Intent(getApplicationContext(),MyServiceWithNoti.class);

        //creating the notification channel
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        NotificationChannel channel = new MyNotificationChannel(CHANNEL_ID).createNotificationChannel();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && channel !=null) {
            notificationManager.createNotificationChannel(channel);
        }

        //creating button actions (ON START)
        onStart = findViewById(R.id.btn_start);
        onStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startService(serviceIntent);

            }
        });
        //creating button actions (ON STOP)

        onPause = findViewById(R.id.btn_stop);

        onPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(serviceIntent);
            }
        });


    }



}