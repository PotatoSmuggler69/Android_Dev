package com.example.s04_binder_messenger;

import android.Manifest;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;



public class LocationServices extends Service implements LocationListener {
    class MyBinder extends Binder {
        public LocationServices getService() {
            return LocationServices.this;
        }
    }
    final static String CHANNEL_ID = "CH_101";
    private IBinder iBinder = new MyBinder();
    // GPS and Network status
    boolean isGPSEnabled, isNetworkEnabled;
    private final long MIN_TIME_BW_UPDATES = 1000;
    private final float MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;

    double latitude = 0.0;
    double longitude = 0.0;

    // Handler Thread
//    Handler handler;
//    HandlerThread handlerThread;
    private Coordinates coordinates = new Coordinates(0,0);




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("LocationServices", "Service bound");
        return iBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        handlerThread = new HandlerThread("MyThreadServices", Process.THREAD_PRIORITY_BACKGROUND);
//
//        handlerThread.start();
//        Looper looper = handlerThread.getLooper();
//         handler = new Handler(looper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try{

            //start the service in the background
            startForeground(103,startNotification("Location Tracing Started"));
        }
        catch (Exception e){
            Log.d("FATAL",e.toString());
        }
        Log.e("DATA","Longitude : "+longitude+" Latitude : "+latitude);
        startLocationTracing();


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        //handlerThread.quit();
        Log.e("CLOSE","ON DESTROY SERVICE");
        super.onDestroy();
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        String message = "Longitude : "+longitude+" Latitude : "+latitude;
        Log.e("DATA",message);

        //handler.post(() ->{
            coordinates.set_latitude(latitude);
            coordinates.set_longitude(longitude);
        //});

    }

    private void startLocationTracing() {
        try {
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            //checking if network/GPS is enabled
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            System.out.println(isGPSEnabled+" "+isNetworkEnabled);
            if (!isGPSEnabled && !isNetworkEnabled) {
                Log.e("FATAL", "Unable to access GPS or Network");
                Toast.makeText(this, "GPS or Network not available", Toast.LENGTH_SHORT).show();
            } else {
                if (isGPSEnabled) {
                    if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        Log.e("FAILURE_12345", "Access GPS or Network not added");
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    Log.e("LOCATION FETCHED SUCCESSFULLY", "Access GPS or Network");
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                }
                else if(isNetworkEnabled){

                }
            }
        }
        catch (Exception e){
            Log.e("FATAL","Exception "+e.toString());
            Toast.makeText(this,"OOPS : "+e.toString(),Toast.LENGTH_SHORT).show();
        }

    }

    public Coordinates getLocationInfo(){

        return coordinates;
    }

    private Notification startNotification(String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Location Services Started")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)!= PackageManager.PERMISSION_GRANTED){
            Log.d("FATAL","NotificationLauncherFailed@@@@@@@@");
            return null;
        }

        return builder.build();

    }
}
