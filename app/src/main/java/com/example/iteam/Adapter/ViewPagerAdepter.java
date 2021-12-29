package com.example.iteam.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.iteam.R;

import java.util.Objects;

public class ViewPagerAdepter extends PagerAdapter {

    Context context;
    int [] images;
    String [] header,dec;
    LayoutInflater layoutInflater;

    public ViewPagerAdepter(Context context, int[] images, String[] header, String[] dec) {
        this.context = context;
        this.images = images;
        this.header = header;
        this.dec = dec;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.item,container,false);
        ImageView imageView = itemView.findViewById(R.id.image_slider);
        TextView header_titile = itemView.findViewById(R.id.header),
                 decs = itemView.findViewById(R.id.dec_title);

        header_titile.setText(header[position]);
        decs.setText(dec[position]);

        imageView.setImageResource(images[position]);
        Objects.requireNonNull(container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
