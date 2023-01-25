package com.example.simple_login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivityLogin extends AppCompatActivity {
    TextView username, password, email;
    Button btnLogin;
    DBHelper DB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnLogin = findViewById(R.id.btnLogin1);
        DB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


//        btnLogin = findViewById(R.id.newUserButton);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchActivities();
//            }
//        });
//
//
//
//        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
//        MaterialButton newUser = (MaterialButton)  findViewById(R.id.newUserButton);
//
//        //admin and admin
//
//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i = new Intent(getApplicationContext(),CoffeeShopListActivity.class);
//                startActivity(i);
//
//            }
//        });
//    }
//
//    private void switchActivities() {
//        Intent switchActivityIntent = new Intent(this, CreateUser.class);
//        startActivity(switchActivityIntent);
//    }


    }
}