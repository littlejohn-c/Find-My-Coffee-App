package com.example.simple_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import io.realm.Realm;

public class AddShopActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shop);

        EditText nameInput = findViewById(R.id.nameinput);
        EditText addressInput = findViewById(R.id.addressinput);
        EditText hoursInput = findViewById(R.id.hoursinput);
        MaterialButton saveBtn = findViewById(R.id.savebtn);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String address = addressInput.getText().toString();
                String hours = hoursInput.getText().toString();

                realm.beginTransaction();
                CoffeeShop coffeeShop = realm.createObject(CoffeeShop.class);
                coffeeShop.setName(name);
                coffeeShop.setAddress(address);
                coffeeShop.setHours(hours);
                realm.commitTransaction();
                Toast.makeText(getApplicationContext(),"Shop Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}