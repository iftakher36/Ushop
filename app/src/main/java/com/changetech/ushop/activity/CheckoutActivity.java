package com.changetech.ushop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.changetech.ushop.R;
import com.changetech.ushop.utils.Tools;

public class CheckoutActivity extends AppCompatActivity {

    String[] payementType={"Add Payment Type","Bkash","Rocket"};
    AppCompatSpinner appCompatSpinner;
    LinearLayout linearLayoutAppcompatSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        appCompatSpinner=findViewById(R.id.appCompatSpinner);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        linearLayoutAppcompatSpinner=findViewById(R.id.linearLayout_appcompat_spinner);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(),R.layout.sampleview_spinner_item,payementType);
        arrayAdapter.setDropDownViewResource(R.layout.sampleview_spinner_item);
        appCompatSpinner.setAdapter(arrayAdapter);
        appCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        appCompatSpinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction())
                {
                    case MotionEvent.ACTION_UP:
                        linearLayoutAppcompatSpinner.setBackgroundResource(R.drawable.shape_spinner_deselected);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        linearLayoutAppcompatSpinner.setBackgroundResource(R.drawable.shape_spinner_selected);
                        break;
                }
                return false;
            }
        });

    }
}