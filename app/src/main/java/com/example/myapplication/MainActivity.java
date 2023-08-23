package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MenuFragment menuFragment = new MenuFragment();
    NoteTakingFragment noteFragment = new NoteTakingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        NoteLiveData noteLiveDataViewModel = new ViewModelProvider(this).get(NoteLiveData.class);
        noteLiveDataViewModel.getIsMenuFragment().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Fragment fragment = fragmentManager.findFragmentById(R.id.main_frame);
                if (noteLiveDataViewModel.getIsMenuFragment().getValue() == 0) {

                    if (fragment == null) {
                        fragmentManager.beginTransaction().add(R.id.main_frame, menuFragment).commit();
                    } else {
                        fragmentManager.beginTransaction().replace(R.id.main_frame, menuFragment).commit();
                    }

                } else {
                    if (fragment == null) {
                        fragmentManager.beginTransaction().add(R.id.main_frame, noteFragment).commit();
                    } else {
                        fragmentManager.beginTransaction().replace(R.id.main_frame, noteFragment).commit();
                    }
                }
            }
        });
    }
}