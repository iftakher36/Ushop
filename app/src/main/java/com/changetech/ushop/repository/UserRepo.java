package com.changetech.ushop.repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.changetech.ushop.db.dao.UserDao;
import com.changetech.ushop.db.UshopDb;
import com.changetech.ushop.db.table.User;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepo {
    UserDao userDao;

    public UserRepo(Application application) {
        UshopDb ushopDb = UshopDb.getUshopDb(application);
        userDao = ushopDb.userDao();
    }

    public void insert(User user) {
        new InsertAsyncTask(userDao).execute(user);
    }

    public LiveData<User> getUser(String phone) {

        return userDao.getUser(phone);
    }

    static class InsertAsyncTask extends AsyncTask<User, Void, Void> {
        UserDao userDao;

        public InsertAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... user) {
            userDao.insert(user[0]);
            return null;
        }
    }


}
