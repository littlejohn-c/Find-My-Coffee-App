package com.example.simple_login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivityLogin extends AppCompatActivity {
    TextView username, password, email;
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
        DB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(MainActivityLogin.this, "All fields required!", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkUsernamePassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(MainActivityLogin.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), CoffeeShopListActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivityLogin.this, "Login failure...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateUser.class);
                startActivity(intent);
            }
        });
    }
}