package com.changetech.ushop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;

import com.changetech.ushop.R;
import com.changetech.ushop.adapter.AdapterPagerProductImage;
import com.changetech.ushop.adapter.AdapterProductColour;
import com.changetech.ushop.adapter.AdapterProductSize;
import com.changetech.ushop.adapter.AdapterSimilarProduct;
import com.changetech.ushop.ViewModel.ModelProductColour;
import com.changetech.ushop.ViewModel.ModelProductDetails;
import com.changetech.ushop.ViewModel.ModelProductSize;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    ViewPager viewPagerProductDetails;
    TabLayout tabLayoutProductDetails;
    AdapterProductSize adapterProductSize;
    AdapterSimilarProduct adapterSimilarProduct;
    AdapterPagerProductImage adapterPagerProductImage;
    AdapterProductColour adapterProductColour;
    RatingBar ratingBar;
    ArrayList<ModelProductColour> modelProductColourArrayList=new ArrayList<>();;
    List<ModelProductDetails> modelProductDetailsList;
    ArrayList<ModelProductSize> modelProductSizeList=new ArrayList<>();
    CheckBox checkBoxFavourite;
    RecyclerView recyclerViewSimilarProduct;
    RecyclerView recyclerViewProductColour;
    RecyclerView recyclerViewProductSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        viewPagerProductDetails=findViewById(R.id.viewpager_product_details);
        tabLayoutProductDetails=findViewById(R.id.tablayout_product_details);
        checkBoxFavourite=findViewById(R.id.checkBox_favourite);
        recyclerViewSimilarProduct=findViewById(R.id.recyclerView_similar_product);
        recyclerViewProductColour=findViewById(R.id.recyclerView_product_colour);
        recyclerViewProductSize=findViewById(R.id.recyclerView_product_size);
        ratingBar=findViewById(R.id.ratingbar_product);
        loadingData();
        loadingColourCodeData();
        loadingProductSizeData();

        //product selected colour
        adapterProductColour=new AdapterProductColour(getApplicationContext(),modelProductColourArrayList);
        recyclerViewProductColour.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false));
        recyclerViewProductColour.setAdapter(adapterProductColour);
        adapterProductColour.setOnItemClickListener(new AdapterProductColour.OnItemClickListener() {
            @Override
            public void itemClick(View view, ModelProductColour modelProductColour, int position) {
                colourSelect(modelProductColour,position);
            }
        });

        //product size
        adapterProductSize=new AdapterProductSize(getApplicationContext(), modelProductSizeList);
        recyclerViewProductSize.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false));
        recyclerViewProductSize.setAdapter(adapterProductSize);

        //similar product
        adapterSimilarProduct=new AdapterSimilarProduct(getApplicationContext(),null);
        recyclerViewSimilarProduct.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false));
        recyclerViewSimilarProduct.setAdapter(adapterSimilarProduct);

        //product image viewpager
        adapterPagerProductImage=new AdapterPagerProductImage(getApplicationContext(),modelProductDetailsList);
        viewPagerProductDetails.setAdapter(adapterPagerProductImage);
        tabLayoutProductDetails.setupWithViewPager(viewPagerProductDetails);

    }
    public void loadingData()
    {
        modelProductDetailsList=new ArrayList<>();
        modelProductDetailsList.add(new ModelProductDetails(R.drawable.demo_five));
        modelProductDetailsList.add(new ModelProductDetails(R.drawable.demo_four));
        modelProductDetailsList.add(new ModelProductDetails(R.drawable.demo_image));
        modelProductDetailsList.add(new ModelProductDetails(R.drawable.demo_image_two));
    }
    public void loadingColourCodeData()
    {

        modelProductColourArrayList.add(new ModelProductColour(R.color.black));
        modelProductColourArrayList.add(new ModelProductColour(R.color.color_gray));
        modelProductColourArrayList.add(new ModelProductColour(R.color.color_orange));
        modelProductColourArrayList.add(new ModelProductColour(R.color.color_red));

    }public void loadingProductSizeData()
    {
        modelProductSizeList.add(new ModelProductSize("S"));
        modelProductSizeList.add(new ModelProductSize("L"));
        modelProductSizeList.add(new ModelProductSize("M"));
        modelProductSizeList.add(new ModelProductSize("XL"));

    }
    private void colourSelect(ModelProductColour item, int p){
        for (int x = 0; x < modelProductColourArrayList.size(); x++) {
            if (x == p) {
                item.setCheck(true);
                continue;
            }
            modelProductColourArrayList.get(x).setCheck(false);
        }
        adapterProductColour.notifyDataSetChanged();
    }
}