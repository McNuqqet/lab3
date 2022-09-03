package com.example.myapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Structure> data;

    public MutableLiveData<Structure> getData() {
        if(data == null){data = new MutableLiveData<Structure>();}
        return data;
    }
}
