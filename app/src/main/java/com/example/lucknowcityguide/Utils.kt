package com.example.lucknowcityguide

import android.content.Context
import android.net.ConnectivityManager

object Utils {
    private const val PREFERENCES_FILE = "pref_settings"
    fun readSharedPrefs(ctx: Context, settingName: String?, defaultValue: String?): String? {
        val sharedPrefs = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
        return sharedPrefs.getString(settingName, defaultValue)
    }

    fun saveSharedPref(ctx: Context, settingName: String?, settingValue: String?) {
        val sharedPrefs = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putString(settingName, settingValue)
        editor.apply()
    }

    fun checkNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }
}