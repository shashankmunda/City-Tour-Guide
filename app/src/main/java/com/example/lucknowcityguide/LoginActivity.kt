package com.example.lucknowcityguide

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var logIn: Button
    lateinit var userBox: EditText
    lateinit var passBox: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        logIn = findViewById(R.id.loginBtn)
        userBox = findViewById(R.id.user_field)
        passBox = findViewById(R.id.password_field)
        userBox.addTextChangedListener(loginWatcher)
        passBox.addTextChangedListener(loginWatcher)
    }

    private val loginWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val usernameInput = userBox.text.toString().trim { it <= ' ' }
            val passwordInput = passBox.text.toString().trim { it <= ' ' }
            logIn.isEnabled = usernameInput.isNotEmpty() && passwordInput.isNotEmpty()
        }

        override fun afterTextChanged(s: Editable) {}
    }
}