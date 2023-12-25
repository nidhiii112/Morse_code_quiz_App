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

public class Register extends AppCompatActivity {
    EditText email, password;
    Button btn;
    TextView tx1;
    FirebaseAuth Auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email1);
        password = findViewById(R.id.Password1);
        btn = findViewById(R.id.button1);
        tx1 = findViewById(R.id.textView10);

        Auth = FirebaseAuth.getInstance();


        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Signin.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String memail = email.getText().toString();
                final String mpass = password.getText().toString();
                Auth.createUserWithEmailAndPassword(memail,mpass).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(Register.this, "USER HAS BEEN CREATED", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Register.this, "SOMETHING WENT WRONG", Toast.LENGTH_SHORT).show();
                    }


                });
            }
        });
    }
}