package com.example.iteam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.iteam.Adapter.ViewPagerAdepter;
import com.example.iteam.R;
import com.example.iteam.databinding.ActivitySplashBinding;

import me.relex.circleindicator.CircleIndicator;

public class SplashActivity extends AppCompatActivity {

//  private ActivitySplashBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_splash);

    }
}