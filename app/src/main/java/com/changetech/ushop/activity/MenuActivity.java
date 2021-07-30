package com.changetech.ushop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.changetech.ushop.admin.AdminPanelActivity;
import com.changetech.ushop.R;
import com.changetech.ushop.activity.auth.SignInActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.cardView_admin)
    CardView cardViewAdmin;
    @BindView(R.id.cardView_store)
    CardView cardViewStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        cardViewStore.setOnClickListener(this);
        cardViewAdmin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (cardViewAdmin==v)
        {
            intent=new Intent(getApplicationContext(), AdminPanelActivity.class);
            startActivity(intent);
        }
        else if (cardViewStore==v)
        {
             intent=new Intent(getApplicationContext(), SignInActivity.class);
             startActivity(intent);
        }

    }
}