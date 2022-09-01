package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class FragmentSelector extends Fragment {
    StructureData data;
    public FragmentSelector() {
        // Required empty public constructor
    }

    public FragmentSelector(StructureData data) {
        this.data = data;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView imageTitle;
        Structure struct;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageTitle = itemView.findViewById(R.id.imageTitle);
            image = itemView.findViewById(R.id.image);
        }

        public void bind(Structure structure) {
            struct = structure;
            image.setImageResource(struct.getDrawableId());
            imageTitle.setText(struct.getLabel());


        }
    }
    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        StructureData data;

        public MyAdapter(StructureData data){
            this.data = data;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.list_selection,parent,false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.bind(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selector, container, false);
        RecyclerView rv = view.findViewById(R.id.selectorRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        MyAdapter myAdapter = new MyAdapter(data);
        rv.setAdapter(myAdapter);
        return view;
    }
}