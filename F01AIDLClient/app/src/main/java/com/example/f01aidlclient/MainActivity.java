package com.example.f01aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.f01aidlserver.RND_AIDL_Interface;

public class MainActivity extends AppCompatActivity {
    RND_AIDL_Interface rndAidlInterface;
    TextView textView;
    Button button;
    boolean isServiceConnected;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            rndAidlInterface = RND_AIDL_Interface.Stub.asInterface(service);
            Log.d("SUCCESS","Binding Success");
            isServiceConnected = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("EXIT","The service got disconnected");
            rndAidlInterface = null;
            isServiceConnected = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        Intent intent = new Intent("RND_Service");
        intent.setPackage("com.example.f01aidlserver");
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isServiceConnected){
                    try{
                        int n = rndAidlInterface.getNumber(100);
                        String s = "The number is "+Integer.toString(n);
                        textView.setText(s);
                    }
                    catch (Exception e){
                        Log.e("BINDING FAILED","FAILED OMGG "+e.toString());
                    }
                }
                else{
                    Log.e("BINDING FAILED","Service not Connected");
                }

            }
        });
    }
}