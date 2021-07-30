package com.changetech.ushop.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;

public class CategoryHolder extends RecyclerView.ViewHolder {

    public TextView tv_btn_see_more, tv_special_sales;
    public RecyclerView rv_categories, rv_special_sales;

    public CategoryHolder(@NonNull View itemView) {
        super(itemView);

        tv_btn_see_more = itemView.findViewById(R.id.tv_btn_see_more);
        tv_special_sales = itemView.findViewById(R.id.tv_special_sales);
        rv_categories = itemView.findViewById(R.id.rv_categories);
        rv_special_sales = itemView.findViewById(R.id.rv_special_sales);
    }
}