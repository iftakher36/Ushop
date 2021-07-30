package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.ModelDrawerItem;
import com.changetech.ushop.viewholder.ViewHolderDrawer;

import java.util.ArrayList;

public class AdapterDrawer extends RecyclerView.Adapter<ViewHolderDrawer> {

    Context context;
    ArrayList<ModelDrawerItem> modelDrawerItems;

    public AdapterDrawer(Context context, ArrayList arrayList) {
        this.context = context;
        this.modelDrawerItems= arrayList;
    }

    @NonNull
    @Override
    public ViewHolderDrawer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sampleview_drawerlist,parent,false);
        return new ViewHolderDrawer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDrawer holder, int position) {
        ModelDrawerItem modelDrawerItem=modelDrawerItems.get(position);
    holder.imageViewItem.setImageResource(modelDrawerItem.getImage());
    holder.textViewItem.setText(modelDrawerItem.getDrawerItem());
    }

    @Override
    public int getItemCount() {
        return modelDrawerItems.size();
    }


}
