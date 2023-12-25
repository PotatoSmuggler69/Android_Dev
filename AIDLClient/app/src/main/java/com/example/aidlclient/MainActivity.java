package com.example.aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.aidlserver.IAIDLColorInterface;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    LinearLayout lay;
    IAIDLColorInterface iaidlColorInterface;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iaidlColorInterface = IAIDLColorInterface.Stub.asInterface(service);
            Log.d("Service Binded","Success in Binding AIDL with Client");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent("AIDLColorService");
        intent.setPackage("com.example.aidlserver");
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
        bt1 = findViewById(R.id.btn_1);
        lay = findViewById(R.id.main_layout);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int color = iaidlColorInterface.getColor();
                    lay.setBackgroundColor(color);
                }
                catch (Exception e){
                    Log.e("Error","Error in try catch "+e.toString());
                }
            }
        });
    }
}