package com.example.lucknowcityguide;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucknowcityguide.model.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.HTTP;

import static java.lang.Math.atan;
import static java.lang.Math.tan;

public class MainActivity extends AppCompatActivity {
    boolean isFirstTime;
     static String BASE_URL="https://api.openweathermap.org/data/";
    protected static  String PREF_USER_FIRST_TIME="first_time_user";

    TextView tv1,tv2;
    float minTemp= -1,maxTemp=-1,humidity=-1;
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
        tv1=findViewById(R.id.minMax);
        tv2=findViewById(R.id.Humidity);
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
            Call<Example> weatherInfo=weatherCaller.getWeather("Lucknow","d65e4d6135d093df3119a9ca8df7f4b1");
            weatherInfo.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                    Example data=response.body();
                    Log.d("Minimum temperature","Min temp:"+ data.getMain().getTempMin(),null);
                    minTemp=data.getMain().getTempMin()/10;
                    maxTemp=data.getMain().getTempMax()/10;
                    humidity=data.getMain().getHumidity();
                    tv1.setText("Minimum temperature: "+minTemp+"\r\n"+"Maximum temperature: "+maxTemp);
                    tv2.setText("Humidity: "+humidity);
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Not successful :( ", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void simulateHeavyWork() {
        for(int i=0;i<1000000;i++){
           double d = tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(123456789.123456789))))))))));
           String.valueOf(d);
        }
    }
}
