package com.example.xiaoyuliang.foodie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.xiaoyuliang.foodie.Adapter.CartAdapter;
import com.example.xiaoyuliang.foodie.Models.CartItem;
import com.example.xiaoyuliang.foodie.Models.Meal;

import java.util.ArrayList;

/**
 * Created by xiaoyuliang on 5/8/17.
 */
public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar bar;
    private ArrayList<CartItem> list = new ArrayList<>();
    private CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.v("cart", "activity");

//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        LinearLayoutManager manager = new LinearLayoutManager(CartActivity.this);
//        recyclerView.setLayoutManager(manager);
//        adapter = new CartAdapter(CartActivity.this);
//        recyclerView.setAdapter(adapter);
        bar = (ProgressBar) findViewById(R.id.progress);

        bar.setVisibility(View.GONE);

        Cart singleton = Cart.getInstance();
        if (singleton.getItems() != null) {
            retrofit(singleton.getItems());

        } else {
            bar.setVisibility(View.GONE);
        }

    }

    public void retrofit(ArrayList<Meal> items) {

        if (items.size() == 0) {
            Toast.makeText(this, "No Items in cart !", Toast.LENGTH_SHORT).show();
            bar.setVisibility(View.GONE);

            return;
        }

        adapter.refresh(items);

        Button checkout = (Button) findViewById(R.id.checkout);

        checkout.setVisibility(View.VISIBLE);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cart.reset();
                finish();
            }
        });

        return;

    }
}
