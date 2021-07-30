package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;

import com.changetech.ushop.ViewModel.ModelProductColour;
import com.changetech.ushop.viewholder.ViewHolderProductColour;

import java.util.ArrayList;

public class AdapterProductColour extends RecyclerView.Adapter<ViewHolderProductColour> {
    Context context;
    ArrayList<ModelProductColour> modelProductColourArrayList;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void itemClick(View view,ModelProductColour modelProductColour,int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AdapterProductColour(Context context, ArrayList<ModelProductColour> modelProductColourArrayList) {
        this.context = context;
        this.modelProductColourArrayList = modelProductColourArrayList;
    }

    @NonNull
    @Override
    public ViewHolderProductColour onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sampleview_product_details_colour, parent, false);
        return new ViewHolderProductColour(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductColour holder, int position) {
    holder.setData(onItemClickListener,modelProductColourArrayList.get(position),position,context);
    }

    @Override
    public int getItemCount() {
        return modelProductColourArrayList.size();
    }

}
