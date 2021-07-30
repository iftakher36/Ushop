package com.changetech.ushop.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;

public class ViewHolderDrawer extends RecyclerView.ViewHolder{

    public TextView textViewItem;
    public ImageView imageViewItem;
    public ViewHolderDrawer(@NonNull View itemView) {
        super(itemView);
        textViewItem=itemView.findViewById(R.id.textView_drawer);
        imageViewItem=itemView.findViewById(R.id.imageView_drawer);

    }
}