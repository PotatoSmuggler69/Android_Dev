package com.example.n003;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final String CHANNEL_ID = "CHANNEL_1001";
    private Button press_me_button = null;
    private EditText textfield = null;
    private Integer NOTIFICATION_ID = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        press_me_button = findViewById(R.id.btn_pressme);
        textfield = findViewById(R.id.insert_txt);
        press_me_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotificationChannel();
                startNotification(NOTIFICATION_ID++,textfield.getText().toString());
            }
        });

    }
    private void startNotification(int NOTIFICATION_ID,String message){
        // Create an explicit intent for an Activity in your app.
        Intent intent = new Intent(this, SecondActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Message Received")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                //this sets the pending content
                .setContentIntent(pendingIntent)
                // this automatically end the notification
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)!= PackageManager.PERMISSION_GRANTED){
            Log.d("FATAL","Notification Launcher Failed");
            return;
        }
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
    }

    private void createNotificationChannel(){
        //creating the notification channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            channel.shouldVibrate();
            // Register the channel with the system. You can't change the importance
            // or other notification behaviors after this.
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

    }


    //Overrriding other lifecycle function to check the lifespan
    //when the pendingIntent runs


    @Override
    protected void onPause() {
        Log.d("Life_Cycle","--> On Pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("Life_Cycle","--> On Start");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d("Life_Cycle","--> On Resume");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d("Life_Cycle","--> On Destroy");
        super.onDestroy();
    }
}