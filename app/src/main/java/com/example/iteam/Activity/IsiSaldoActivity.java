package com.example.iteam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.iteam.Adapter.AdapterIsiSaldo;
import com.example.iteam.Adapter.AdapterListImage;
import com.example.iteam.R;

public class IsiSaldoActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_saldo);

        int[] images = {R.drawable.img4,R.drawable.dompet,R.drawable.wallet,R.drawable.tourists};
        String [] saldo = {"19K","49K","99K","199K","299K","499K"};

        TextView title = findViewById(R.id.title_barr);
        title.setText("Isi Ulang Saldo");

        recyclerView = findViewById(R.id.recy_isi_saldo);
        AdapterIsiSaldo myadapter = new AdapterIsiSaldo(this,saldo);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.VERTICAL, false));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
    }
}