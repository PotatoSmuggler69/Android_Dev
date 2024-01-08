package com.tollcafe.aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tollcafe.aidlserver.IAIDLColorInterface;

public class MainActivity extends AppCompatActivity {

    IAIDLColorInterface iADILColorService;
    private static final String TAG ="MainActivity";

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iADILColorService = IAIDLColorInterface.Stub.asInterface(iBinder);
            Log.d(TAG, "Remote config Service Connected!!");

            // Now the service is connected, you can perform UI updates here if needed
            updateUI();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            iADILColorService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ... (other code)

        // Create an onclick listener to button
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The onClick method can now call updateUI directly
                updateUI();
            }
        });
    }

    private void updateUI() {
        if (iADILColorService != null) {
            try {
                int color = iADILColorService.getColor();
                findViewById(R.id.button).setBackgroundColor(color);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            Log.e(TAG, "iADILColorService is null");
        }
    }

}