package com.example.lucknowcityguide.activities

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.lucknowcityguide.R
import com.example.lucknowcityguide.Utils
import com.example.lucknowcityguide.WeatherService
import com.example.lucknowcityguide.model_utils.Example
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textview.MaterialTextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.atan
import kotlin.math.roundToInt
import kotlin.math.tan

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var isFirstTime = false
    var excludeList = listOf("minutely,hourly,alerts")
    var minTemp = -1
    var maxTemp = -1
    var wtrMood: MaterialTextView? = null
    private lateinit var tmView: MaterialTextView
    var minTempView: MaterialTextView? = null
    var maxTempView: MaterialTextView? = null
    var tempBox: MaterialTextView? = null
    var weatherIcon: Drawable? = null
    var wtrImg: ImageView? = null
    var weatherView: MaterialCardView? = null
    var container: ShimmerFrameLayout? = null
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var menuBtn: MaterialButton
    private lateinit var mainView: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        simulateHeavyWork()
        isFirstTime = java.lang.Boolean.valueOf(
            Utils.readSharedPrefs(
                this@HomeActivity,
                PREF_USER_FIRST_TIME,
                "true"
            )
        )
        val introIntent = Intent(this@HomeActivity, PagerActivity::class.java)
        introIntent.putExtra(PREF_USER_FIRST_TIME, isFirstTime)
        if (isFirstTime) startActivity(introIntent)
        setContentView(R.layout.activity_home)
        container = findViewById(R.id.shimmer_view_frame)
        wtrImg = findViewById(R.id.weather_icon_view)
        tmView = findViewById(R.id.time_view)
        minTempView = findViewById(R.id.miniTemp)
        maxTempView = findViewById(R.id.maxiTemp)
        tempBox = findViewById(R.id.curr_temp_view)
        wtrMood = findViewById(R.id.weather_type)
        weatherView = findViewById(R.id.weather_view)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        menuBtn = findViewById(R.id.menu_icon)
        mainView = findViewById(R.id.main_screen)
        container!!.startShimmer()
        weather
        setNavigationDrawer()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }

    private fun setNavigationDrawer() {
        navigationView.bringToFront()
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(R.id.nav_home)
        menuBtn.setOnClickListener {
            if (drawerLayout.isDrawerVisible(GravityCompat.START)) drawerLayout.closeDrawer(
                GravityCompat.START
            ) else drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) drawerLayout.closeDrawer(
            GravityCompat.START
        ) else super.onBackPressed()
    }

    private val weather: Unit
        get() {
            val conn = Utils.checkNetworkAvailable(this)
            if (conn) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val weatherCaller = retrofit.create(WeatherService::class.java)
                val weatherInfo = weatherCaller.getWeather(
                    latitude,
                    longitude,
                    "minutely,hourly,alerts",
                    "d65e4d6135d093df3119a9ca8df7f4b1"
                )
                weatherInfo!!.enqueue(object : Callback<Example?> {
                    override fun onResponse(call: Call<Example?>, response: Response<Example?>) {
                        val weather = response.body()
                        val epoch = weather!!.current.dt * 1000L
                        val currTemp = weather.current.temp.toInt() / 10
                        maxTemp = (weather.daily[0].temp.max / 10).roundToInt()
                        minTemp = (weather.daily[0].temp.min / 10).roundToInt()
                        val weatherMood = weather.current.weather[0].main
                        val icon = weather.current.weather[0].icon
                        maxTempView!!.text = "Daily max: $maxTemp"
                        minTempView!!.text = "Daily min: $minTemp"
                        tempBox!!.text = currTemp.toString()
                        epochToDateTime(epoch)
                        iconPicker(icon)
                        if (weatherIcon != null) wtrImg!!.setImageDrawable(weatherIcon)
                        wtrMood!!.text = weatherMood
                        container!!.stopShimmer()
                        container!!.visibility = View.GONE
                        weatherView!!.visibility = View.VISIBLE
                    }

                    override fun onFailure(call: Call<Example?>, t: Throwable) {}
                })
            }
        }

    private fun epochToDateTime(epoch: Long) {
        val date = Date(epoch)
        val format: DateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm")
        format.timeZone = TimeZone.getTimeZone("GMT+5:30")
        val formatted = format.format(date)
        tmView.text = formatted
    }

    private fun iconPicker(icon: String) {
        when (icon) {
            "01d" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w01d)
            "01n" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w01n)
            "02d" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w02d)
            "02n" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w02n)
            "03d", "03n" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w03d)
            "04d", "04n" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w04d)
            "09d", "09n" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w09d)
            "10d", "10n" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w10d)
            "11d", "11n" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w11d)
            "13d", "13n" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w13d)
            "50d", "50n" -> weatherIcon = ContextCompat.getDrawable(this, R.drawable.w50d)
        }
    }

    private fun simulateHeavyWork() {
        for (i in 0..999999) {
            val d = tan(
                atan(
                    tan(
                        atan(
                            tan(
                               atan(
                                    tan(
                                     atan(
                                          tan(atan(123456789.123456789))
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
            d.toString()
        }
    }

    fun onNavigationItemSelectedListener(): Boolean {
        return true
    }

    public override fun onPause() {
        super.onPause()
        container!!.stopShimmer()
    }

    public override fun onResume() {
        super.onResume()
        container!!.startShimmer()
        weather
    }

    companion object {
        var BASE_URL = "https://api.openweathermap.org/data/"
        var PREF_USER_FIRST_TIME = "first_time_user"
        var latitude = 26.84
        var longitude = 80.94
    }
}