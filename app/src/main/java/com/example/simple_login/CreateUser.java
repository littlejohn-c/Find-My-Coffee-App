package com.example.simple_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class CreateUser extends AppCompatActivity {
    EditText username, password, email;
    Button btnConfirm;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        btnConfirm = findViewById(R.id.btnConfirm);
        DB = new DBHelper(this);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String mail = email.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(mail))
                    Toast.makeText(CreateUser.this, "All fields required!", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkAllInfo = DB.checkAllInfo(user, pass, mail);
                    if (checkAllInfo == true) {
                        Toast.makeText(CreateUser.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivityLogin.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(CreateUser.this, "Login failure. Try again.", Toast.LENGTH_SHORT).show();
                    }
                }
//                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(mail))
//                    Toast.makeText(CreateUser.this, "All fields required!", Toast.LENGTH_SHORT).show();
//                else {
//                    Boolean checkUser = DB.checkUsername(user);
//                    if (checkUser == false) {
//                        Boolean insert = DB.insertData(user, pass, String.valueOf(email));
//                        if (insert == true) {
//                            Toast.makeText(CreateUser.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getApplicationContext(), MainActivityLogin.class);
//                            startActivity(intent);
//                        } else {
//                            Toast.makeText(CreateUser.this, "Registration Failed. Try Again.", Toast.LENGTH_SHORT).show();
//                        }
//                    }
                }
            });


//        btnConfirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), MainActivityLogin.class);
//                startActivity(intent);
//            }
//        });
    }
}

