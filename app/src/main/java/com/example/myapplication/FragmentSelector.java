package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class FragmentSelector extends Fragment {
    StructureData data;
    Structure selected = null;
    //ImageView curImg = null;

    public FragmentSelector() {
        // Required empty public constructor
    }

    public FragmentSelector(StructureData data) {
        this.data = data;
    }

    public Structure getSelected(){return this.selected;}
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView imageTitle = null;
        ImageView image = null;
        Structure struct = null;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageTitle = itemView.findViewById(R.id.imageTitle);
            image = itemView.findViewById(R.id.image);
        }

        public TextView getImageTitle(){return imageTitle;}
        public ImageView getImage(){return image;}
        public Structure getStruct(){return struct;}

        public void setImageTitle(TextView text){imageTitle = text;}
        public void setImage(ImageView img){image = img;}
        public void setStruct(Structure st){struct = st;}

        public void bind(Structure structure) {
            image.setImageResource(structure.getDrawableId());
            imageTitle.setText(structure.getLabel());
            struct = structure;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selected = struct;/*
                    curImg = image;
                    image.setBackgroundColor(0xFFEEDD00);
                    getBindingAdapter().notifyItemChanged(getBindingAdapterPosition());*/
                }
            });

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