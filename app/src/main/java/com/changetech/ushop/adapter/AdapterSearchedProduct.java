package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.viewholder.ViewHolderSearchedProduct;

public class AdapterSearchedProduct extends RecyclerView.Adapter<ViewHolderSearchedProduct> {
    Context context;
    public AdapterSearchedProduct(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderSearchedProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sampleview_searched_product,parent,false);
        return new ViewHolderSearchedProduct(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSearchedProduct holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
