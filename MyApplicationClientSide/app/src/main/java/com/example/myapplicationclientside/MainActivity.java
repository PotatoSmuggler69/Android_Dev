package com.example.myapplicationclientside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.example.myapplication.GeneratorInterface;

public class MainActivity extends AppCompatActivity {
    int random_value;
    private GeneratorInterface generatorInterface;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            generatorInterface = GeneratorInterface.Stub.asInterface(service);
            try{
                random_value = generatorInterface.randomNumberGenerator(1,100);
                Log.e("YUREKA","Random Number : "+random_value);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            generatorInterface = null;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.myapplication", "com.example.myapplication.RandomNumberService"));
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
        Log.e("YUREKA XXX","Random Number : "+random_value);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}