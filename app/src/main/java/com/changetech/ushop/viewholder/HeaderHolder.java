package com.changetech.ushop.viewholder;

import android.view.View;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.changetech.ushop.R;
import com.google.android.material.tabs.TabLayout;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class HeaderHolder extends RecyclerView.ViewHolder {

    public RecyclerView rv_top_section;
    public ViewPager viewPager_slider;

    public WormDotsIndicator dots_indicator;

    public HeaderHolder(@NonNull View itemView) {
        super(itemView);

        rv_top_section = itemView.findViewById(R.id.rv_top_section);
        viewPager_slider = itemView.findViewById(R.id.viewPager_slider);

        dots_indicator = itemView.findViewById(R.id.dots_indicator);

    }
}