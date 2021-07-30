package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.ModelProductSize;
import com.changetech.ushop.viewholder.ViewHolderProductSize;

import java.util.ArrayList;

public class AdapterProductSize extends RecyclerView.Adapter<ViewHolderProductSize> {
    Context context;
    ArrayList<ModelProductSize> modelProductSizeArrayList;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void itemClick(View view,ModelProductSize modelProductSize,int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AdapterProductSize(Context context, ArrayList<ModelProductSize> modelProductSizeArrayList) {
        this.context = context;
        this.modelProductSizeArrayList = modelProductSizeArrayList;
    }

    @NonNull
    @Override
    public ViewHolderProductSize onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.sampleview_product_details_size,parent,false);
        return new ViewHolderProductSize(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductSize holder, int position) {
    holder.textViewSize.setText(modelProductSizeArrayList.get(position).getSize());
    }

    @Override
    public int getItemCount() {
        return modelProductSizeArrayList.size();
    }

}
