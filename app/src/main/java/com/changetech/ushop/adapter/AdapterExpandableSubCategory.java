package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.ModelViewpagerSubcategory;
import com.changetech.ushop.viewholder.ViewPagerSubCategoryHolder;

import java.util.List;

public class AdapterExpandableSubCategory extends RecyclerView.Adapter<ViewPagerSubCategoryHolder> {
    Context context;
    List<ModelViewpagerSubcategory> modelViewpagerSubcategoryArrayList;

    public AdapterExpandableSubCategory(Context context, List<ModelViewpagerSubcategory> modelViewpagerSubcategoryArrayList) {
        this.context = context;
        this.modelViewpagerSubcategoryArrayList = modelViewpagerSubcategoryArrayList;
    }

    @NonNull
    @Override
    public ViewPagerSubCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sampleview_subcategories,parent,false);
        return new ViewPagerSubCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerSubCategoryHolder holder, int position) {
        ModelViewpagerSubcategory modelViewpagerSubcategory=modelViewpagerSubcategoryArrayList.get(position);
        holder.circularImageViewProduct.setImageResource(modelViewpagerSubcategory.getImage());
        holder.textViewTitle.setText(modelViewpagerSubcategory.getTitle());
    }

    @Override
    public int getItemCount() {
        return modelViewpagerSubcategoryArrayList.size();
    }
}
