package com.example.iteam.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.iteam.Adapter.Fragment.AdapterVenue;
import com.example.iteam.Adapter.Fragment.AdapterWisata;
import com.example.iteam.R;

public class TicketFragment extends Fragment {
    RecyclerView recyclerView;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ticket,container,false);

        try {
            String [] images = {"https://www.pantainesia.com/wp-content/uploads/2018/07/pantai-hamadi-990x558.jpg",
                    "https://media-cdn.tripadvisor.com/media/photo-s/14/15/6c/19/rusian-beach.jpg",
                    "https://media-cdn.tripadvisor.com/media/photo-s/10/f7/17/71/kayu-kelapa-yang-membentang.jpg",
                    "https://media-cdn.tripadvisor.com/media/photo-s/10/f7/17/5c/ayunan-yang-digunakan.jpg",
                    "https://www.pantainesia.com/wp-content/uploads/2018/07/pantai-hamadi-990x558.jpg",
                    "https://media-cdn.tripadvisor.com/media/photo-s/0b/58/8d/53/seandainya-langit-cerah.jpg",
                    "https://media-cdn.tripadvisor.com/media/photo-s/06/5b/6b/c3/harlem-beach.jpg",
                    "https://www.pantainesia.com/wp-content/uploads/2018/07/pantai-hamadi-990x558.jpg"};
            //int[] images = {R.drawable.dompet,R.drawable.wisata,R.drawable.suntik,R.drawable.wisata,R.drawable.wisata,R.drawable.wisata,R.drawable.wisata,R.drawable.wisata};
            String [] header = {"Hamadi Beach","Harlem Beach","Pulow Park","Sentani Like","Hamadi Beach","Harlem Beach","Pulow Park","Sentani Like"};
            String [] alamat = {
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan",
                    "Jl.Airport Sentani, Kampung Harapan"
            };

            recyclerView = v.findViewById(R.id.recy_wisata);
            recyclerView.setEnabled(false);
            AdapterWisata myadapter = new AdapterWisata(getActivity(),header,alamat,images);
            recyclerView.setAdapter(myadapter);
            staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
            //recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL, false));
//          recyclerView.setLayoutManager(new StaggeredGridLayoutManager(getActivity(),2,LinearLayoutManager.VERTICAL));


        }catch (Exception e){
            Toast.makeText(getContext(), "" + e.toString(), Toast.LENGTH_SHORT).show();
        }

        return v;
    }
}