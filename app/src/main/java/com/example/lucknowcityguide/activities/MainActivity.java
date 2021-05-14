package com.example.lucknowcityguide.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucknowcityguide.R;
import com.example.lucknowcityguide.Utils;
import com.example.lucknowcityguide.WeatherService;
import com.example.lucknowcityguide.model.Example;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.Math.atan;
import static java.lang.Math.tan;

public class MainActivity extends AppCompatActivity {
    boolean isFirstTime;

     static String BASE_URL="https://api.openweathermap.org/data/";
    protected static  String PREF_USER_FIRST_TIME="first_time_user";
    static double latitude=26.84,longitude=80.94;
     List<String> excludeList=Arrays.asList("minutely,hourly,alerts");
    int minTemp= -1,maxTemp=-1;
    TextView wtrMood,tmView,minTempView,maxTempView;
    Drawable weatherIcon=null;
    ImageView wtrImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        simulateHeavyWork();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        isFirstTime = Boolean.valueOf(Utils.readSharedPrefs(MainActivity.this, PREF_USER_FIRST_TIME, "true"));
        Intent introIntent = new Intent(MainActivity.this, PagerActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isFirstTime);
        if (isFirstTime)
           startActivity(introIntent);

        setContentView(R.layout.activity_main);

        wtrImg=findViewById(R.id.weather_icon_view);
        tmView=findViewById(R.id.time_view);
        minTempView=findViewById(R.id.miniTemp);
        maxTempView=findViewById(R.id.maxiTemp);
        wtrMood=findViewById(R.id.weather_type);
       getWeather();
    }

    private void getWeather() {
        boolean conn=Utils.checkNetworkAvailable(this);
        if(conn){
            Retrofit retrofit=new Retrofit.Builder()
                                    .baseUrl(BASE_URL)
                                  .addConverterFactory(GsonConverterFactory.create())
                                  .build();
            WeatherService weatherCaller=retrofit.create(WeatherService.class);
            Call<Example> weatherInfo=weatherCaller.getWeather(latitude,longitude, "minutely,hourly,alerts","d65e4d6135d093df3119a9ca8df7f4b1");
            weatherInfo.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    Toast.makeText(getApplicationContext(), "Connection success.", Toast.LENGTH_SHORT).show();
                    Example weather=response.body();
                    Log.d("CONNECTION STATUS","Connection code:"+response.code());
                    long epoch=weather.getCurrent().getDt();
                   float currTemp=weather.getCurrent().getTemp();
                   maxTemp=Math.round(weather.getDaily().get(0).getTemp().getMax()/10);
                   minTemp=Math.round(weather.getDaily().get(0).getTemp().getMin()/10);
                   String weatherMood=weather.getCurrent().getWeather().get(0).getMain();
                  String icon= weather.getCurrent().getWeather().get(0).getIcon();
                  maxTempView.setText("Daily max: "+String.valueOf(maxTemp));
                  minTempView.setText("Daily min: "+String.valueOf(minTemp));
                  epochToDateTime(epoch);
                  iconPicker(icon);
                  if(weatherIcon!=null)
                      wtrImg.setImageDrawable(weatherIcon);
                  wtrMood.setText(weatherMood);
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t){
                    String z=t.getMessage();
                    Log.d("ERROR MESSAGE",z);
                }
            });
        }
    }

    private void epochToDateTime(long epoch) {
        Date date=new Date(epoch);
        DateFormat format=new SimpleDateFormat("dd-MM-yyyy HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        String formatted=format.format(date);
        tmView.setText(formatted);
    }

    private void iconPicker(String icon) {
        switch(icon){
            case "01d":
                weatherIcon=ContextCompat.getDrawable(this,R.drawable.w01d);
                break;
            case "01n":
                weatherIcon=ContextCompat.getDrawable(this,R.drawable.w01n);
                break;
            case "02d":
                weatherIcon=ContextCompat.getDrawable(this,R.drawable.w02d);
                break;
            case "02n":
                weatherIcon=ContextCompat.getDrawable(this,R.drawable.w02n);
                break;
            case "03d": case "03n":
                weatherIcon=ContextCompat.getDrawable(this,R.drawable.w03d);
                break;
            case "04d": case "04n":
                weatherIcon=ContextCompat.getDrawable(this,R.drawable.w04d);
                break;
            case "09d": case "09n":
                weatherIcon=ContextCompat.getDrawable(this,R.drawable.w09d);
                break;
            case "10d": case "10n":
                weatherIcon=ContextCompat.getDrawable(this,R.drawable.w10d);
                break;
            case "11d": case "11n":
                weatherIcon= ContextCompat.getDrawable(this,R.drawable.w11d);
                break;
            case "13d": case "13n":
                weatherIcon=ContextCompat.getDrawable(this,R.drawable.w13d);
                break;
            case "50d": case "50n":
                weatherIcon=ContextCompat.getDrawable(this,R.drawable.w50d);
                break;

        }
    }

    private void simulateHeavyWork() {
        for(int i=0;i<1000000;i++){
           double d = tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(123456789.123456789))))))))));
           String.valueOf(d);
        }
    }
}
