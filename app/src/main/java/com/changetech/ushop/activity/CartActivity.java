package com.changetech.ushop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.changetech.ushop.R;
import com.changetech.ushop.adapter.AdapterCart;
import com.changetech.ushop.utils.Tools;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerViewCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerViewCart=findViewById(R.id.recyclerView_cart);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        AdapterCart adapterCart=new AdapterCart(getApplicationContext(),null);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewCart.setAdapter(adapterCart);

    }
}