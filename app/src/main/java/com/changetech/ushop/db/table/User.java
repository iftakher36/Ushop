package com.changetech.ushop.db.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    String user_name;
    @PrimaryKey(autoGenerate = true)
    public int user_id;
    String phone;
    String password;
    String location;
    String email;
    Boolean active=false;


    public User(String user_name, String phone, String password,String email,String location,Boolean active) {
        this.user_name = user_name;
        this.phone = phone;
        this.password = password;
        this.email=email;
        this.location= location;
        this.active=active;
    }

    public Boolean getActive() {
        return active;
    }

    public String getLocation() {
        return location;
    }
    public String getEmail() {
        return email;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }


}
