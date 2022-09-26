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

}