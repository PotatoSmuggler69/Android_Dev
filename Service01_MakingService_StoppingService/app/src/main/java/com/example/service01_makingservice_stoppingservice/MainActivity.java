package com.example.service01_makingservice_stoppingservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Button createService,destroyService;
    Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceIntent = new Intent(getApplicationContext(),MyService.class);
        createService = findViewById(R.id.btn_create_service);
        destroyService = findViewById(R.id.btn_destroy_service);

        createService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Thread Id of the Main Activity : "+Long.toString(Thread.currentThread().getId());
                Log.d("Thread_Info",message);
                startService(serviceIntent);
            }
        });

        destroyService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Service Destroyed",Toast.LENGTH_SHORT).show();
                View view =  findViewById(android.R.id.content);
                Snackbar.make(view,"foff",Snackbar.LENGTH_SHORT).show();
                stopService(serviceIntent);

            }
        });
    }
}