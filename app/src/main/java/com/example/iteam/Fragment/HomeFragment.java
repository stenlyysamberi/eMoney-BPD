package com.example.iteam.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iteam.Activity.IsiSaldoActivity;
import com.example.iteam.Activity.LoginActivity;
import com.example.iteam.Adapter.Fragment.AdapterVenue;
import com.example.iteam.MainActivity;
import com.example.iteam.R;


public class HomeFragment extends Fragment {

    private ScrollView scrollView;
    MainActivity mainActivity;

    RecyclerView recyclerView;
    CardView isi_saldo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        //mainActivity = (MainActivity)getActivity();

        isi_saldo = v.findViewById(R.id.isi_saldo);


        try {

            int[] images = {R.drawable.icon_bank,R.drawable.keluar,R.drawable.medical,R.drawable.pat};
            String [] header = {"Lukas Enembe Stadium","Pool Swiming","Futzal","Tenis Lapangan"};
            String [] alamat = {
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan"
            };

            recyclerView = v.findViewById(R.id.recy_venue);
            AdapterVenue myadapter = new AdapterVenue(getActivity(),header,alamat,images);
            recyclerView.setAdapter(myadapter);
            //recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,RecyclerView.HORIZONTAL, false));
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL, false));


        }catch (Exception e){
            Toast.makeText(getContext(), "" + e.toString(), Toast.LENGTH_SHORT).show();
        }

        isi_saldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), IsiSaldoActivity.class));
            }
        });


        return v;




        //       final int[] state = new int[1];
//        scrollView.getViewTreeObserver().addOnScrollChangedListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//
//            }
//        });




        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);



    }





}