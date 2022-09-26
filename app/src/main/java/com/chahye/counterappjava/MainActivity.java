package com.chahye.counterappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.chahye.counterappjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.countTextView.setText(String.valueOf(viewModel.count));

        binding.addButton.setOnClickListener(v -> {
            viewModel.count++;
            binding.countTextView.setText(String.valueOf(viewModel.count));
        });

        binding.subButton.setOnClickListener(v -> {
            viewModel.count--;
            binding.countTextView.setText(String.valueOf(viewModel.count));
        });
    }
}