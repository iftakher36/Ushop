package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.ModelSimiliarProduct;
import com.changetech.ushop.viewholder.ViewHolderSimilarProduct;

import java.util.ArrayList;

public class AdapterSimilarProduct extends RecyclerView.Adapter<ViewHolderSimilarProduct> {
    Context context;
    ArrayList<ModelSimiliarProduct> modelSimiliarProducts;

    public AdapterSimilarProduct(Context context, ArrayList<ModelSimiliarProduct> modelSimiliarProducts) {
        this.context = context;
        this.modelSimiliarProducts = modelSimiliarProducts;
    }

    @NonNull
    @Override
    public ViewHolderSimilarProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sampleview_product_details_similarproduct,parent,false);
        return new ViewHolderSimilarProduct(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSimilarProduct holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
