package com.changetech.ushop.databinding;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.changetech.ushop.R;
import com.changetech.ushop.adapter.HomeSectionAdapter;
import com.changetech.ushop.adapter.ViewPagerSliderAdapter;
import com.changetech.ushop.viewholder.HeaderHolder;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HeaderDataBinding {
    Activity activity;
    ArrayList banner_data;
    ViewPagerSliderAdapter sliderAdapter;
    ViewPager viewPager_slider;
    HomeSectionAdapter homeSectionAdapter;
    String[] top_section = new String[]{"Campaign", "Voucher", "Grocery Store", "Food", "Top Collection"};
    Integer[] top_section_icon = new Integer[]{R.drawable.ic_campaign, R.drawable.ic_voucher, R.drawable.ic_shopping_cart_color, R.drawable.ic_food, R.drawable.ic_shopping_bag};
    private final int sliding_time = 3000;

    private Runnable runnable_image = null;
    private Handler handler_image = new Handler();


    public HeaderDataBinding(Activity activity) {
        this.activity = activity;
        banner_data = new ArrayList();
        homeSectionAdapter = new HomeSectionAdapter(activity, top_section, top_section_icon);
        sliderAdapter = new ViewPagerSliderAdapter(activity, banner_data);

        setSlidingImages();
        startAutoSliderImage();
    }

    public void bindData(HeaderHolder holder){
        viewPager_slider = holder.viewPager_slider;
        holder.rv_top_section.setAdapter(homeSectionAdapter);
        holder.rv_top_section.setLayoutManager(new GridLayoutManager(activity, 5));
        viewPager_slider.setAdapter(sliderAdapter);

        holder.dots_indicator.setViewPager(viewPager_slider);
    }


    private void setSlidingImages(){
        banner_data.clear();
        banner_data.add("https://v5c5v6u7.stackpathcdn.com/wp-content/uploads/2019/02/FAceboook-ecommerce-banner-ads.jpg");
        banner_data.add("https://blog.bannersnack.com/wp-content/uploads/2018/05/animations-e-commerce-1200x720.png");
        banner_data.add("https://s3.amazonaws.com/newfiles.bannersnack.net/lp/35/images/og-ecomerce-banners.png");
        banner_data.add("https://i.pinimg.com/originals/31/f2/89/31f289e7a1b73ade73051f206550bb03.jpg");

        sliderAdapter.notifyDataSetChanged();
    }

    private  void startAutoSliderImage() {
        runnable_image = () -> {
            int pos = viewPager_slider.getCurrentItem();
            pos = pos + 1;
            if (pos >= sliderAdapter.getCount()) pos = 0;
            viewPager_slider.setCurrentItem(pos);
            handler_image.postDelayed(runnable_image, sliding_time);
        };
        handler_image.postDelayed(runnable_image, sliding_time);
    }

}
