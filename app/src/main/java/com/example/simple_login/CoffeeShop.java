package com.example.simple_login;

import io.realm.RealmObject;

public class CoffeeShop extends RealmObject {
    String name;
    String address;
    String hours;

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
