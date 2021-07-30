package com.changetech.ushop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.changetech.ushop.R;
import com.changetech.ushop.utils.Tools;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }
}