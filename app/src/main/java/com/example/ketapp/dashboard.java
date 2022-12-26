package com.example.ketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {
    private SharedPreferences sharedPrefs;
    private static final String KEEP_LOGIN_KEY = "key_keep_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sharedPrefs = getSharedPreferences("ket_sharedprefs", Context.MODE_PRIVATE);
    }

//    click actions
    public void clickLogout(View view){
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.remove(KEEP_LOGIN_KEY);
        editor.apply();
        Toast.makeText(this, "Logout Success!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(dashboard.this, Login.class);
        startActivity(i);
    }
}