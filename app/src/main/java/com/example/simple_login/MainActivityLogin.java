package com.example.simple_login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivityLogin extends AppCompatActivity {
    TextView username, password;
    Button btnLogin, newUserButton;
    DBHelper DB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnLogin = findViewById(R.id.btnLogin1);
        newUserButton = findViewById(R.id.newUserButton);
        DB = new DBHelper(this);

        btnLogin.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                Toast.makeText(MainActivityLogin.this, "All fields required!", Toast.LENGTH_SHORT).show();
            else {
                Boolean checkuserpass = DB.checkUsernamePassword(user, pass);
                if (checkuserpass) {
                    Toast.makeText(MainActivityLogin.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), CoffeeShopListActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivityLogin.this, "Login failure...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        newUserButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CreateUser.class);
            startActivity(intent);
        });
    }
}