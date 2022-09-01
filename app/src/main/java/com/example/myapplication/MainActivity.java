package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

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
        MapData data = MapData.get();
        //FragmentSelector fragSelector = (FragmentSelector) fm.findFragmentById(R.id.selector);


        if(fragMap == null) {
            fragMap = new FragmentMap(data);
            fm.beginTransaction().add(R.id.map, fragMap).commit();
        }
/*
        if(fragSelector == null) {
            fragSelector = new FragmentSelector();
            fm.beginTransaction().add(R.id.selector, fragSelector).commit();
        }*/
    }
}