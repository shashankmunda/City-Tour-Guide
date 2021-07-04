package com.example.lucknowcityguide

import com.example.lucknowcityguide.model_utils.Example
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("2.5/onecall")
    fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query(value = "exclude", encoded = true) exclude: String?,
        @Query("appid") apiKey: String?
    ): Call<Example?>?
}