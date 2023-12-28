package com.example.aidlserver;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceIntent = new Intent(this,AIDLColorService.class);
        startService(serviceIntent);

    }

}