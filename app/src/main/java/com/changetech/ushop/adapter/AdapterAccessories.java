package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.viewholder.ViewHolderAccessories;

public class AdapterAccessories extends RecyclerView.Adapter<ViewHolderAccessories> {
    Context context;

    public AdapterAccessories(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAccessories onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sampleview_accessories,parent,false);
        return new ViewHolderAccessories(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAccessories holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
