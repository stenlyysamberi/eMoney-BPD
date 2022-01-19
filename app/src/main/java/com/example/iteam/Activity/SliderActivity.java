package com.example.iteam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.iteam.Adapter.ViewPagerAdepter;
import com.example.iteam.R;

import me.relex.circleindicator.CircleIndicator;

public class SliderActivity extends AppCompatActivity {
      Activity activity;
//    Window window = activity.getWindow();

    ViewPager viewPager2;
    int[] images = {R.drawable.img4,R.drawable.dompet,R.drawable.wallet,R.drawable.tourists};
    String [] header = {"Selamat Datang di Jaki","Bayar ini itu, Banyak Untungnya","Lebih Mudah Tampa Dompet","Jalan yuk!"};
    String [] dec    = {
            "Aplikasi layanan Tiket yang siap bikin transaksi kamu jadi lebih mudah, aman dan menyenangkan",
            "Jajan makanan hingga bayar Tiket? Semua beres dan makin mudah pake Jaki!",
            "Kini bisa transaksi dan isi saldo langsung pakai kartu debit kamu",
            "Sambil nunggu team mu tading, Bisa juga ya! nikmati objek wisata sekitarmu"
    };
    ViewPagerAdepter adepter;
    CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

//        Window window = activity.getWindow();
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.setStatusBarColor(activity.getResources().getColor(R.color.purple_700));

        viewPager2 = findViewById(R.id.viewpager2);
        indicator = findViewById(R.id.indicator);
        adepter = new ViewPagerAdepter(this, images,header,dec);
        viewPager2.setAdapter(adepter);
        indicator.setViewPager(viewPager2);
    }

    public void sing_up(View view) {
        startActivity(new Intent(SliderActivity.this,LoginActivity.class));
        finish();
    }
}