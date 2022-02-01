package com.example.iteam.Adapter.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.iteam.Fragment.TabLayout.ProsesFragment;
import com.example.iteam.Fragment.TabLayout.RiwayatFragment;

public class AdapterTabLayout extends FragmentStateAdapter {
    public AdapterTabLayout(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1 :
                return new ProsesFragment();
            case 2 :
                return new RiwayatFragment();
        }
        return new RiwayatFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
