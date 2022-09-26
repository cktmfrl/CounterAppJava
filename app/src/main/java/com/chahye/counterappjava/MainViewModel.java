package com.chahye.counterappjava;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private int count = 0;

    MutableLiveData<Integer> countLiveData = new MutableLiveData<>();

    public void increaseCount() {
        count++;
        countLiveData.setValue(count);
    }

    public void decreaseCount() {
        count--;
        countLiveData.setValue(count);
    }
}