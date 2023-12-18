package com.example.fragment_practice;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class DashBoardFragment extends Fragment {

    View views;

    Integer i=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("cus_DashBoardFragment","onCreateView Called");
        // Inflate the layout for this fragment
        views = inflater.inflate(R.layout.fragment_dash_board, container, false);

        Button count_btn = views.findViewById(R.id.frag_dashboard_btn1);
        TextView count = views.findViewById(R.id.dashboard_count_info);


        //count.findViewById(R.id.dashboard_count_info);

        count_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                count.setText("You pressed "+Integer.toString(i)+" times.");
            }
        });

        return views;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("cus_DashBoardFragment","onResume Called");
        TextView count = views.findViewById(R.id.dashboard_count_info);
        count.setText("You pressed "+Integer.toString(i)+" times.");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("cus_DashBoardFragment","onCreate Called");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Log.d("cus_DashBoardFragment","onAttach Called");
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        Log.d("cus_DashBoardFragment","onStart Called");
        super.onStart();
    }

    @Override
    public void onPause() {
        Log.d("cus_DashBoardFragment","onPause Called");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("cus_DashBoardFragment","onStop Called");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("cus_DashBoardFragment","onDestroyView Called");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.d("cus_DashBoardFragment","onDetach Called");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        Log.d("cus_DashBoardFragment","onDestroy Called");
        super.onDestroy();
    }
}