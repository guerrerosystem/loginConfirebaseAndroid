package com.example.cn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

public class esplash extends AppCompatActivity {
    private  static final long SPLASH_SCREEN_DELAY=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esplash);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(esplash.this,login.class);
                startActivity(intent);
                finish();

            }
        };
        Timer timer = new Timer();
        timer.schedule(task,SPLASH_SCREEN_DELAY);
    }




}