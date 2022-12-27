package com.example.ketapp.data;

import androidx.room.Room;
import android.content.Context;

public class AppDbProvider
{
    private static KetDB instance;

    public static KetDB getInstance(Context context)
    {
        if(AppDbProvider.instance == null)
        {
            AppDbProvider.instance = Room.databaseBuilder(
                    context, KetDB.class, "dtsapp.db").allowMainThreadQueries().build();
        }

        return AppDbProvider.instance;
    }
}
