package com.chahye.counterappjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.chahye.counterappjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.countLiveData.observe(this, count -> {
            binding.countTextView.setText(String.valueOf(count));
        });

        binding.addButton.setOnClickListener(v -> {
            viewModel.increaseCount();
        });

        binding.subButton.setOnClickListener(v -> {
            viewModel.decreaseCount();
        });
    }

    // 시스템에 의한 종료 시 UI 상태 유지
//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("count", viewModel.count);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        viewModel.count = savedInstanceState.getInt("count");
//    }

}