package com.example.lucknowcityguide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lucknowcityguide.R;
import com.example.lucknowcityguide.SignUpActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
    FirebaseAuth.AuthStateListener authStateListener= firebaseAuth -> {
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user==null){
            Intent intent=new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
    };
}