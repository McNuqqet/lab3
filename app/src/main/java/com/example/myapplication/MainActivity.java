package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentMap fragMap = (FragmentMap) fm.findFragmentById(R.id.map);
        FragmentSelector fragSelector = (FragmentSelector) fm.findFragmentById(R.id.selector);

        MapData mapData = MapData.get();
        StructureData structData = StructureData.get();

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        if(fragMap == null) {
            fragMap = new FragmentMap(mapData, viewModel);
            fm.beginTransaction().add(R.id.map, fragMap).commit();
        }
        else{
            getSupportFragmentManager().findFragmentById(R.id.map);
        }

        if(fragSelector == null) {
            fragSelector = new FragmentSelector(structData, viewModel);
            fm.beginTransaction().add(R.id.selector, fragSelector).commit();
        }
        else{
            getSupportFragmentManager().findFragmentById(R.id.selector);
        }
    }
}