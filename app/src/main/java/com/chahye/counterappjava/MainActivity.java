package com.chahye.counterappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chahye.counterappjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.countTextView.setText(String.valueOf(count));

        binding.addButton.setOnClickListener(v -> {
            count++;
            binding.countTextView.setText(String.valueOf(count));
        });

        binding.subButton.setOnClickListener(v -> {
            count--;
            binding.countTextView.setText(String.valueOf(count));
        });
    }
}