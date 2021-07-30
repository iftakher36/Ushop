package com.changetech.ushop.viewholder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.adapter.AdapterProductColour;
import com.changetech.ushop.ViewModel.ModelProductColour;

public class ViewHolderProductColour extends RecyclerView.ViewHolder {
    ImageView imageView,background;
    RelativeLayout relativeLayout;

    public ViewHolderProductColour(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView_selected);
        relativeLayout = itemView.findViewById(R.id.layout);
        background=itemView.findViewById(R.id.background);


    }

    public void setData(AdapterProductColour.OnItemClickListener onItemClickListener, ModelProductColour item, int position, Context context) {
        imageView.setVisibility(View.INVISIBLE);
        int color=item.getColor();
        Log.e("color",""+color);
        background.setColorFilter(ContextCompat.getColor(context, color), android.graphics.PorterDuff.Mode.SRC_IN);
        relativeLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.itemClick(v, item, position);

                }

            }
        });

        if (item.getCheck()) {
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.INVISIBLE);
        }

    }
}
