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
import com.changetech.ushop.adapter.AdapterProfile;

public class ProfileFragment extends Fragment {

    RecyclerView recyclerViewGiftItem;
    AdapterProfile adapterProfile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewGiftItem=view.findViewById(R.id.recyclerview_gift_item);
        adapterProfile=new AdapterProfile(getActivity(),null);
        recyclerViewGiftItem.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        recyclerViewGiftItem.setAdapter(adapterProfile);
    }
}