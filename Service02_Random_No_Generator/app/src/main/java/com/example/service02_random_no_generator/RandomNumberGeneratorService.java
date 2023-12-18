package com.example.service02_random_no_generator;

import android.Manifest;
import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class RandomNumberGeneratorService extends Service {
    private int max_number=100;
    private int min_number=0;
    private int random_number;
    private boolean isRandomGeneratorOn;
    private IBinder myBinder= new MyServiceBinder();

    class MyServiceBinder extends Binder{
        public RandomNumberGeneratorService getService(){
            return RandomNumberGeneratorService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("RandomService","In OnBind");
        Log.d("RandomNumberGenerator","On bind called");
        return myBinder;
    }

    @Override
    public void onRebind(Intent intent) {

        Log.d("RandomNumberGenerator","On rebind called");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("RandomNumberGenerator","On unbind called");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        stopRandomNumberGenerator();
        Log.d("RandomNumberGenerator","Service Destroyed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        isRandomGeneratorOn = true;
        startForeground();
        Log.d("thread_tracker","Service running on Thread ----> "
                +Thread.currentThread().getId());
        isRandomGeneratorOn = true;
        new Thread((Runnable) () ->{
            Log.d("thread_tracker","RandomNumberGenerator function on Thread ----> "
                    +Thread.currentThread().getId());
            randomNumberGenerator();
        }).start();
        return START_STICKY;
    }

    private void randomNumberGenerator(){
        while (isRandomGeneratorOn){
            try{
                Thread.sleep(1000);
                if(isRandomGeneratorOn){
                    random_number = new Random().nextInt(max_number-min_number+1)+min_number;
                }
            }
            catch (Exception e){
                Log.d("RandomNumberGeneratorService",e.toString());
            }
        }
    }

    private void stopRandomNumberGenerator(){
        isRandomGeneratorOn = false;
    }

     public int getRandomNumber(){
        return random_number;
    }

    private void startForeground() {
        // Before starting the service as foreground check that the app has the
        // appropriate runtime permissions. In this case, verify that the user
        // has granted the CAMERA permission.
        int cameraPermission =
                ContextCompat.checkSelfPermission(this, Manifest.permission.FOREGROUND_SERVICE_DATA_SYNC);
        if (cameraPermission == PackageManager.PERMISSION_DENIED) {
            // Without camera permissions the service cannot run in the
            // foreground. Consider informing user or updating your app UI if
            // visible.
            stopSelf();
            return;
        }

        try {
            Notification notification =
                    new NotificationCompat.Builder(this, "n101")
                            // Create the notification to display while the service
                            // is running
                            .build();
            int type = 0;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                type = ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC;
            }
            ServiceCompat.startForeground(
                    /* service = */ this,
                    /* id = */ 100, // Cannot be 0
                    /* notification = */ notification,
                    /* foregroundServiceType = */ type
            );
        } catch (Exception e) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S &&
                    e instanceof ForegroundServiceStartNotAllowedException
            ) {
                // App not in a valid state to start foreground service
                // (e.g started from bg)
            }
            // ...
        }
    }
}

