package com.example.f01aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import java.util.Random;

public class RND_Service extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final RND_AIDL_Interface.Stub binder = new RND_AIDL_Interface.Stub() {
        @Override
        public int getNumber(int limit) throws RemoteException {
            Random random = new Random();
            int n = random.nextInt(limit);
            return n;
        }
    };


}
