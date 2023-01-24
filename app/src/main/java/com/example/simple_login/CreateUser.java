package com.example.simple_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class CreateUser extends AppCompatActivity {
    Button confirmbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);


    confirmbtn = findViewById(R.id.confirmbtn);
        confirmbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {switchActivities();}
    });

    TextView username = (TextView) findViewById(R.id.username);
    TextView password = (TextView) findViewById(R.id.password);
    TextView email = (TextView) findViewById(R.id.email);

    MaterialButton confirmbtn = (MaterialButton)  findViewById(R.id.confirmbtn);

    //admin and admin

        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), MainActivityLogin.class);
                startActivity(i);
            }
        }
    }


    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, MainActivityLogin.class);
        startActivity(switchActivityIntent);
    });
        }