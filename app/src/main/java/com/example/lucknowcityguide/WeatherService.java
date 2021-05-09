package com.example.lucknowcityguide;
import com.example.lucknowcityguide.model.Example;

import javax.annotation.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("2.5/weather")
    Call<Example> getWeather(@Query("q") String city,@Query("appid") String apiKey);
}
