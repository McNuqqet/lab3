package com.example.myapplication;
/*
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annoation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentMap1 extends Fragment {
    MapData data = MapData.get();

    public FragmentMap(){
        System.out.println("0"); //runs
    }
    //public FragmentMap(MapData data){this.data = data;}

    public class MyViewHolder extends RecyclerView.ViewHolder {
        MapElement element;
        ImageView northWest;
        ImageView northEast;
        ImageView southWest;
        ImageView southEast;
        ImageView structure;

        public MyViewHolder(@NonNull View gridCell) {
            super(gridCell);
            System.out.println("1");
            northWest = gridCell.findViewById(R.id.grid1);
            northEast = gridCell.findViewById(R.id.grid2);
            southWest = gridCell.findViewById(R.id.grid3);
            southEast = gridCell.findViewById(R.id.grid4);
            structure = gridCell.findViewById(R.id.image);
        }

        public void bind(MapElement mapElement) {
            element = mapElement;

            System.out.println("2");
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
    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        MapData data;

        public MyAdapter(MapData data){
            this.data = data;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.grid_cell, parent,false);

            System.out.println("3");
            int size = parent.getMeasuredHeight() / MapData.HEIGHT + 1;
            ViewGroup.LayoutParams lp = view.getLayoutParams();
            lp.width = size;
            lp.height = size;

            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            int row = position % MapData.HEIGHT;
            int col = position / MapData.HEIGHT;
            holder.bind(data.get(row, col));
            System.out.println("4");
        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup ui, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.fragment_map, ui, false);
        // Set up event handlers
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.mapRecyclerView);

        rv.setLayoutManager(new GridLayoutManager(
                getActivity(),
                MapData.HEIGHT,
                GridLayoutManager.HORIZONTAL,
                false
        ));

        MyAdapter myAdapter = new MyAdapter(data);
        rv.setAdapter(myAdapter);
        System.out.println("5"); //runs
        return view;
    }
}
*/