package com.chahye.counterappjava;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private int count = 0;

    MutableLiveData<Integer> countLiveData = new MutableLiveData<>();

    // 시스템에 의한 종료 시 UI 상태 유지
    private SavedStateHandle handle;

    public MainViewModel(SavedStateHandle savedStateHandle) {
        if (savedStateHandle != null) {
            handle = savedStateHandle;
            count = savedStateHandle.get("count") == null ? 0 : savedStateHandle.get("count");
        }
    }

    private void setCount(int value) {
        this.count = value;
        this.handle.set("count", value);
        countLiveData.setValue(value);
    }

    public void increaseCount() {
        setCount(count + 1);
    }

    public void decreaseCount() {
        setCount(count - 1);
    }
}