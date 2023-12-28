package com.example.s04_binder_messenger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MessengerDemoActivity extends AppCompatActivity implements View.OnClickListener {
    private int random_no;
    private Intent serviceIntent;
    private TextView textviewRandomNo;
    private Button bind,unbind,getno;
    private Context mContext;

//    class ReceiveRandomNumber extendsHandler{
//        @Override
//        public void handleMessage(@NonNull Message msg) {
////            random_no = 0;
////            if(msg == msg.what){
////
////            }
////            super.handleMessage(msg);
//        }
//    }
    ServiceConnection randomNumberServiceConnection
            = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_messengerdemo);

        bind = findViewById(R.id.btn_bind);
        unbind = findViewById(R.id.btn_unbind);
        getno = findViewById(R.id.btn_getrandom);

        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
        getno.setOnClickListener(this);

        textviewRandomNo = findViewById(R.id.txt_randomno_dis);


        mContext = getApplicationContext();
        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("",""));

    }

    @Override
    public void onClick(View v) {

    }
}
