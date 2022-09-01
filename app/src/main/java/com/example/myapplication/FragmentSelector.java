package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FragmentSelector extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup ui, Bundle bundle)
    {
        View view = inflater.inflate(
                R.layout.fragment_selector, ui, false);
// Set up event handlers
        return view;
    }
}