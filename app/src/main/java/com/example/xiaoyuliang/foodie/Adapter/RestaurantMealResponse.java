package com.example.xiaoyuliang.foodie.Adapter;

import com.example.xiaoyuliang.foodie.Models.Meal;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by xiaoyuliang on 5/8/17.
 */
public class RestaurantMealResponse {
    @SerializedName("meal")
    private ArrayList<Meal> getAllMeal;

    public ArrayList<Meal> getGetAllMeal() {
        return getAllMeal;
    }

    public void setGetAllMeal(ArrayList<Meal> getAllMeal) {
        this.getAllMeal = getAllMeal;
    }
}
