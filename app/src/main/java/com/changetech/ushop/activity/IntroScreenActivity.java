package com.changetech.ushop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.changetech.ushop.R;
import com.changetech.ushop.activity.auth.SignInActivity;
import com.changetech.ushop.adapter.AdapterPagerIntro;
import com.changetech.ushop.ViewModel.ScreenItem;
import com.changetech.ushop.utils.Tools;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroScreenActivity extends AppCompatActivity {

    ViewPager viewPagerIntro;
    TabLayout tabLayoutIntro;
    AdapterPagerIntro adapterPagerIntro;
    List<ScreenItem> screenItemList;
    int position=0;
    TextView textViewSkip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        viewPagerIntro=findViewById(R.id.viewpager_intro);
        tabLayoutIntro=findViewById(R.id.tablayout_intro);
        textViewSkip=findViewById(R.id.textView_skip);

        screenItemList=new ArrayList<>();
        screenItemList.add(new ScreenItem(getResources().getString(R.string.money_des),getResources().getString(R.string.money_return),R.drawable.ic_save_money_svg));
        screenItemList.add(new ScreenItem(getResources().getString(R.string.delivery_des),getResources().getString(R.string.delivery),R.drawable.ic_free_delivery));
        screenItemList.add(new ScreenItem(getResources().getString(R.string.secure_des),getResources().getString(R.string.secure),R.drawable.ic_credit_card));
        adapterPagerIntro =new AdapterPagerIntro(this,screenItemList);
        viewPagerIntro.setAdapter(adapterPagerIntro);
        tabLayoutIntro.setupWithViewPager(viewPagerIntro);
        textViewSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });



    }
}