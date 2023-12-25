package com.example.s04_binder_messenger;

import static android.app.ProgressDialog.show;

import static com.example.s04_binder_messenger.LocationServices.CHANNEL_ID;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.logging.Handler;

public class MyBinderActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    LocationManager locationManager;
    //four buttons
    Button start_service,stop_service,bind_service,unbind_service;
    //Service Intent
    Intent serviceIntent;

    // Creating a model Class Coordinate to store and retrive the binded data
    // from service
    // ------------------------BINDING PARAMETERS-----------------------------
    // oject of the service to be binded
    LocationServices locationServices;
    ServiceConnection serviceConnection=null;
    TextView txt_loc_dis;
    boolean isServiceConnected = false;
    //------------------------------------------------------------------------



    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.activity_mybinder);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //assigning button objects
        start_service = findViewById(R.id.btn_startservice);
        stop_service = findViewById(R.id.btn_stopservice);
        bind_service = findViewById(R.id.btn_bindservice);
        unbind_service = findViewById(R.id.btn_unbindservice);
        txt_loc_dis = findViewById(R.id.txt_loc_dis);
        start_service.setOnClickListener(this);
        stop_service.setOnClickListener(this);
        bind_service.setOnClickListener(this);
        unbind_service.setOnClickListener(this);

        serviceIntent = new Intent(this,LocationServices.class);
        //creating the notification channel
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        NotificationChannel channel = new MyNotificationChannel(CHANNEL_ID).createNotificationChannel();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && channel !=null) {
            Log.e("Yoyo","Notification Channel crearted");
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void checkLocationPermission(){
        //checking and asking for permissions
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Request location permission if not granted
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        } else {
            // Permission already granted, start location updates
//            startLocationUpdates();
        }
    }
    //creating a function to start binding with already running service
    void bindService(){
        Log.e("MainActivity_bind","Inside bindService");
        if(serviceConnection==null){
            serviceConnection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    LocationServices.MyBinder myServiceBinder = (LocationServices.MyBinder)service;
                    locationServices = myServiceBinder.getService();
                    isServiceConnected = true;
                    setLocationDisplay(locationServices.getLocationInfo());

                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    isServiceConnected = false;
                }
            };
        }
        bindService(serviceIntent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private void setLocationDisplay(Coordinates c){
        if(isServiceConnected) {
            String s = "Latitude " + c.get_latitude() + " Longitude " + c.get_longitude();
            txt_loc_dis.setText(s);
        }
        else{
            txt_loc_dis.setText("Service not Bound");
        }
    }

    public void stopBind(){
        unbindService(serviceConnection);
        isServiceConnected = false;
    }

    // creating action button consequences
    @Override
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.btn_startservice){
            checkLocationPermission();
            startService(serviceIntent);
            Toast.makeText(this,"Location Service Started",Toast.LENGTH_SHORT).show();

        }
        else if(id == R.id.btn_stopservice){
            stopService(serviceIntent);

            Toast.makeText(this,"Location Service Stopped",Toast.LENGTH_SHORT).show();

        }
        else if(id == R.id.btn_bindservice){
            bindService();
            Log.e("FATAL","Bind Failed "+locationServices+" "+isServiceConnected);
            Toast.makeText(this,"Location services Binded",Toast.LENGTH_SHORT).show();
            if(isServiceConnected) setLocationDisplay(locationServices.getLocationInfo());
        }
        else if (id == R.id.btn_unbindservice){
            stopBind();
            Toast.makeText(this,"Location Services Unbinded",Toast.LENGTH_SHORT).show();
        }

    }



}