package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentMap extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup ui, Bundle bundle)
    {
        View view = inflater.inflate(
                R.layout.fragment_map, ui, false);
        // Set up event handlers
        RecyclerView recycView = (RecyclerView) view.findViewById(R.id.mapRecyclerView);

        recycView.setLayoutManager(new GridLayoutManager(
                getActivity(),
                MapData.HEIGHT,
                GridLayoutManager.HORIZONTAL,
                false
        ));


        return view;
    }
}
