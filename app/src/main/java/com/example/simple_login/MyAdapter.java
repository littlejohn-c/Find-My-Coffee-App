package com.example.simple_login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    RealmResults<CoffeeShop> coffeeShopList;

    public MyAdapter(Context context, RealmResults<CoffeeShop> coffeeShopList) {
        this.context = context;
        this.coffeeShopList = coffeeShopList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CoffeeShop coffeeShop = coffeeShopList.get(position);
        holder.nameOutput.setText(coffeeShop.getName());
        holder.addressOutput.setText(coffeeShop.getAddress());
        holder.hoursOutput.setText(coffeeShop.getHours());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameOutput;
        TextView addressOutput;
        TextView hoursOutput;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOutput = itemView.findViewById(R.id.nameoutput);
            addressOutput = itemView.findViewById(R.id.addressoutput);
            hoursOutput = itemView.findViewById(R.id.hoursoutput);
        }
    }
}
