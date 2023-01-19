package com.example.simple_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.button.MaterialButton;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class CoffeeShopListActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_shop_list);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        MaterialButton addShopBtn = findViewById(R.id.addshopbtn);
        MaterialButton inputLocationBtn = findViewById(R.id.inputlocationbtn);

        addShopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(CoffeeShopListActivity.this, AddShopActivity.class));
            }
        });


        // Will likely need to refactor this part for data
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        //Can add sort function here later, will need to refactor shop hours data
        RealmResults<CoffeeShop> coffeeShopList = realm.where(CoffeeShop.class).findAll();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), coffeeShopList);
        recyclerView.setAdapter(myAdapter);

        coffeeShopList.addChangeListener(new RealmChangeListener<RealmResults<CoffeeShop>>() {
            @Override
            public void onChange(RealmResults<CoffeeShop> coffeeShops) {
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(38.6270,-90.1994))
                .title("Marker"));
    }
}