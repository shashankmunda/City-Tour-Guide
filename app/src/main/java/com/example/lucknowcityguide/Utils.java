package com.example.lucknowcityguide;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class Utils {
    private static final String PREFERENCES_FILE="pref_settings";
    public static String readSharedPrefs(Context ctx,String settingName,String defaultValue){
        SharedPreferences sharedPrefs=ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        return sharedPrefs.getString(settingName, defaultValue);
    }
    public static void saveSharedPref(Context ctx,String settingName,String settingValue){
        SharedPreferences sharedPrefs=ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPrefs.edit();
        editor.putString(settingName, settingValue);
        editor.apply();
    }
    public static boolean checkNetworkAvailable(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isConnectedOrConnecting();
    }
}
