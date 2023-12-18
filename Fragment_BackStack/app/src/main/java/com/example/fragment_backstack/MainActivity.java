package com.example.fragment_backstack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button changeFragmentButton;
    TextView fragmentCountView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFragmentButton = findViewById(R.id.btn_add_fragment);
        fragmentCountView = findViewById(R.id.txt_counter);
        fragmentManager = getSupportFragmentManager();

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                String cnt = Integer.toString(fragmentManager.getBackStackEntryCount());
                fragmentCountView.setText("Count = "+cnt);
                if(fragmentManager.getBackStackEntryCount()>2){
                    changeFragmentButton.setVisibility(View.GONE);
                }
                else{
                    changeFragmentButton.setVisibility(View.VISIBLE);
                }
            }
        });
        changeFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });
    }

    void addFragment(){
        Fragment fragment = null;
        switch (fragmentManager.getBackStackEntryCount()){
            case 0: fragment = new Fragment1(); break;
            case 1: fragment = new Fragment2(); break;
            case 2: fragment = new Fragment3(); break;
            default: {
                if(changeFragmentButton!=null){
                    changeFragmentButton.setVisibility(View.GONE);
                    return;
                }
            }
        }

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_window,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}