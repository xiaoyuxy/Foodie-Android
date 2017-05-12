package com.example.xiaoyuliang.foodie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.xiaoyuliang.foodie.Adapter.RestaurantAdapter;

import java.util.ArrayList;

/**
 * Created by xiaoyuliang on 5/8/17.
 */
public class RestaurantsList extends AppCompatActivity {
    public static final String RESTAURANT_ID ="id" ;
    private ProgressBar bar;;
    Context mcontext = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_list);

//        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        toolbar.setTitle("Restaurants");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<SingleRestaurant> mlist = SingleRestaurant.getRecipesFromFile("friends.json", this);
        RestaurantAdapter adapter=new RestaurantAdapter(this, mlist);

        ListView mListView = (ListView) findViewById(R.id.rest_list_view);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingleRestaurant r = mlist.get(position);

                Intent detailIntent = new Intent(mcontext, SingleRestaurant.class);
                detailIntent.putExtra("title", r.name);
                detailIntent.putExtra("url", r.image);

                startActivity(detailIntent);
            }

        });
        bar=(ProgressBar)findViewById(R.id.progress);

        bar.setVisibility(View.VISIBLE);
        bar.setVisibility(View.INVISIBLE);


    }
}