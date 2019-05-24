package com.example.pankaj.currentweather.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pankaj.currentweather.dao.UserDao;
import com.example.pankaj.currentweather.entity.User;

@Database(entities = {User.class},version = 2)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();


    private static volatile AppDatabase noteRoomInstance;
    public static AppDatabase getDatabase(final Context context){
        if(noteRoomInstance==null){
            synchronized (AppDatabase.class){
                if(noteRoomInstance==null){
                    noteRoomInstance=Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,"user_database").build();
                }
            }
        }
        return noteRoomInstance;
    }
}
