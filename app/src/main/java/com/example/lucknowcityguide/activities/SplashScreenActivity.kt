package com.example.lucknowcityguide.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.lucknowcityguide.R
import com.example.lucknowcityguide.TextWriter

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.splash_screen)
        val tw = findViewById<TextWriter>(R.id.animeView)
        tw.text = ""
        tw.setCharacterDelay(100)
        tw.animateText("Lucknow City Guide")
        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 2000)
    }
}