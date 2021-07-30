package com.changetech.ushop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.changetech.ushop.R;
import com.changetech.ushop.adapter.AdapterSearchHistory;
import com.changetech.ushop.adapter.AdapterSearchedProduct;
import com.changetech.ushop.ViewModel.ModelSearchedData;
import com.changetech.ushop.utils.Tools;
import com.xiaofeng.flowlayoutmanager.FlowLayoutManager;

import java.util.ArrayList;

public class UshopSearchActivity extends AppCompatActivity {

    RecyclerView recyclerViewSearchedHistory,recyclerViewSearchedProduct;
    AdapterSearchHistory adapterSearchHistory;
    AdapterSearchedProduct adapterSearchedProduct;
    ArrayList arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ushop_search);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        recyclerViewSearchedHistory=findViewById(R.id.recyclerView_searched_history);
        recyclerViewSearchedProduct=findViewById(R.id.recyclerView_searched_product);
        getHistoryData();
        adapterSearchHistory=new AdapterSearchHistory(getApplicationContext(),arrayList);
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        flowLayoutManager.setAutoMeasureEnabled(true);
        recyclerViewSearchedHistory.setLayoutManager(flowLayoutManager);
        recyclerViewSearchedHistory.setAdapter(adapterSearchHistory);
        //
        adapterSearchedProduct=new AdapterSearchedProduct(getApplicationContext());
        recyclerViewSearchedProduct.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewSearchedProduct.setAdapter(adapterSearchedProduct);
    }

    private void getHistoryData() {
        arrayList=new ArrayList();
        arrayList.add(new ModelSearchedData("Sony headset"));
        arrayList.add(new ModelSearchedData("Shoes"));
        arrayList.add(new ModelSearchedData("Air max shoes"));
        arrayList.add(new ModelSearchedData("Sony headset"));
        arrayList.add(new ModelSearchedData("Sony headset"));
        arrayList.add(new ModelSearchedData("Shoes"));
        arrayList.add(new ModelSearchedData("Air max shoes"));
        arrayList.add(new ModelSearchedData("Sony headset"));
    }
}