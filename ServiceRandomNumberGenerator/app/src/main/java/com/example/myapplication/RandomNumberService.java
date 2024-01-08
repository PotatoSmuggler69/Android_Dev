package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class RandomNumberService extends Service {

    private GeneratorInterfaceImplementation interfaceImplementation = new GeneratorInterfaceImplementation();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return interfaceImplementation;
    }
}