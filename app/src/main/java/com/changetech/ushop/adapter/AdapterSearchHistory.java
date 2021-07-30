package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.ModelSearchedData;
import com.changetech.ushop.viewholder.ViewHolderSearchHistory;

import java.util.ArrayList;

public class AdapterSearchHistory extends RecyclerView.Adapter<ViewHolderSearchHistory> {

    Context context;
    ArrayList<ModelSearchedData> arrayListSearchedItem;

    public AdapterSearchHistory(Context context, ArrayList<ModelSearchedData> arrayListSearchedItem) {
        this.context = context;
        this.arrayListSearchedItem = arrayListSearchedItem;
    }

    @NonNull
    @Override
    public ViewHolderSearchHistory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sampleview_search_history,parent,false);
       return new ViewHolderSearchHistory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSearchHistory holder, int position) {
        ModelSearchedData modelSearchedData=arrayListSearchedItem.get(position);
        holder.textViewSearched.setText(modelSearchedData.getSearchedData());
    }
    @Override
    public int getItemCount() {
        return arrayListSearchedItem.size();
    }
}
