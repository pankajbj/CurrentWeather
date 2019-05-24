package com.example.pankaj.currentweather.Rest;

import com.example.pankaj.currentweather.Model.MyModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("v1/{category}")
    Call<MyModel> getData(
            @Path("category") String category,
            @Query("key") String key,
            @Query("q") String q
    );
}
//http://api.apixu.com/v1/current.json?key=23f8d0450ac946e58ae155120192803&q=aurangabad