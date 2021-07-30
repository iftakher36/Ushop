package com.changetech.ushop.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.changetech.ushop.R;
import com.changetech.ushop.databinding.CategoryDataBinding;
import com.changetech.ushop.databinding.HeaderDataBinding;
import com.changetech.ushop.databinding.ProductDataBinding;
import com.changetech.ushop.ViewModel.Product;
import com.changetech.ushop.viewholder.CategoryHolder;
import com.changetech.ushop.viewholder.HeaderHolder;
import com.changetech.ushop.viewholder.ProductHolder;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList data;
    Activity activity;
    public boolean isLoadingData = false;
    int headerView = 2;
    final int PROGRESSBAR_LAYOUT = -1;

    public void isLoadingData(boolean loadingData) {
        isLoadingData = loadingData;
        notifyDataSetChanged();
    }

    public HomeAdapter(Activity activity, ArrayList data) {
        this.activity = activity;
        this.data = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = null;

        if(viewType == 0){
            view = inflater.inflate(R.layout.holder_home_header, parent, false);
            return new HeaderHolder(view);
        }
        else if(viewType == 1){
            view = inflater.inflate(R.layout.holder_home_category, parent, false);
            return new CategoryHolder(view);
        }
        else if(viewType == PROGRESSBAR_LAYOUT){
            view = inflater.inflate(R.layout.footer_progressbar, parent, false);
            return new RecyclerView.ViewHolder(view){};
        }
        else{
            view = inflater.inflate(R.layout.layout_product, parent, false);
            return new ProductHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
        if(holder instanceof HeaderHolder){
            layoutParams.setFullSpan(true);
            new HeaderDataBinding(activity).bindData((HeaderHolder) holder);
        }
        else if(holder instanceof CategoryHolder){
            layoutParams.setFullSpan(true);
            new CategoryDataBinding(activity).bindData((CategoryHolder) holder);
        }
        else if(holder instanceof ProductHolder){
            Product product = (Product) data.get(position-headerView);
            new ProductDataBinding(activity).bindData((ProductHolder) holder, product);
        }
        else if(position == data.size()+headerView){
            layoutParams.setFullSpan(true);
        }
    }

    @Override
    public int getItemCount() {
        int item = 0;
        if(isLoadingData){
            item = data.size()+headerView+1;
        }
        else{
            item = data.size()+headerView;
        }

        return item;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == data.size()+headerView){
            return PROGRESSBAR_LAYOUT;
        }
        return position;
    }
}




