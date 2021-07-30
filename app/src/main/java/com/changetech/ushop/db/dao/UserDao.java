package com.changetech.ushop.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.changetech.ushop.db.table.User;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);
    @Update

    void update(User user);

    @Query("SELECT * FROM user_table WHERE phone =:phones")
    LiveData<User> getUser(String phones);

}
