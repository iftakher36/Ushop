package com.changetech.ushop.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.changetech.ushop.R;
import com.changetech.ushop.adapter.AdapterPagerCategories;
import com.changetech.ushop.ViewModel.ModelTabCategories;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CategoriesFragment extends Fragment {

    TabLayout tabLayoutCategories;
    ViewPager viewPagerCategories;
    ArrayList<ModelTabCategories> modelTabCategoriesArrayList=new ArrayList<>();
    AdapterPagerCategories adapterPagerCategories;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayoutCategories=view.findViewById(R.id.tabLayout_category);
        viewPagerCategories=view.findViewById(R.id.viewpager_category);
        loadTabTitle();
        adapterPagerCategories=new AdapterPagerCategories(getChildFragmentManager(),0,modelTabCategoriesArrayList);
        viewPagerCategories.setAdapter(adapterPagerCategories);
        tabLayoutCategories.setupWithViewPager(viewPagerCategories);

    }

    private void loadTabTitle() {
        modelTabCategoriesArrayList.add(new ModelTabCategories("ALL"));
        modelTabCategoriesArrayList.add(new ModelTabCategories("Men's"));
        modelTabCategoriesArrayList.add(new ModelTabCategories("Women"));
        modelTabCategoriesArrayList.add(new ModelTabCategories("Kids"));
        modelTabCategoriesArrayList.add(new ModelTabCategories("Home"));
    }

}