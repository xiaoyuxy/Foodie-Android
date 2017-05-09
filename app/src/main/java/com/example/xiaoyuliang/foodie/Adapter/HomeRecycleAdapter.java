package com.example.xiaoyuliang.foodie.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.xiaoyuliang.foodie.Models.TrendingItems;
import com.example.xiaoyuliang.foodie.R;

import java.util.ArrayList;

/**
 * Created by xiaoyuliang on 5/8/17.
 */

public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TrendingItems> arrayList=new ArrayList<>();

    public HomeRecycleAdapter(Context context) {
        this.context = context;
    }

    public HomeRecycleAdapter(Context context, ArrayList<TrendingItems> arrayList) {
        this.context = context;
        this.arrayList=arrayList;

        //notifyDataSetChanged();
    }

    public void refresh(ArrayList<TrendingItems> list){
        arrayList=list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trending,parent,false);
        ViewHolder view_holder = new ViewHolder(view);
        return view_holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(arrayList!=null){

            holder.title.setText(arrayList.get(position).getText());
            holder.restaurant.setText(arrayList.get(position).getRestaurant());

            Glide.with(context).load(arrayList.get(position).getUrl()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.img);

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title,restaurant;
        private ImageView img;

        public ViewHolder(View v){
            super(v);
            this.img=(ImageView)v.findViewById(R.id.img);
            this.title = (TextView)v.findViewById(R.id.title);
            this.restaurant = (TextView) v.findViewById(R.id.restaurant);

        }
    }
}
