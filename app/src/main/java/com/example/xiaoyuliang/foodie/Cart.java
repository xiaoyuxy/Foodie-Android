package com.example.xiaoyuliang.foodie;

import android.util.Log;

import com.example.xiaoyuliang.foodie.Models.Meal;

import java.util.ArrayList;

/**
 * Created by xiaoyuliang on 5/8/17.
 */
public class Cart {
    private static Cart obj;
    private static ArrayList<Meal> items;
    //private ArrayList<String> names;

    private Cart(){
        items=new ArrayList<>();
        //names=new ArrayList<>();
    }

    public static void reset(){
        obj=new Cart();
    }

    public static Cart getInstance(){
        if(obj==null){
            obj=new Cart();

        }

        return obj;
    }

    public ArrayList<Meal> getItems(){
        return items;
    }

    public boolean checkInCart(int id){
        if(obj==null){
            obj=new Cart();
            return false;
        }

        boolean b=false;

        for(int i=0;i<items.size();i++){
            if(items.get(i).getId()==id){
                Log.v("found","in cart");
                b=true;
                break;
            }
        }

        return b;
    }

    public void addToCart(Meal item){
        if(obj==null){
            obj=new Cart();
        }

        Log.v("adding to cart",""+item.getId());

        int flag=0;

        for(int i=0;i<items.size();i++){
            if(items.get(i).getId()==item.getId()){
                flag=1;
                Log.v("Singleton obj","already in cart");

                return;
            }
        }

        Log.v("Singleton obj","added to cart");

        obj.items.add(item);
        //obj.names.add(item.getName());

    }
}
