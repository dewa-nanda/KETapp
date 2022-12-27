package com.example.ketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ketapp.data.AppDbProvider;
import com.example.ketapp.data.User;
import com.example.ketapp.data.UserDao;

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
        boolean check = auth();

        if(check){
            UserDao daoUser = AppDbProvider.getInstance(this.getApplicationContext()).userDao();

            daoUser.insertAll(this.makeUser());

            Toast.makeText(this, "Register Success!", Toast.LENGTH_SHORT).show();

            this.finish();
        }
    }

    private boolean auth() {
        String nim = this.txtNim.getText().toString().trim();
        String username = this.txtUsername.getText().toString().trim();
        String password = this.txtPassword.getText().toString().trim();

        if(TextUtils.isEmpty(nim) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(this, "seluruh field harus diisi!", Toast.LENGTH_SHORT).show();
        }else{
            return true;
        }

        return false;
    }
//    Make user
    private User makeUser()
    {
        User u = new User();
        u.username = this.txtUsername.getText().toString();
        u.password = this.txtPassword.getText().toString();
        u.nim = this.txtNim.getText().toString();

        return u;
    }
}