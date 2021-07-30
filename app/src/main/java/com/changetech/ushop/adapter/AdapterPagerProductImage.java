package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.ModelProductDetails;

import java.util.List;

public class AdapterPagerProductImage extends PagerAdapter {
    Context context;
    List<ModelProductDetails> modelProductDetailsList;

    public AdapterPagerProductImage(Context context, List<ModelProductDetails> modelProductDetailsList) {
        this.context = context;
        this.modelProductDetailsList = modelProductDetailsList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.layout_product_details,null);
        ImageView imageView=view.findViewById(R.id.imageView_product_details);
        imageView.setImageResource(modelProductDetailsList.get(position).getProductImage());
        container.addView(view);
        return view;

    }

    @Override
    public int getCount() {
        return modelProductDetailsList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
       return view==object;
    }
}
