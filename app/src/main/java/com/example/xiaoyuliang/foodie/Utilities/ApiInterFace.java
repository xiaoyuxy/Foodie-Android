package com.example.xiaoyuliang.foodie.Utilities;

import com.example.xiaoyuliang.foodie.Adapter.RestaurantMealResponse;
import com.example.xiaoyuliang.foodie.LoginFragment;
import com.example.xiaoyuliang.foodie.Models.RestaurantDetailResponse;
import com.example.xiaoyuliang.foodie.Models.Restaurant_model;
import com.example.xiaoyuliang.foodie.Models.SearchModel;
import com.example.xiaoyuliang.foodie.Models.UserProfile_model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by xiaoyuliang on 5/8/17.
 */
public interface ApiInterFace {
    @GET("restaurants")
    Call<Restaurant_model> getRestaurants();

    @POST("/profile")
    @FormUrlEncoded
    Call<LoginFragment.UserSentResponse> sendUserData(@Field("name") String name, @Field("picUrl") String picUrl, @Field("email") String email);


    @GET("/search/{keyword}")
    Call<SearchModel> search(@Path("keyword") String keyword);

    @GET("/profile/{id}")
    Call<UserProfile_model> getUserInfo(@Path("id") String id);

    @GET("/meal/{id}")
    Call<RestaurantMealResponse> getRestaurantMeal(@Path("id") int id);

    @GET("/restaurant/{id}")
    Call<RestaurantDetailResponse> getRestaurantDetailResponse(@Path("id") int id);
}
