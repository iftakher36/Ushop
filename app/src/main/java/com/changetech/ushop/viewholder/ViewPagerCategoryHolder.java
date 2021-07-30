package com.changetech.ushop.viewholder;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.changetech.ushop.R;
import com.changetech.ushop.adapter.AdapterExpandableCategory;
import com.changetech.ushop.adapter.AdapterExpandableSubCategory;
import com.changetech.ushop.ViewModel.ModelViewpagerCategory;
import com.changetech.ushop.ViewModel.ModelViewpagerSubcategory;

import java.util.List;

public class ViewPagerCategoryHolder extends RecyclerView.ViewHolder {
    AdapterExpandableSubCategory adapterExpandableSubCategory;
    ConstraintLayout layout;
    ImageView imageViewProduct,imageViewRightArrow;
    TextView textViewTitle;
    RecyclerView recyclerView;

    public ViewPagerCategoryHolder(View itemView) {
        super(itemView);
        imageViewRightArrow=itemView.findViewById(R.id.imageView_categorie);
        imageViewProduct=itemView.findViewById(R.id.imageView_product);
        textViewTitle=itemView.findViewById(R.id.textView_categorie_title);
        recyclerView=itemView.findViewById(R.id.recyclerView_sub_category);
        layout=itemView.findViewById(R.id.layout_category);


    }

    public void setData(AdapterExpandableCategory.OnItemClickListener onItemClickListener, ModelViewpagerCategory modelViewpagerCategory, int position, Context context) {
        adapterExpandableSubCategory=new AdapterExpandableSubCategory(context, (List<ModelViewpagerSubcategory>) modelViewpagerCategory.getModelViewpagerSubcategories());
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(adapterExpandableSubCategory);
        recyclerView.setVisibility(View.GONE);
        imageViewProduct.setImageResource(modelViewpagerCategory.getImage());
        textViewTitle.setText(modelViewpagerCategory.getTitle());
        if (modelViewpagerCategory.getExpand())
        {
            recyclerView.setVisibility(View.VISIBLE);
            animationExpand();
        }
        else {
            recyclerView.setVisibility(View.GONE);
        }

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null)
                {
                    onItemClickListener.itemClick(v,modelViewpagerCategory,position);

                }
            }
        });

    }

    private void animationExpand() {
        RotateAnimation rotateAnimation=new RotateAnimation(0,90, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        imageViewRightArrow.setAnimation(rotateAnimation);
    }


    public void animationCollapse() {
        RotateAnimation rotateAnimation=new RotateAnimation(90,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        imageViewRightArrow.setAnimation(rotateAnimation);
    }
}
