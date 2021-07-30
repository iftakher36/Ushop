package com.changetech.ushop.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.changetech.ushop.repository.UserRepo;
import com.changetech.ushop.db.table.User;

public class UserViewModel extends AndroidViewModel {
    UserRepo userRepo;
    LiveData<User> user;
    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepo=new UserRepo(application);
    }
    public void insert(User user)
    {
        userRepo.insert(user);
    }
    public LiveData<User> getUser(String phone)
    {
        user=userRepo.getUser(phone);
        return user;
    }
}
