package com.coolascode.emarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolascode.emarket.R;
import com.coolascode.emarket.modal.Shops;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopsViewHolder> {

    Context context;
    ArrayList<Shops> shopsArrayList;

    public ShopAdapter(Context context, ArrayList<Shops> shopsArrayList) {
        this.context = context;
        this.shopsArrayList = shopsArrayList;
    }

    @NonNull
    @Override
    public ShopsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.shop_item,parent,false);

        return new ShopsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ShopsViewHolder extends RecyclerView.ViewHolder{

        public ShopsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
