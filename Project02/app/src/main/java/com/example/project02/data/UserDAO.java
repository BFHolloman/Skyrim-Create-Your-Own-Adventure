package com.example.project02.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.project02.model.User;

import java.util.List;

@Dao
public interface UserDAO {

//inserting user
    @Insert
    void insert(User... user);
    @Delete
    void delete(User user);

    @Query("SELECT DISTINCT * FROM  User")
    List<User> getAllUsers();
//database of user login info
    @Query("SELECT * FROM User WHERE email = :email and password = :password")
    User getUser(String email, String password);


}
