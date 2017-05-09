package com.example.xiaoyuliang.foodie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.xiaoyuliang.foodie.Adapter.RestaurantAdapter;
import com.example.xiaoyuliang.foodie.Models.Restaurant_item;
import com.example.xiaoyuliang.foodie.Models.Restaurant_model;
import com.example.xiaoyuliang.foodie.Utilities.ApiInterFace;
import com.example.xiaoyuliang.foodie.Utilities.RecyclerItemClickListener;
import com.example.xiaoyuliang.foodie.Utilities.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xiaoyuliang on 5/8/17.
 */
public class RestaurantsList extends AppCompatActivity {
    public static final String RESTAURANT_ID ="id" ;
    private RecyclerView recyclerView;
    private ProgressBar bar;
    private ArrayList<Restaurant_item> list=new ArrayList<>();
    private RestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_list);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Restaurants");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager manager=new LinearLayoutManager(RestaurantsList.this);
        recyclerView.setLayoutManager(manager);
        adapter=new RestaurantAdapter(RestaurantsList.this);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i=new Intent(RestaurantsList.this,SingleRestaurant.class);
                i.putExtra(RESTAURANT_ID,list.get(position).getId());
                startActivity(i);
            }
        }));
        bar=(ProgressBar)findViewById(R.id.progress);

        bar.setVisibility(View.VISIBLE);
        retrofit();

    }

    public void retrofit(){

        ApiInterFace apiservice= Utils.getRetrofitService();
        Call<Restaurant_model> call=apiservice.getRestaurants();

        call.enqueue(new Callback<Restaurant_model>() {
            @Override
            public void onResponse(Call<Restaurant_model> call, Response<Restaurant_model> response) {
                bar.setVisibility(View.GONE);

                Restaurant_model model=response.body();
                int status=response.code();

                if(model!=null && response.isSuccess()){
                    recyclerView.setVisibility(View.VISIBLE);

                    list=model.getRestaurants();
                    adapter.refresh(list);

                }else{
                    Toast.makeText(RestaurantsList.this,"Some error occurred!!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Restaurant_model> call, Throwable t) {
                bar.setVisibility(View.GONE);
                Toast.makeText(RestaurantsList.this,"Some error occurred!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
