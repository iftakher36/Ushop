package com.changetech.ushop.databinding;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.changetech.ushop.adapter.HomeCategoryAdapter;
import com.changetech.ushop.ViewModel.Category;
import com.changetech.ushop.viewholder.CategoryHolder;

import java.util.ArrayList;

public class CategoryDataBinding {
    Activity activity;
    ArrayList homeCategoryList, specialCategoryList;
    HomeCategoryAdapter categoryAdapter, specialCategoryAdapter;

    public CategoryDataBinding(Activity activity) {
        this.activity = activity;

        homeCategoryList = new ArrayList();
        specialCategoryList = new ArrayList();

        categoryAdapter = new HomeCategoryAdapter(activity, homeCategoryList);
        specialCategoryAdapter = new HomeCategoryAdapter(activity, specialCategoryList);

        setCategory();
        setSpecialItems();
    }

    public void bindData(CategoryHolder holder){
        holder.rv_categories.setAdapter(categoryAdapter);
        holder.rv_special_sales.setAdapter(specialCategoryAdapter);

        holder.rv_categories.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        holder.rv_special_sales.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

        holder.tv_btn_see_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setCategory(){
        homeCategoryList.clear();

        homeCategoryList.add(new Category(1, "Men's", "//atailoredsuit.com/wp-content/uploads/2014/12/Gray-Suit.jpg"));
        homeCategoryList.add(new Category(2, "Jackets", "//images-na.ssl-images-amazon.com/images/I/51-cw1DQaGL._AC_UL1000_.jpg"));
        homeCategoryList.add(new Category(3, "Shoes", "//media2.s-nbcnews.com/j/newscms/2020_24/3214106/saucony-shoes-061120_3d8d79ac88bfde6767e4612ba7abb751.fit-720w.jpg"));
        homeCategoryList.add(new Category(3, "Women's", "//imcut.jollychic.com//uploads/jollyimg/imageLibrary/201807/7AK/18/IL201807181610317651.jpg"));
        homeCategoryList.add(new Category(3, "Electronics", "//images.herzindagi.info/image/2020/Apr/Electronics.jpg"));

        categoryAdapter.notifyDataSetChanged();
    }

    private void setSpecialItems(){
        specialCategoryList.clear();

        specialCategoryList.add(new Category(1, "Women's Clothing", "//cdn.shopify.com/s/files/1/1407/1106/files/women-all-jackets.jpg?v=1497883280"));
        specialCategoryList.add(new Category(2, "Up to 50% off", "//5.imimg.com/data5/IX/XS/DC/SELLER-89687094/men-s-dresses-500x500.jpg"));
        specialCategoryList.add(new Category(3, "30% cashback", "//media4.s-nbcnews.com/i/newscms/2020_17/3318911/200422-eco-shoes-2x1-al-1218_46b333b80eaf28c9968f1fb244dcca18.jpg"));

        specialCategoryAdapter.notifyDataSetChanged();
    }

}
