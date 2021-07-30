package com.changetech.ushop.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.changetech.ushop.R;
import com.changetech.ushop.adapter.AdapterDrawer;
import com.changetech.ushop.fragment.CategoriesFragment;
import com.changetech.ushop.fragment.HomeFragment;
import com.changetech.ushop.fragment.ProfileFragment;
import com.changetech.ushop.ViewModel.ModelDrawerItem;
import com.changetech.ushop.utils.Tools;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerViewDrawerItem;
    AdapterDrawer adapterDrawer;
    ArrayList<ModelDrawerItem> modelDrawerItemArrayList;
    Fragment activeFragment, homeFragment;
    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
        drawerListData();
        recyclerViewDrawerItem = findViewById(R.id.recyclerView_drawer_item);
        adapterDrawer = new AdapterDrawer(getApplicationContext(), modelDrawerItemArrayList);
        recyclerViewDrawerItem.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewDrawerItem.setAdapter(adapterDrawer);
        ButterKnife.bind(this);
        initComponents();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }
    private void initComponents() {
        homeFragment = new HomeFragment();
        fragmentTransaction(homeFragment);
    }

    private void fragmentTransaction(Fragment fragment) {
        String Tag = fragment.getClass().getName();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, Tag).addToBackStack(Tag).show(fragment).commit();
    }


    public void drawerListData() {
        modelDrawerItemArrayList = new ArrayList<>();
        modelDrawerItemArrayList.add(new ModelDrawerItem(R.drawable.ic_home, getString(R.string.home)));
        modelDrawerItemArrayList.add(new ModelDrawerItem(R.drawable.ic_notification, getString(R.string.notify)));
        modelDrawerItemArrayList.add(new ModelDrawerItem(R.drawable.ic_category, getString(R.string.categories)));
        modelDrawerItemArrayList.add(new ModelDrawerItem(R.drawable.ic_setting, getString(R.string.setting)));
        modelDrawerItemArrayList.add(new ModelDrawerItem(R.drawable.ic_question, getString(R.string.help)));
        modelDrawerItemArrayList.add(new ModelDrawerItem(R.drawable.ic_contact_us, getString(R.string.contact)));
        modelDrawerItemArrayList.add(new ModelDrawerItem(R.drawable.ic_world, getString(R.string.language)));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.bottom_nav_menu_home) {
            fragmentTransaction(new HomeFragment());
            return true;
        } else if (item.getItemId() == R.id.bottom_nav_menu_order) {

        } else if (item.getItemId() == R.id.bottom_nav_menu_category) {
            fragmentTransaction(new CategoriesFragment());
        } else if (item.getItemId() == R.id.bottom_nav_menu_more) {
            fragmentTransaction(new ProfileFragment());
            return true;
        }
        return false;
    }
}