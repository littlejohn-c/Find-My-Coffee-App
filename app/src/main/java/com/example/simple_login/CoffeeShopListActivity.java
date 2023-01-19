package com.example.simple_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

public class CoffeeShopListActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shop_list);



        // Will likely need to refactor this part for data
        Realm.init (getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getDefaultInstance();
        //Can add sort function here later, will need to refactor shop hours data
        RealmResults<CoffeeShop> coffeeShopList = realm.where(CoffeeShop.class).findAll();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), coffeeShopList);
        recyclerView.setAdapter(myAdapter);

        MaterialButton addShopBtn = findViewById(R.id.addshopbtn);
        MaterialButton inputLocationBtn = findViewById(R.id.inputlocationbtn);


        addShopBtn.setOnClickListener(v -> startActivity(new Intent(CoffeeShopListActivity.this, AddShopActivity.class)));

        inputLocationBtn.setOnClickListener(v -> startActivity(new Intent(CoffeeShopListActivity.this, MapsFragment.class)));



        coffeeShopList.addChangeListener(coffeeShops -> myAdapter.notifyDataSetChanged());
    }
}