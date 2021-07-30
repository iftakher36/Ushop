package com.changetech.ushop.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;

public class ViewHolderSearchHistory extends RecyclerView.ViewHolder {
    public TextView textViewSearched;
    public ViewHolderSearchHistory(@NonNull View itemView) {
        super(itemView);
        textViewSearched=itemView.findViewById(R.id.textView_searched);
    }
}
