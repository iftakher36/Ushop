package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.ProfileGiftItem;

import java.util.List;

public class AdapterProfile extends RecyclerView.Adapter<AdapterProfile.ViewHolderGift> {
    Context context;
    List<ProfileGiftItem> profileGiftItemList;

    public AdapterProfile(Context context, List<ProfileGiftItem> profileGiftItemList) {
        this.context = context;
        this.profileGiftItemList = profileGiftItemList;
    }

    @NonNull
    @Override
    public ViewHolderGift onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==2)
        {
            View view=LayoutInflater.from(context).inflate(R.layout.sampleview_profile_gift,parent,false);
            return new ViewHolderGift(view);
        }
        else {
            View view=LayoutInflater.from(context).inflate(R.layout.sampleview_profile,parent,false);
            return new ViewHolderGift(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGift holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {

        if (position==2){
            return 2;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolderGift extends RecyclerView.ViewHolder{

        public ViewHolderGift(@NonNull View itemView) {
            super(itemView);
        }
    }
}
