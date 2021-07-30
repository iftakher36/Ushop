package com.changetech.ushop.viewholder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;

public class ViewHolderProductSize extends RecyclerView.ViewHolder {
    public TextView textViewSize;
    public RelativeLayout layoutProduct;

    public ViewHolderProductSize(@NonNull View itemView) {
        super(itemView);
        textViewSize = itemView.findViewById(R.id.textView_size);
        layoutProduct = itemView.findViewById(R.id.layout_product);

    }
}
