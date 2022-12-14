package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class FragmentMap extends Fragment {
    MapData data;
    MyViewModel viewModel;
    private int mCounter;

    public FragmentMap() {
        // Required empty public
    }

    public FragmentMap(MapData data, MyViewModel viewModel) {
        this.data = data;
        this.viewModel = viewModel;
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

        public void bind(MapElement mapElement) {
            element = mapElement;
            northWest.setImageResource(element.getNorthWest());
            northEast.setImageResource(element.getNorthEast());
            southWest.setImageResource(element.getSouthWest());
            southEast.setImageResource(element.getSouthEast());

            if(element.getStructure() != null)
            {
                structure.setImageResource(element.getStructure().getDrawableId());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        Structure viewData = viewModel.getData().getValue();
                        if(element.isBuildable() && (element.getStructure() == null ||
                                (viewData.getDrawableId() != element.getStructure().getDrawableId()))) {

                            element.setStructure(viewData);
                            structure.setImageResource(element.getStructure().getDrawableId());
                            System.out.println(element.getStructure().getDrawableId());
                            getBindingAdapter().notifyItemChanged(getBindingAdapterPosition());
                        }
                        else if(element.isBuildable()){
                            element.setStructure(null);
                            structure.setImageResource(0);
                        }
                    }
                    catch(Exception e){
                        System.out.println("Invalid data");
                    }
                    itemView.setOnClickListener(null);
                }
            });
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
            int size = parent.getMeasuredHeight() / MapData.HEIGHT;
            ViewGroup.LayoutParams lp = view.getLayoutParams();
            lp.width = size - size % 2 + 2;
            lp.height = size - size % 2 + 2;

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
        View view = null;
        // Inflate the layout for this fragment
        if (savedInstanceState == null)
        {
            view = inflater.inflate(R.layout.fragment_map, container, false);
            RecyclerView rv = view.findViewById(R.id.mapRecyclerView);
            rv.setLayoutManager(new GridLayoutManager(getActivity(),
                    MapData.HEIGHT,
                    GridLayoutManager.HORIZONTAL,
                    false));

            MyAdapter myAdapter = new MyAdapter(data);
            rv.setAdapter(myAdapter);
        }
        else{
            mCounter = savedInstanceState.getInt("counter", 0);
        }
/*
        final Observer<Integer> obs = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                drawableID = integer.intValue();
            }
        };*/

        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Make sure to call the super method so that the states of our views are saved
        super.onSaveInstanceState(outState);
        outState.putInt("counter", mCounter);
    }
}

