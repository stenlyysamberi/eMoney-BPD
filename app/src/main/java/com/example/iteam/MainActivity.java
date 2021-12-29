package com.example.iteam;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.example.iteam.Fragment.AkunFragment;
import com.example.iteam.Fragment.BayarFragment;
import com.example.iteam.Fragment.HomeFragment;
import com.example.iteam.Fragment.OrderFragment;
import com.example.iteam.Fragment.TicketFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    ChipNavigationBar bottomNav;
    RelativeLayout mToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav = findViewById(R.id.bottom_navigation);

        mToolbarLayout = findViewById(R.id.mainToolbar);

        if (savedInstanceState == null) {
            bottomNav.setItemSelected(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, homeFragment)
                    .commit();
        }

        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.tiket:
                        fragment = new TicketFragment();
                        break;
                    case R.id.bayar:
                        fragment = new BayarFragment();
                        break;

                    case R.id.history:
                        fragment = new OrderFragment();
                        break;

                    case R.id.akun:
                        fragment = new AkunFragment();
                        break;
                }

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                } else {
                    Log.e(TAG, "Error in creating fragment");
                }
            }
        });

    }
}