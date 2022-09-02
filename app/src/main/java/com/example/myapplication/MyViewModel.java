package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private LiveData<Structure> viewModel = null;

    public LiveData<Structure> getData(){return viewModel;}
}
