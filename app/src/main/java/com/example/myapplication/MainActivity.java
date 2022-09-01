package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentMap fragMap = (FragmentMap) fm.findFragmentById(R.id.map);
        FragmentSelector fragSelector = (FragmentSelector) fm.findFragmentById(R.id.selector);

        fragMap = new FragmentMap();
        fm.beginTransaction().add(R.id.map, fragMap).commit();
        fragSelector = new FragmentSelector();
        fm.beginTransaction().add(R.id.selector, fragSelector).commit();
    }
}