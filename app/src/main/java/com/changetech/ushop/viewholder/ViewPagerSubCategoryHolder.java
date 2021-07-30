package com.changetech.ushop.viewholder;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class ViewPagerSubCategoryHolder extends RecyclerView.ViewHolder {
    public CircularImageView circularImageViewProduct;
    public TextView textViewTitle;

    public ViewPagerSubCategoryHolder(View itemView) {
        super(itemView);
        circularImageViewProduct=itemView.findViewById(R.id.circularImageView_sub_category);
        textViewTitle=itemView.findViewById(R.id.textView_subcategories);

    }
}
