package com.example.fragment_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Integer fragmentButtonCount = 0;
    Button home_btn;
    Button dashboard_btn;
    Button settings_btn;

    Fragment home_obj;
    Fragment dashboard_obj;
    Fragment settings_obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_btn = findViewById(R.id.btn_1);
        dashboard_btn = findViewById(R.id.btn_2);
        settings_btn = findViewById(R.id.btn_3);

        home_obj = new HomeFragment();
        dashboard_obj = new DashBoardFragment();
        settings_obj = new SettingsFragment();

        replaceFragment(new HomeFragment());
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(home_obj);
            }
        });

        dashboard_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(dashboard_obj);
            }
        });

        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(settings_obj);
            }
        });

    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction().setCustomAnimations(R.anim.slide_in,R.anim.slide_out);
        ft.replace(R.id.layout_pane,fragment);
        ft.commit();
    }
}