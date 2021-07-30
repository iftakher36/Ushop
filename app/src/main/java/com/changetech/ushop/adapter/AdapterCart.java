package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.ModelCart;
import com.changetech.ushop.viewholder.ViewHolderCart;

import java.util.ArrayList;

public class AdapterCart extends RecyclerView.Adapter<ViewHolderCart> {

    Context context;
    ArrayList<ModelCart> modelCarts;

    public AdapterCart(Context context, ArrayList<ModelCart> modelCarts) {
        this.context = context;
        this.modelCarts = modelCarts;
    }

    @NonNull
    @Override
    public ViewHolderCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sampleview_cart,parent,false);
        return new ViewHolderCart(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCart holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
