package com.example.xiaoyuliang.foodie;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by xiaoyuliang on 5/8/17.
 */
public class SingleRestaurant extends AppCompatActivity {
    public String name, image, distance, discription;
    public float rank;
    public Context context;
    private WebView mWebView;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_restaurant);
        String title = this.getIntent().getExtras().getString("title");
        String url = this.getIntent().getExtras().getString("url");
        setTitle(title);
        TextView rest_name = (TextView) findViewById(R.id.rest_name);

        mWebView = (WebView) findViewById(com.example.xiaoyuliang.foodie.R.id.detail_web_view);
        mWebView.loadUrl(url);
    }
    public static ArrayList<SingleRestaurant> getRecipesFromFile(String filename, Context context) {
        final ArrayList<SingleRestaurant> resList = new ArrayList<>();

        try {
            // Load data
            String jsonString = loadJsonFromAsset("restaurant.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray rest = json.getJSONArray("restaurants");

            // Get Recipe objects from data
            for(int i = 0; i < rest.length(); i++){
                SingleRestaurant res = new SingleRestaurant();

                res.name = rest.getJSONObject(i).getString("name");
                res.image = rest.getJSONObject(i).getString("image");
                res.distance = rest.getJSONObject(i).getString("Distance");
                res.discription = rest.getJSONObject(i).getString("Discription");
                res.rank = (float)rest.getJSONObject(i).getDouble("Rank");

                resList.add(res);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return resList;
    }

    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}

