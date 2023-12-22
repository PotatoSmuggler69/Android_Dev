package com.example.s04_binder_messenger;

import static android.app.ProgressDialog.show;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MyBinderActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    LocationManager locationManager;
    //four buttons
    Button start_service,stop_service,bind_service,unbind_service;
    //Service Intent
    Intent serviceIntent;

    // Creating a model Class Coordinate to store and retrive the binded data
    // from service
    Coordinates coordinates;
    // ------------------------BINDING PARAMETERS-----------------------------
    // oject of the service to be binded
    LocationServices locationServices;
    ServiceConnection serviceConnection=null;

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

        // Assigining Service Intent
        serviceIntent = new Intent(this,LocationServices.class);

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
    public void startBind(){
        if(serviceConnection == null){
            serviceConnection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    LocationServices.MyBinder myServiceBinder = (LocationServices.MyBinder)service;
                    locationServices = myServiceBinder.getService();
                    isServiceConnected = true;
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    isServiceConnected = false;
                }
            };
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
            startBind();
            Toast.makeText(this,"Location services Binded",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.btn_unbindservice){
            stopBind();
            Toast.makeText(this,"Location Services Unbinded",Toast.LENGTH_SHORT).show();
        }

    }



}