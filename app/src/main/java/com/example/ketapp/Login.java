package com.example.ketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    private EditText textUsername, textPassword;
    private CheckBox checkAutoLogin;
    private SharedPreferences sharedPrefs;

    private static final String KEEP_LOGIN_KEY = "key_keep_login";
    private static final String DUMMY_USERNAME = "dewa";
    private static final String DUMMY_PASSWORD = "dewa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.sharedPrefs = this.getSharedPreferences("ket_sharedprefs", Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.initComponents();

        this.autoLogin();
    }

    //    Binding
    private void initComponents(){
        this.textUsername = findViewById(R.id.txt_username);
        this.textPassword = findViewById(R.id.txt_password);
        this.checkAutoLogin = findViewById(R.id.checkAutoLogin);
    }

    //    Click Actions
    public void onBtnLogin_Click(View view){
        boolean valid = this.validateCredential();


        if(valid){
            Intent i = new Intent(Login.this, dashboard.class);
            startActivity(i);

            this.makeAutoLogin();
        }else{
            Toast.makeText(this, "Wrong username/password, please check again", Toast.LENGTH_SHORT).show();
        }


    }
    public void onBtnRegister_Click(View view){
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }

    private void makeAutoLogin()
    {
        SharedPreferences.Editor editor = this.sharedPrefs.edit();

        if(this.checkAutoLogin.isChecked())
            editor.putBoolean(KEEP_LOGIN_KEY, true);
        else
            editor.remove(KEEP_LOGIN_KEY);

        editor.apply();
    }

    private boolean validateCredential()
    {
        String currentUsername = this.textUsername.getText().toString();
        String currentPassword = this.textPassword.getText().toString();

        return (Objects.equals(currentUsername, DUMMY_USERNAME)
                && Objects.equals(currentPassword, DUMMY_PASSWORD));
    }

    // QUIZ!
    private void autoLogin()
    {
        boolean auto = this.sharedPrefs.getBoolean(KEEP_LOGIN_KEY, false);
        if(auto){
            Intent i = new Intent(Login.this, dashboard.class);
            startActivity(i);
        }
    }
}