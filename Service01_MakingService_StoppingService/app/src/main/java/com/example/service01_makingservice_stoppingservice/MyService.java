package com.example.service01_makingservice_stoppingservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String message = "Current Service Thread : "+Long.toString(Thread.currentThread().getId());
        Log.d("Thread_Search",message);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("thread_info","Service Destroyed");
        super.onDestroy();
    }
}
