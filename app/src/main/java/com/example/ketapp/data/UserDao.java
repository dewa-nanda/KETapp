package com.example.ketapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE username IN (:usernameList)")
    List<User> loadAllByIds(String[] usernameList);

    @Query("SELECT * FROM user LIMIT 1")
    User selectOne();

    @Query("SELECT * FROM user WHERE nim = :nim AND password = :password LIMIT 1")
    User findByNimAndPassword(String nim, String password);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
