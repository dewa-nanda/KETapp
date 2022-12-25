package com.example.ketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText txtUsername;
    EditText txtNim;
    EditText txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUsername = findViewById(R.id.username);
        txtNim = findViewById(R.id.nim);
        txtPassword = findViewById(R.id.password);
    }

    public void postCreateAcc (View view) {
        if(TextUtils.isEmpty(txtUsername.getText().toString().trim()) || TextUtils.isEmpty(txtNim.getText().toString().trim()) || TextUtils.isEmpty(txtNim.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Username / Password tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }else{
            Intent i = new Intent(Register.this, Login.class);
            startActivity(i);
        }
    }
}