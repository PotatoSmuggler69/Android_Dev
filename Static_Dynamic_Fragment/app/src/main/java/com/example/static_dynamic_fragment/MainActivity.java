package com.example.static_dynamic_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_Fagment();

        b = findViewById(R.id.dynamic_fragment_button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.dynamic_fragment,new DynamicFragment()).commit();
            }
        });
    }

    private void add_Fagment(){
        getSupportFragmentManager().beginTransaction().add(R.id.static_fragment,new DummyFragment());
    }


}