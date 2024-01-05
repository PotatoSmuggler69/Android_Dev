package com.example.trackme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    FusedLocationProviderClient fusedLocationProviderClient;
    Button getLocation;
    TextView coordinates, address, city, country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLocation = findViewById(R.id.btn_get_location);
        coordinates = findViewById(R.id.txt_coordinates);
        address = findViewById(R.id.txt_address);
        city = findViewById(R.id.txt_city);
        country = findViewById(R.id.txt_country);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        askPermissions();
        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLastLocation();
            }
        });

    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        if (!checkRequiredPermissions()) {
            Log.e("Custom Error", "Permission not granted");
            return;
        }
        
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if(location!=null){
                            try{
                                Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                                List<Address> adresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),1);
                                Log.d("Custom Success","Lat : "+location.getLatitude()+" Long : "+location.getLongitude());
                                Log.d("Custom Success","Address "+adresses.get(0).getAddressLine(0));
                                Log.d("Custom Success","City "+adresses.get(0).getLocality());
                                Log.d("Custom Success","Country : "+adresses.get(0).getCountryName());

                                coordinates.setText("Latitude : "+location.getLatitude()+" Longitude : "+location.getLongitude());
                                address.setText("Address : "+adresses.get(0).getAddressLine(0));
                                city.setText("City : "+adresses.get(0).getLocality());
                                country.setText("Country "+adresses.get(0).getCountryName());
                            }
                            catch (Exception e){
                                Log.e("Custom Error","Location fetching failed "+e.toString());
                            }


                        }
                    }
                });

    }
    private boolean checkRequiredPermissions(){
        return ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

    }

    private void askPermissions(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);
    }
}