package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class FragmentMap extends Fragment {
    MapData data;
    public FragmentMap() {
        // Required empty public constructor
    }

    public FragmentMap(MapData data) {
        this.data = data;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        MapElement element;
        ImageView northWest;
        ImageView northEast;
        ImageView southWest;
        ImageView southEast;
        ImageView structure;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            northWest = itemView.findViewById(R.id.northWest);
            northEast = itemView.findViewById(R.id.northEast);
            southWest = itemView.findViewById(R.id.southWest);
            southEast = itemView.findViewById(R.id.southEast);
            structure = itemView.findViewById(R.id.landmark);
        }

        public void bind(MapElement mapElement) {element = mapElement;

            northWest.setImageResource(element.getNorthWest());
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
            View view = layoutInflater.inflate(R.layout.grid_cell,parent,false);
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
        }

        @Override
        public int getItemCount() {
            return MapData.HEIGHT * MapData.WIDTH;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        RecyclerView rv = view.findViewById(R.id.mapRecyclerView);
        rv.setLayoutManager(new GridLayoutManager(getActivity(),
                MapData.HEIGHT,
                GridLayoutManager.HORIZONTAL,
                false));
        MyAdapter myAdapter = new MyAdapter(data);
        rv.setAdapter(myAdapter);
        return view;
    }
}

