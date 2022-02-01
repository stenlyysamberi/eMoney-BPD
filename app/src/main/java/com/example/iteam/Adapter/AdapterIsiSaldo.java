package com.example.iteam.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iteam.R;
import com.squareup.picasso.Picasso;


public class AdapterIsiSaldo extends RecyclerView.Adapter<AdapterIsiSaldo.ViewHolder> {

    Context context;
    int [] images;
    String [] saldo;

    public AdapterIsiSaldo(Context context, int[] images, String[] saldo) {
        this.context = context;
        this.images = images;
        this.saldo = saldo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_isi_saldo,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.price.setText(saldo[position]);
        Picasso.with(context).load(images[position]).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return saldo.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView  price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.img_money);

        }
    }
}
