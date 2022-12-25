package com.example.ketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void clickLoginAccount(View view){
        Intent i = new Intent(Login.this, dashboard.class);
        startActivity(i);
    }

    public void clickCreateAccount(View view){
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }
}