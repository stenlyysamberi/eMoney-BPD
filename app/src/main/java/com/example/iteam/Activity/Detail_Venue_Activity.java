package com.example.iteam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iteam.Adapter.AdapterListImage;
import com.example.iteam.Adapter.Fragment.AdapterVenue;
import com.example.iteam.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Detail_Venue_Activity extends AppCompatActivity {
    WebView webView;
    CollapsingToolbarLayout collapsingToolbarLayout;
    RecyclerView recyclerView,recyclerView2;

    LinearLayout layout_panduan, layout_kontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_venue);
        Bundle extras = getIntent().getExtras();
        String nama = extras.getString("nama");
        int gambar = extras.getInt("img");


        layout_panduan = findViewById(R.id.layot_panduan_lokasi);
        layout_kontak  = findViewById(R.id.layot_detail_kontak);

        webView = findViewById(R.id.web_maps);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(nama);

        ImageView imageView = findViewById(R.id.img_venue_detil);
        imageView.setImageResource(gambar);

        try {

            int[] images = {R.drawable.img4,R.drawable.dompet,R.drawable.wallet,R.drawable.tourists};
            String [] header = {"Lukas Enembe Stadium","Pool Swiming","Futzal","Tenis Lapangan"};
            String [] alamat = {
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan"
            };

            recyclerView = findViewById(R.id.recy_list_foto_venue);
            AdapterListImage myadapter = new AdapterListImage(this,images);
            recyclerView.setAdapter(myadapter);
            //recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,RecyclerView.HORIZONTAL, false));
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

            recyclerView2 = findViewById(R.id.recy_suka);
            AdapterListImage myadapter2 = new AdapterListImage(this,images);
            recyclerView2.setAdapter(myadapter2);
            //recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,RecyclerView.HORIZONTAL, false));
            recyclerView2.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));


        }catch (Exception e){
            Toast.makeText(this, "" + e.toString(), Toast.LENGTH_SHORT).show();
        }

        layout_panduan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botton_sheet_panduan();
            }
        });
        layout_kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottom_sheet_kontak();
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://maps.googleapis.com/maps/api/staticmap?\n"+"ll=36.97,%20-122&lci=bike&z=13&t=p&size=500x500&sensor=true&key=AIzaSyAROUWSpPbs63b3FNlONpzXGnCAPrJ8f4M");



    }

    private void bottom_sheet_kontak() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                Detail_Venue_Activity.this,R.style.bottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.sheet_kontak, (LinearLayout) findViewById(R.id.kontak));

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }

    private void botton_sheet_panduan() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                Detail_Venue_Activity.this,R.style.bottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.sheet_panduan, (LinearLayout) findViewById(R.id.panduan));

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }
}