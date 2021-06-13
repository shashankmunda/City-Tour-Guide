package com.example.lucknowcityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.color.MaterialColors;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
   Button logIn;
   EditText userBox,passBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logIn=findViewById(R.id.loginBtn);
        userBox=findViewById(R.id.user_field);
        passBox=findViewById(R.id.password_field);
        userBox.addTextChangedListener(loginWatcher);
        passBox.addTextChangedListener(loginWatcher);
    }
    private TextWatcher loginWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String usernameInput=userBox.getText().toString().trim();
            String passwordInput=passBox.getText().toString().trim();
            logIn.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}