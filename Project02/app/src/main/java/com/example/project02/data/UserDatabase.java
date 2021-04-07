package com.example.project02.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project02.model.User;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Database(entities = {User.class}, version =1, exportSchema = false)

public abstract class UserDatabase extends RoomDatabase{
//    public static final String USER_TABLE = "USER_TABLE";
//    public static final String DB_TABLE = "DB_TABLE";
    public abstract UserDAO getUserDao();

}
