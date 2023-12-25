package com.example.project;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    TextView tx1 , tx2 , tx3, tx4;
    Button btn , bookmarkBtn;
    public static MainActivity getUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tx1 = findViewById(R.id.textView11);
        tx2 = findViewById(R.id.textView12);
        tx3 = findViewById(R.id.textView13);
        tx4 = findViewById(R.id.textView14);
        btn = findViewById(R.id.button3);
        bookmarkBtn = findViewById(R.id.bookmark_button);
        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, LearnActivity.class);
                startActivity(intent);
            }
        });

        bookmarkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,BookmarksActivity.class);
                startActivity(intent);
            }
        });


        tx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, LevelActivity.class);
                startActivity(intent);
            }
        });

        tx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        tx4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}