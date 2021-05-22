package com.example.lucknowcityguide;

import com.example.lucknowcityguide.model_utils.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("2.5/onecall")
    Call<Example> getWeather(@Query("lat") double lat, @Query("lon") double lon, @Query(value="exclude",encoded =true) String exclude, @Query("appid") String apiKey);
}
