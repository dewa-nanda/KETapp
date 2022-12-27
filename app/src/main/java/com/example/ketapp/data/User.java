package com.example.ketapp.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nim")
    public String nim;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "username")
    public String username;
}
