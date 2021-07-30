package com.changetech.ushop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.changetech.ushop.R;
import com.changetech.ushop.utils.Tools;

public class CompletedOrderActivity extends AppCompatActivity {

    TextView textViewOrderDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_order);
        textViewOrderDone=findViewById(R.id.textView_order_complete);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        textViewOrderDone.setText("Your Order is completed \n please check your delivery status");
    }
}