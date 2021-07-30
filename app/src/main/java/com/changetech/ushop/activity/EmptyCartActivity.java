package com.changetech.ushop.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.changetech.ushop.R;
import com.changetech.ushop.utils.Tools;

public class EmptyCartActivity extends AppCompatActivity {

    TextView textViewEmptyDefinition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_cart);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        textViewEmptyDefinition=findViewById(R.id.textView_empty_definition);
        textViewEmptyDefinition.setText("There is nothing in your cart.\n Let's add some items");
    }
}