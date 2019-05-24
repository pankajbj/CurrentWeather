package com.example.pankaj.currentweather.Activity;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.pankaj.currentweather.Database.AppDatabase;
import com.example.pankaj.currentweather.dao.UserDao;
import com.example.pankaj.currentweather.entity.User;

public class UserViewModel extends AndroidViewModel {

    private String TAG=this.getClass().getSimpleName();
    private UserDao userDao;
    private AppDatabase appDatabase;

    private LiveData<User> muser;

    public UserViewModel(@NonNull Application application) {
        super(application);

        appDatabase=AppDatabase.getDatabase(getApplication());
        userDao=appDatabase.userDao();
        muser=userDao.getAl();
    }

    LiveData<User> getalldata(){

        return muser;
    }



    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG,"view Model distroyed");
    }

    private class InsertAsyncTask extends AsyncTask<User,Void,Void>{

        UserDao userDao;
       public InsertAsyncTask(UserDao userDao){
           this.userDao=userDao;
       }
        @Override
        protected Void doInBackground(User... users) {
          userDao.insertAll(users[0]);
           return null;
        }
    }
    public void insert(User user){
        new InsertAsyncTask(userDao).execute(user);
    }
}
