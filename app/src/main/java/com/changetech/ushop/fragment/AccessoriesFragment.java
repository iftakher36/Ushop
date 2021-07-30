package com.changetech.ushop.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.changetech.ushop.R;
import com.changetech.ushop.adapter.AdapterAccessories;

public class AccessoriesFragment extends Fragment {

    RecyclerView recyclerViewAccessories;
    AdapterAccessories adapterAccessories;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accessories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewAccessories=view.findViewById(R.id.recyclerView_accessories);
        adapterAccessories=new AdapterAccessories(getActivity());
        recyclerViewAccessories.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerViewAccessories.setAdapter(adapterAccessories);

    }
}