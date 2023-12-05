package com.example.activity_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {
    Button goBacktoAct1;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_second);

        goBacktoAct1 = findViewById(R.id.btn_2);

        goBacktoAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //Intent i = new Intent(SecondActivity.this,MainActivity.class);

            }
        });
    }
}
