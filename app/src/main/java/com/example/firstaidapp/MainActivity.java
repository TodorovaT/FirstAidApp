package com.example.firstaidapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.os.Build.ID;

public class MainActivity extends AppCompatActivity {

    Button search;

    private final String CHANNEL_ID="personal_notifications";
    private final int NOTIFICATION_ID=001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Прва Помош");
        search=(Button)findViewById(R.id.search);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,"My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void baram(View view) {
        Intent intent=new Intent(this,List.class);
        MainActivity.this.startActivity(intent);
    }

    public void car(MenuItem item) {
        Intent intent=new Intent(MainActivity.this,CarSafety.class);
        MainActivity.this.startActivity(intent);
    }

    public void phone(MenuItem item) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
        builder.setContentTitle("Важни броеви");
        builder.setContentText("Брза помош - 194 Полиција - 192 Пожарна - 193");
        builder.setSmallIcon(R.drawable.ic_baseline_notification);
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(NOTIFICATION_ID,builder.build());
    }
}