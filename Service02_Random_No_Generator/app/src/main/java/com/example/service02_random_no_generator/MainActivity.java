package com.example.service02_random_no_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent serviceIntent;

    //Buttons-------------------->
    Button startServiceButton;
    Button stopServiceButton;
    Button getRandomNumber;
    //--------------------------->Buttons
    TextView txt_random_number_holder;
    ServiceConnection serviceConnection=null;

    RandomNumberGeneratorService randomNumberGeneratorService;
    boolean isServiceConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("thread_tracker","Main Activity Running on Thread ----> "
        +Thread.currentThread().getId());
        //
        startServiceButton = findViewById(R.id.btn_start_service);
        getRandomNumber = findViewById(R.id.btn_get_random_number);
        stopServiceButton = findViewById(R.id.btn_stop_service);

        startServiceButton.setOnClickListener(this);
        getRandomNumber.setOnClickListener(this);
        stopServiceButton.setOnClickListener(this);
        //
        // Text field
        txt_random_number_holder = findViewById(R.id.txt_random_number);
        //Intent Initialization
        serviceIntent = new Intent(this,RandomNumberGeneratorService.class);
    }


    void bindService(){
        Log.d("MainActivity_bind","Inside bindService");
        if(serviceConnection==null){
            serviceConnection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    RandomNumberGeneratorService.MyServiceBinder myServiceBinder = (RandomNumberGeneratorService.MyServiceBinder)service;
                    randomNumberGeneratorService = myServiceBinder.getService();
                    isServiceConnected = true;
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    isServiceConnected = false;
                }
            };
        }
        bindService(serviceIntent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void setRandomNumber(){
        if(isServiceConnected){
            String temp = Integer.toString(randomNumberGeneratorService.getRandomNumber());
            txt_random_number_holder.setText("Random no : "+temp);
        }
        else{
            txt_random_number_holder.setText("Service not Bound");
        }
    }
    void unbindService(){
        unbindService(serviceConnection);
        isServiceConnected = false;
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_start_service){
            startService(serviceIntent);
            Toast.makeText(MainActivity.this,"Button Pressed",Toast.LENGTH_SHORT).show();
            bindService();

        }
        else if(v.getId()==R.id.btn_stop_service)
        {
            unbindService();
            stopService(serviceIntent);
        }
        else if (v.getId()==R.id.btn_get_random_number) {setRandomNumber();}
    }
}