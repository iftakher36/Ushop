package com.changetech.ushop.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.changetech.ushop.R;
import com.changetech.ushop.activity.UshopSearchActivity;
import com.changetech.ushop.adapter.HomeAdapter;
import com.changetech.ushop.ViewModel.Product;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView rv_content;
    HomeAdapter homeAdapter;
    CardView cardViewSearchBar;
    ArrayList data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initComponents(view);
        setProducts();
    }

    private void initComponents(View view){
        rv_content = view.findViewById(R.id.rv_content);
        cardViewSearchBar=view.findViewById(R.id.cv_search_bar);

        data = new ArrayList();
        homeAdapter = new HomeAdapter(getActivity(), data);
        rv_content.setAdapter(homeAdapter);
        rv_content.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        cardViewSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), UshopSearchActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    private void setProducts(){
        data.clear();

        data.add(new Product(1, "Apple 1 kg (Fresh)", "//i2.wp.com/ceklog.kindel.com/wp-content/uploads/2013/02/firefox_2018-07-10_07-50-11.png", 150, 155));
        data.add(new Product(2, "Orange 1 kg", "//images.pexels.com/photos/42059/citrus-diet-food-fresh-42059.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500", 120, 130));
        data.add(new Product(3, "Jackfruit", "//img1.mashed.com/img/gallery/the-untold-truth-of-jackfruit/intro-1591724284.jpg", 60, 0));
        data.add(new Product(4, "Guava 12 pcs", "//www.gardeningknowhow.com/wp-content/uploads/2017/10/guava-fruit.jpg", 100, 130));

        homeAdapter.notifyDataSetChanged();
    }
}