package com.example.iteam.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iteam.Adapter.Fragment.AdapterTabLayout;
import com.example.iteam.Adapter.ViewPagerAdepter;
import com.example.iteam.R;
import com.google.android.material.tabs.TabLayout;

public class OrderFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    AdapterTabLayout adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order,container,false);

//        tabLayout =v.findViewById(R.id.tabLayout);
//        viewPager =v.findViewById(R.id.viewpagerOrder);

//        FragmentManager fm = getActivity().getSupportFragmentManager();
//        adapter = new AdapterTabLayout(fm,getLifecycle());
        //viewPager.setAdapter());

//        tabLayout.addTab(tabLayout.newTab().setText("Riwayat Kunjungan"));
//        tabLayout.addTab(tabLayout.newTab().setText("Dalam Proses"));
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                tabLayout.selectTab(tabLayout.getTabAt(position));
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });


        return v;
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_order, container, false);
    }
}