package com.example.iteam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.iteam.Adapter.ViewPagerAdepter;
import com.example.iteam.R;

import me.relex.circleindicator.CircleIndicator;

public class SliderActivity extends AppCompatActivity {

    ViewPager viewPager2;
    int[] images = {R.drawable.img4,R.drawable.dompet,R.drawable.wallet,R.drawable.tourists};
    String [] header = {"Selamat Datang di iConnect","Bayar ini itu, Banyak Untungnya","Lebih Mudah Tampa Dompet","Jalan yuk!"};
    String [] dec    = {
            "Aplikasi layanan Tiket yang siap bikin transaksi kamu jadi lebih mudah, aman dan menyenangkan",
            "Jajan makanan hingga bayar Tiket? Semua beres dan makin mudah pake iConnect!",
            "Kini bisa transaksi dan isi saldo langsung pakai kartu debit kamu",
            "Sambil nunggu team mu tading, Bisa juga ya! nikmati objek wisata sekitarmu"
    };
    ViewPagerAdepter adepter;
    CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

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