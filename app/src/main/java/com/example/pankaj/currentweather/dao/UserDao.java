package com.example.pankaj.currentweather.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.pankaj.currentweather.entity.User;

@Dao
public interface UserDao {


    @Query("SELECT * FROM user ORDER BY uid ASC")
   LiveData <User> getAl();


    @Insert
    void insertAll(User users);
}
