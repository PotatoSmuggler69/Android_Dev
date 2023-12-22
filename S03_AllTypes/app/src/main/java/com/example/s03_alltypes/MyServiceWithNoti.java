package com.example.s03_alltypes;

import android.Manifest;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;

public class MyServiceWithNoti extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Running","Running inside service ------>");
        try{

            //start the service in the background
            startForeground(101,startNotification());
        }
        catch (Exception e){
            Log.d("FATAL",e.toString());
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private Notification startNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,MainActivity.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("TELE LEEP TELE LEEP")
                .setContentText("Time to wake up")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)!= PackageManager.PERMISSION_GRANTED){
            Log.d("FATAL","NotificationLauncherFailed");
            return null;
        }

        return builder.build();

    }

    @Override
    public void onDestroy() {
        stopForeground(true);
        super.onDestroy();
    }
}
