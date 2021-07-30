package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.ScreenItem;

import java.util.List;

public class AdapterPagerIntro extends PagerAdapter {
    Context context;
    List<ScreenItem> screenItemList;

    public AdapterPagerIntro(Context context, List<ScreenItem> screenItemList) {
        this.context = context;
        this.screenItemList = screenItemList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.layout_intro_screen,null);
        ImageView imageView=view.findViewById(R.id.imageView_Intro);
        TextView textViewTitle=view.findViewById(R.id.textView_title);
        TextView textViewDescription=view.findViewById(R.id.textView_description);
        imageView.setImageResource(screenItemList.get(position).getImage());
        textViewTitle.setText(screenItemList.get(position).getTitle());
        textViewDescription.setText(screenItemList.get(position).getDescription());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return screenItemList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
