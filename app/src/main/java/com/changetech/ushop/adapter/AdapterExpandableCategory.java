package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.ModelViewpagerCategory;
import com.changetech.ushop.viewholder.ViewPagerCategoryHolder;
import java.util.ArrayList;

public class AdapterExpandableCategory extends RecyclerView.Adapter<ViewPagerCategoryHolder> {

    Context context;
    ArrayList<ModelViewpagerCategory> modelViewpagerCategoryArrayList;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void itemClick(View view, ModelViewpagerCategory modelViewpagerCategory, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AdapterExpandableCategory(Context context, ArrayList<ModelViewpagerCategory> modelViewpagerCategoryArrayList) {
        this.context = context;
        this.modelViewpagerCategoryArrayList = modelViewpagerCategoryArrayList;
    }

    @NonNull
    @Override
    public ViewPagerCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sampleview_categories,parent,false);
        return new ViewPagerCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerCategoryHolder holder, int position) {
        holder.setData(onItemClickListener,modelViewpagerCategoryArrayList.get(position),position,context);
    }

    @Override
    public int getItemCount() {
        return modelViewpagerCategoryArrayList.size();
    }
}
