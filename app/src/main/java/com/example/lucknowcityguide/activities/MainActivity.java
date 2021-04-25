package com.example.lucknowcityguide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.lucknowcityguide.R;
import com.example.lucknowcityguide.util.Utils;

import static java.lang.Math.atan;
import static java.lang.Math.tan;

public class MainActivity extends AppCompatActivity {
    boolean isFirstTime;
    protected static  String PREF_USER_FIRST_TIME="first_time_user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        simulateHeavyWork();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        isFirstTime=Boolean.valueOf(Utils.readSharedPrefs(MainActivity.this, PREF_USER_FIRST_TIME, "true"));
        Intent introIntent=new Intent(MainActivity.this, PagerActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isFirstTime);
        if(isFirstTime)
            startActivity(introIntent);
        setContentView(R.layout.activity_main);
    }

    private void simulateHeavyWork() {
        for(int i=0;i<1000000;i++){
           double d = tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(123456789.123456789))))))))));
           String.valueOf(d);
        }
    }
}
