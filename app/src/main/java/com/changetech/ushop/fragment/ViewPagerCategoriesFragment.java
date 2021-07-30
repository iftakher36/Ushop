package com.changetech.ushop.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.changetech.ushop.R;
import com.changetech.ushop.adapter.AdapterExpandableCategory;
import com.changetech.ushop.ViewModel.ModelViewpagerCategory;
import com.changetech.ushop.ViewModel.ModelViewpagerSubcategory;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerCategoriesFragment extends Fragment {

    RecyclerView recyclerViewCategory;
    ArrayList<ModelViewpagerCategory> modelViewpagerCategoryArrayList = new ArrayList<>();
    AdapterExpandableCategory adapterExpandableCategory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewCategory = view.findViewById(R.id.recyclerView_expandable);
        loadingDAta();
        adapterExpandableCategory = new AdapterExpandableCategory(getActivity(), modelViewpagerCategoryArrayList);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewCategory.setAdapter(adapterExpandableCategory);
        adapterExpandableCategory.setOnItemClickListener(new AdapterExpandableCategory.OnItemClickListener() {
            @Override
            public void itemClick(View view, ModelViewpagerCategory modelViewpagerCategory, int position) {
                setExpandCollaps(modelViewpagerCategory, position);
            }
        });
    }

    private void setExpandCollaps(ModelViewpagerCategory item, int position) {
        for (int x = 0; x < modelViewpagerCategoryArrayList.size(); x++) {
            if (x == position) {
                if (item.getExpand()) {
                    item.setExpand(false);
                } else {
                    item.setExpand(true);
                }
                continue;
            }
            modelViewpagerCategoryArrayList.get(x).setExpand(false);
        }
        adapterExpandableCategory.notifyDataSetChanged();
    }

    private void loadingDAta() {
        modelViewpagerCategoryArrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<ModelViewpagerSubcategory> modelViewpagerSubcategoryArrayList = new ArrayList<>(3);
            modelViewpagerSubcategoryArrayList.add(new ModelViewpagerSubcategory(R.drawable.demo_four, "bag"));
            modelViewpagerSubcategoryArrayList.add(new ModelViewpagerSubcategory(R.drawable.demo_four, "bag"));
            modelViewpagerSubcategoryArrayList.add(new ModelViewpagerSubcategory(R.drawable.demo_four, "bag"));
            modelViewpagerSubcategoryArrayList.add(new ModelViewpagerSubcategory(R.drawable.demo_four, "bag"));
            modelViewpagerSubcategoryArrayList.add(new ModelViewpagerSubcategory(R.drawable.demo_four, "bag"));
            modelViewpagerSubcategoryArrayList.add(new ModelViewpagerSubcategory(R.drawable.demo_four, "bag"));
            modelViewpagerSubcategoryArrayList.add(new ModelViewpagerSubcategory(R.drawable.demo_four, "bag"));
            modelViewpagerCategoryArrayList.add(new ModelViewpagerCategory(R.drawable.demo_four, "Shoes" + i, modelViewpagerSubcategoryArrayList));
        }

    }

}