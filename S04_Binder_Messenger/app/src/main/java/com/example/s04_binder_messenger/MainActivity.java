package com.example.s04_binder_messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_binder,messenger,aidl;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_binder = findViewById(R.id.btn_page_one_ibinder);
        btn_binder.setOnClickListener(this);

        messenger = findViewById(R.id.btn_page_one_messenger);
        messenger.setOnClickListener(this);

        aidl = findViewById(R.id.btn_page_one_aidl);
        aidl.setOnClickListener(this);

        intent = new Intent(this, MyBinderActivity.class);

    }

    @Override
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.btn_page_one_ibinder){
            Toast.makeText(this,"Binder Pressed",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        else if (id == R.id.btn_page_one_messenger){

        }
        else if(id == R.id.btn_page_one_aidl){

        }
    }
}