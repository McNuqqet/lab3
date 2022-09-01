package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentMap extends Fragment {
    MapData data;

    public FragmentMap(){}
    public FragmentMap(MapData data){this.data = data;}

    private class ViewHolder extends RecyclerView.ViewHolder {
        MapElement element;
        ImageView northWest;
        ImageView northEast;
        ImageView southWest;
        ImageView southEast;
        ImageView structure;

        public ViewHolder(@NonNull View gridCell) {
            super(gridCell);
            northWest = gridCell.findViewById(R.id.grid1);
            northEast = gridCell.findViewById(R.id.grid2);
            southWest = gridCell.findViewById(R.id.grid3);
            southEast = gridCell.findViewById(R.id.grid4);
            structure = gridCell.findViewById(R.id.image);
        }

        public void bind(MapElement mapElement) {
            element = mapElement;

            northWest.setImageResource(R.drawable.ic_building2);//element.getNorthWest());
            northEast.setImageResource(element.getNorthEast());
            southWest.setImageResource(element.getSouthWest());
            southEast.setImageResource(element.getSouthEast());

            if(element.getStructure() != null)
            {
                structure.setImageResource(element.getStructure().getDrawableId());
            }
        }
    }
    public class Adapter extends RecyclerView.Adapter<ViewHolder> {

        MapData data;

        public Adapter(MapData data){
            this.data = data;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.grid_cell, parent,false);
/*
            int size = parent.getMeasuredHeight() / MapData.HEIGHT + 1;
            ViewGroup.LayoutParams lp = view.getLayoutParams();
            lp.width = size;
            lp.height = size;*/

            ViewHolder myViewHolder = new ViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            int row = position % MapData.HEIGHT;
            int col = position / MapData.HEIGHT;
            holder.bind(data.get(row, col));
        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup ui, Bundle bundle)
    {
        View view = inflater.inflate(
                R.layout.fragment_map, ui, false);
        // Set up event handlers
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.mapRecyclerView);

        rv.setLayoutManager(new GridLayoutManager(
                getActivity(),
                MapData.HEIGHT,
                GridLayoutManager.HORIZONTAL,
                false
        ));

        Adapter myAdapter = new Adapter(data);
        rv.setAdapter(myAdapter);
        return view;
    }
}
