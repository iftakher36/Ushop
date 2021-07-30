package com.changetech.ushop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.changetech.ushop.R;
import com.changetech.ushop.ViewModel.Category;

import java.util.ArrayList;

public class HomeCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    ArrayList data;
    Context context;

    public HomeCategoryAdapter(Context context, ArrayList data){
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_home_category, parent, false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass itemView = (ViewHolderClass) holder;
        Category category = (Category) data.get(position);

        itemView.tv_title.setText(category.getName());
        Glide.with(context).load(category.getPhoto()).placeholder(R.drawable.ic_placeholder).into(itemView.img_icon);


        itemView.cv_home_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolderClass extends RecyclerView.ViewHolder{

        TextView tv_title;
        ImageView img_icon;
        CardView cv_home_category;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            img_icon = itemView.findViewById(R.id.img_icon);
            cv_home_category = itemView.findViewById(R.id.cv_home_category);
        }
    }

}
