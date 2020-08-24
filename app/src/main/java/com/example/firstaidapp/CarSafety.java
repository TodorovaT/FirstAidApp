package com.example.firstaidapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class CarSafety extends AppCompatActivity {

    TextView title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_safety);

        title=(TextView)findViewById(R.id.title);
        description=(TextView)findViewById(R.id.description);

        getSupportActionBar().setTitle("Прва Помош");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        description.setMovementMethod(new ScrollingMovementMethod());

    }
}