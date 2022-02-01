package com.example.iteam.Adapter.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iteam.Activity.Detail_Venue_Activity;
import com.example.iteam.R;
import com.squareup.picasso.Picasso;


public class AdapterWisataHome extends RecyclerView.Adapter<AdapterWisataHome.ViewHolder> {

    Context context;
    String data1[], data2[];
    String [] images;

    public AdapterWisataHome(Context context, String[] data1, String[] data2, String[] images) {
        this.context = context;
        this.data1 = data1;
        this.data2 = data2;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_wisata_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        holder.nama_venue.setText(data1[position]);
//        holder.alamat_venue.setText(data2[position]);

        Picasso.with(context).load(images[position]).into(holder.imageView);

//      holder.imageView.setImageResource(images[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Detail_Venue_Activity.class);
                i.putExtra("nama", data1[position]);
                i.putExtra("alamat",data2[position]);
                i.putExtra("img", images[position]);
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nama_venue,alamat_venue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageWisataHome);
//            nama_venue = itemView.findViewById(R.id.nama_wisata);
//            alamat_venue = itemView.findViewById(R.id.alamat_wisata);
        }
    }
}
