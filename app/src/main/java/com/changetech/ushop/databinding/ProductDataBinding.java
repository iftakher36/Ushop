package com.changetech.ushop.databinding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.changetech.ushop.activity.ProductDetailsActivity;
import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.Product;
import com.changetech.ushop.viewholder.ProductHolder;

public class ProductDataBinding {
    Activity activity;
    Bundle bundle;

    public ProductDataBinding(Activity activity) {
        this.activity = activity;
    }
    
    public void bindData(ProductHolder itemView, Product item){
        String img_url = item.getPhoto();

        Glide.with(activity).load(img_url).placeholder(R.drawable.ic_placeholder).into(itemView.img_product_icon);

        itemView.tv_new_price.setText("৳ " + item.getPrice());

        String title = item.getName();
        if (title.length() > 42) {
            title = title.substring(0, 41) + "...";
        }
        itemView.tv_product_title.setText(title);

        if (item.getDiscount() > 0) {
            itemView.tv_old_price.setText("৳ " + item.getPrevious_price());
        } else {
            itemView.tv_old_price.setVisibility(View.GONE);
        }

        itemView.cv_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, ProductDetailsActivity.class);
                activity.startActivity(intent);

            }
        });

    }
}
