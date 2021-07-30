package com.changetech.ushop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.changetech.ushop.R;

public class HomeSectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    String[] data;
    Integer[] icon;
    Context context;

    public HomeSectionAdapter(Context context, String[] data, Integer[] icon){
        this.context = context;
        this.data = data;
        this.icon = icon;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_home_top_section, parent, false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass itemView = (ViewHolderClass) holder;

        itemView.tv_section_title.setText(data[position]);
        Glide.with(context).load(icon[position]).placeholder(R.drawable.ic_placeholder).into(itemView.img_section_icon);

        itemView.ll_home_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    default:
                        Toast.makeText(context, "Coming Soon", Toast.LENGTH_SHORT).show();
                        break;
//                    case 0:
//                        context.startActivity(new Intent(context, GroceryHomeActivity.class));
//                        break;
//                    case 1:
//                        context.startActivity(new Intent(context, MedicineHomeActivity.class));
//                        break;
//                    case 2:
//                        context.startActivity(new Intent(context, StoreCategoryActivity.class));
//                        break;
//                    case 3:
//                        context.startActivity(new Intent(context, FlashSellItemListActivity.class));
//                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    public class ViewHolderClass extends RecyclerView.ViewHolder{

        TextView tv_section_title;
        ImageView img_section_icon;
        LinearLayout ll_home_section;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            tv_section_title = itemView.findViewById(R.id.tv_section_title);
            img_section_icon = itemView.findViewById(R.id.img_section_icon);
            ll_home_section = itemView.findViewById(R.id.ll_home_section);

        }
    }

}
