package com.changetech.ushop.viewholder;

import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;

public class ProductHolder extends RecyclerView.ViewHolder {
    public TextView tv_product_title, tv_old_price, tv_new_price;
    public ImageView img_product_icon;
    public CardView cv_product;

    public ProductHolder(@NonNull View itemView) {
        super(itemView);

        cv_product = itemView.findViewById(R.id.cv_product);
        tv_product_title = itemView.findViewById(R.id.tv_product_title);
        tv_old_price = itemView.findViewById(R.id.tv_old_price);
        tv_new_price = itemView.findViewById(R.id.tv_new_price);
        img_product_icon = itemView.findViewById(R.id.img_product_icon);

        tv_old_price.setPaintFlags(tv_old_price.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
    }
}