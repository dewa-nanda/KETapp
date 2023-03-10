package com.example.ketapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class KetDB extends RoomDatabase
{
    public abstract UserDao userDao();
}
