package com.example.project;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signin extends AppCompatActivity {
    EditText email, pass;
    Button btn;
    TextView text1;
    FirebaseAuth Fauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        email = findViewById(R.id.email);
        pass = findViewById(R.id.Password);
        btn = findViewById(R.id.button);
        text1 = findViewById(R.id.textView8);

        Fauth = FirebaseAuth.getInstance();

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Signin.this, Register.class);
                startActivity(intent);

            }
        });

        if (Fauth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
            finish();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //final String user = username.getText().toString();
                final String passw = pass.getText().toString();
                final String semail = email.getText().toString();

                Fauth.signInWithEmailAndPassword(semail,passw).addOnCompleteListener(task -> {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(Signin.this, "Logged in successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Dashboard.class));
                    }else {
                        Toast.makeText(Signin.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });



    }
}