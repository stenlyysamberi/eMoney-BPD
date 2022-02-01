package com.example.iteam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.location.Location;
import android.location.LocationRequest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.iteam.Adapter.Fragment.AdapterTabLayout;
import com.example.iteam.MainActivity;
import com.example.iteam.R;
import com.google.android.material.tabs.TabLayout;

public class MyOrderActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    AdapterTabLayout adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        tabLayout =findViewById(R.id.tabLayout);
        viewPager =findViewById(R.id.viewpagerOrder);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new AdapterTabLayout(fm,getLifecycle());
        viewPager.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Riwayat"));
        tabLayout.addTab(tabLayout.newTab().setText("Dalam Proses"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


    }
}