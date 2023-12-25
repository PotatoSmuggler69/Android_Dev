package com.example.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.Random;

public class AIDLColorService extends Service {
    public AIDLColorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }

    private final IAIDLColorInterface.Stub binder = new IAIDLColorInterface.Stub() {
        @Override
        public int getColor() throws RemoteException {
            Random random = new Random();
            int color = Color.argb(random.nextInt(256),random.nextInt(256),random.nextInt(256),random.nextInt(256));
            Log.d("Color Generated","Color = "+color);
            return color;
        }
    };
}