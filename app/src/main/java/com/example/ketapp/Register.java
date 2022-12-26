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

        this.initComponents();
    }

    private void initComponents(){
        txtUsername = findViewById(R.id.username);
        txtNim = findViewById(R.id.nim);
        txtPassword = findViewById(R.id.password);
    }

//    click actions
    public void onBtnRegisterNow_Click (View view) {
        // Tampilkan pesan konfirmasi
        Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show();

        // Kembali ke halaman login
        this.finish();
    }
}