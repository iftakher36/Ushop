package com.changetech.ushop.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.changetech.ushop.fragment.ViewPagerCategoriesFragment;
import com.changetech.ushop.ViewModel.ModelTabCategories;

import java.util.ArrayList;

public class AdapterPagerCategories extends FragmentStatePagerAdapter {

    ArrayList<ModelTabCategories> modelTabCategoriesArrayList;

    public AdapterPagerCategories(@NonNull FragmentManager fm, int behavior,ArrayList<ModelTabCategories> modelTabCategories) {
        super(fm, behavior);
        this.modelTabCategoriesArrayList=modelTabCategories;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return new ViewPagerCategoriesFragment();
    }

    @Override
    public int getCount() {
        return modelTabCategoriesArrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return modelTabCategoriesArrayList.get(position).getTabTitle();
    }
}
