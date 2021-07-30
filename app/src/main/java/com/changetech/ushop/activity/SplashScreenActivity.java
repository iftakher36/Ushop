package com.changetech.ushop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.changetech.ushop.R;
import com.changetech.ushop.utils.Tools;

public class SplashScreenActivity extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            Intent intent=new Intent(getApplicationContext(), IntroScreenActivity.class);
            startActivity(intent);
            finish();
            }
        },2000);
    }
}