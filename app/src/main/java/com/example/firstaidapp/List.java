package com.example.firstaidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class List extends AppCompatActivity {

    private final String CHANNEL_ID="personal_notifications";
    private final int NOTIFICATION_ID=001;
    RecyclerView recyclerView;
    String s1[],s2[];
    int images[]={R.drawable.a,R.drawable.v,R.drawable.z,R.drawable.empty,R.drawable.i,R.drawable.m,R.drawable.empty,R.drawable.n,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.p,R.drawable.r,R.drawable.s,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.empty,R.drawable.t,R.drawable.empty,R.drawable.sh,R.drawable.empty};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setTitle("Прва Помош");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=findViewById(R.id.recyclerView);

        s1=getResources().getStringArray(R.array.topic);
        s2=getResources().getStringArray(R.array.description);

        MyAdapter myAdapter=new MyAdapter(this,s1,s2,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,"My Notification", NotificationManager.IMPORTANCE_DEFAULT);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void car(MenuItem item) {
        Intent intent=new Intent(List.this,CarSafety.class);
        List.this.startActivity(intent);
    }

    public void phone(MenuItem item) {

        NotificationCompat.Builder builder=new NotificationCompat.Builder(List.this,CHANNEL_ID);
        builder.setContentTitle("Важни броеви");
        builder.setContentText("Брза помош - 194 Полиција - 192 Пожарна - 193");
        builder.setSmallIcon(R.drawable.ic_baseline_notification);
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(List.this);
        managerCompat.notify(NOTIFICATION_ID,builder.build());
    }
}