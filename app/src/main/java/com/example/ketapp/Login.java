package com.example.ketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    EditText textUsername;
    EditText textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //        Binding Text Username
        textUsername = findViewById(R.id.txt_username);
        textPassword = findViewById(R.id.txt_password);
    }

    public void clickLoginAccount(View view) {
        if (TextUtils.isEmpty(textUsername.getText().toString().trim()) || TextUtils.isEmpty(textPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Username tidak boleh kosong!", Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(Login.this, dashboard.class);
            startActivity(i);
        }
    }

    public void clickCreateAccount(View view){
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }
}