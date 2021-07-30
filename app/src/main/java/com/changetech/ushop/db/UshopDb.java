package com.changetech.ushop.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.changetech.ushop.db.dao.UserDao;
import com.changetech.ushop.db.table.User;

@Database(entities = {User.class},version = 1)
public abstract class UshopDb extends RoomDatabase {
    static UshopDb ushopDb;
    public  abstract UserDao userDao();
    public static synchronized UshopDb getUshopDb(Context context){
        if (ushopDb==null)
        {
            ushopDb= Room.databaseBuilder(context.getApplicationContext(),
                    UshopDb.class,"Ushop_Database")
                    .allowMainThreadQueries()
                    .addCallback(roomCallBack)
                    .fallbackToDestructiveMigration().build();
        }
        return ushopDb;
    }
    static RoomDatabase.Callback roomCallBack=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
}
