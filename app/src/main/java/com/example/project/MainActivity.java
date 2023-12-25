package com.example.project;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MainActivity IsLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IsLogin = Dashboard.getUserName;

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                {
                    Intent startLandingPageActivity = new Intent(MainActivity.this, Signin.class);
                    startActivity(startLandingPageActivity);
                }

            }
        }, 2000);
    }
}