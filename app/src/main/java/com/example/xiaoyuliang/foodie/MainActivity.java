package com.example.xiaoyuliang.foodie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.xiaoyuliang.foodie.Adapter.HomeRecycleAdapter;
import com.example.xiaoyuliang.foodie.Models.TrendingItems;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageButton b1,b2,b3;
    private CardView cardViewSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Foodie");

        recyclerView=(RecyclerView)findViewById(R.id.home_recycler);
        cardViewSearch= (CardView) findViewById(R.id.cardSearchView);
        cardViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
            }
        });
        HomeRecycleAdapter adapter=new HomeRecycleAdapter(this, getList());

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

        b1=(ImageButton)findViewById(R.id.b1);
        b2=(ImageButton)findViewById(R.id.b2);
        b3=(ImageButton)findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RestaurantsList.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("cart","open");
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserProfile.class));
            }
        });

    }

    public ArrayList<TrendingItems> getList(){
        ArrayList<TrendingItems> items=new ArrayList<>();

        String[] urls={"http://imgur.com/6vIDmHK.jpg",
                "http://imgur.com/04bVzUV.jpg",
                "http://imgur.com/8PMiBQP.jpg",
                "http://imgur.com/pjP4kVD.jpg",
                "http://imgur.com/v0Qel68.jpg",
                };

        String[] titles={"Korea BBQ: 20% off On Order Above $ 39",
                "Panda Express:50% OFF for First Time Customer",
                "Free Meal On All Orders Above $29",
                "Hot pot: Free Drinking",
                "Buy One get One Free"};
        String[] restaurants={"Korea BBQ",
                "Chinese Food",
                "Burger",
                "Hot pot",
                "Pizza"
               };

        for(int i=0;i<restaurants.length;i++){
            TrendingItems item=new TrendingItems();
            item.setText(titles[i]);
            item.setRestaurant(restaurants[i]);
            item.setUrl(urls[i]);

            items.add(item);
        }

        return items;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_settings,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.contact) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            String uriText = "mailto:" +
                    Uri.encode("liangxiaoyu828@gmail.com && camopel@gmail.com")
                    +"?subject=" + Uri.encode("Feedback / Reporting a Bug") + "&body=" +
                    Uri.encode("Hello developers, \nI want to report a bug/give feedback corresponding to this app. \n\n.....\n\n-Your name");

            Uri uri = Uri.parse(uriText);
            intent.setData(uri);
            startActivity(Intent.createChooser(intent, "Send Email"));

            return true;
        }else if(id==R.id.about){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(String.format("%1$s", getString(R.string.app_name)));
            builder.setMessage(getResources().getText(R.string.aboutus));
            builder.setPositiveButton("OK", null);
            builder.setIcon(R.drawable.app_logo);
            AlertDialog welcomeAlert = builder.create();
            welcomeAlert.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
