package com.example.xiaoyuliang.foodie.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.xiaoyuliang.foodie.CartActivity;
import com.example.xiaoyuliang.foodie.Models.Meal;

import java.util.ArrayList;

/**
 * Created by xiaoyuliang on 5/8/17.
 */
public class CartAdapter extends RecyclerView.Adapter {
    public CartAdapter(CartActivity cartActivity) {

    }

    public void refresh(ArrayList<Meal> items) {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
