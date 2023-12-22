package com.example.s04_binder_messenger;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LocationServices extends Service {


    class MyBinder extends Binder{
        public LocationServices getService(){
            return LocationServices.this;
        }
    }

    IBinder iBinder = new MyBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return iBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}
