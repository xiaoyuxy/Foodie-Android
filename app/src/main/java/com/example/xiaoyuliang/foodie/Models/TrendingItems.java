package com.example.xiaoyuliang.foodie.Models;

/**
 * Created by xiaoyuliang on 5/8/17.
 */

public class TrendingItems {
    private String text;
    private String url;
    private String restaurant;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
}
