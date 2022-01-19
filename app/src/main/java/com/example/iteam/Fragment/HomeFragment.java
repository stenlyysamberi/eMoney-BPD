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

            String [] images = {"https://th.bing.com/th/id/OIP.qf_P2ERv8eNjQispa6V1VAHaEK?pid=ImgDet&rs=1",
            "https://cdn-asset.jawapos.com/wp-content/uploads/2020/05/JAYAPURA-GOR-WARINGIN-RIANA-1-1125x750.jpg",
            "https://football-tribe.com/indonesia/wp-content/uploads/sites/10/2019/03/Mandala-Krida.jpg",
            "https://cdn-asset.jawapos.com/wp-content/uploads/2019/09/polo-air.jpg"};
            String [] header = {"Lukas Enembe Stadium","Gor Waringin","Stadium Mandala","Tenis Lapangan"};
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