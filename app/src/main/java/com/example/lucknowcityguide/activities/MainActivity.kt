package com.example.lucknowcityguide.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lucknowcityguide.R
import com.example.lucknowcityguide.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.addAuthStateListener(authStateListener)
    }

    private var authStateListener = AuthStateListener { firebaseAuth: FirebaseAuth ->
        val user = firebaseAuth.currentUser
        if (user == null) {
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}