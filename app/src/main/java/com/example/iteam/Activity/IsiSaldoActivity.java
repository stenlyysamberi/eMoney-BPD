package com.example.iteam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iteam.Adapter.AdapterIsiSaldo;
import com.example.iteam.Adapter.AdapterListImage;
import com.example.iteam.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.NumberFormat;
import java.util.Locale;

public class IsiSaldoActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recyclerView;
    ImageView icon_plus;


    CardView cardView;
    private SparseArray<String> keyValues = new SparseArray<>();
    private InputConnection inputConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_saldo);

        icon_plus = findViewById(R.id.icon_plus);
        icon_plus.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.purple_700));


        int [] images = {R.drawable.indonesian_rupiah4,
                        R.drawable.indonesian_rupiah,
                R.drawable.indonesian_rupiah2,
                R.drawable.indonesian_rupiah3,
                R.drawable.indonesian_rupiah5,
                R.drawable.indonesian_rupiah6};

        String [] saldo = {"Rp19.000","Rp49.000","Rp99.000","Rp199.000","Rp299.000","Rp499.000"};

//        TextView title = findViewById(R.id.title_barr);
//        title.setText("Isi Ulang Saldo");

        recyclerView = findViewById(R.id.recy_isi_saldo);
        AdapterIsiSaldo myadapter = new AdapterIsiSaldo(this,images,saldo);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3,RecyclerView.VERTICAL, false));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
    }

    public void add_nominal(View view) {

        TextView satu;
        TextView dua;
        TextView tiga;
        TextView empat;
        TextView lima;
        TextView enam;
        TextView tujuh;
        TextView delapan;
        TextView sembilan;
        TextView kosong;
        TextView clear;
        TextView hapus;
        final TextView[] setNominal = new TextView[1];
        EditText jumlah;
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                IsiSaldoActivity.this,R.style.bottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.sheet_nominal, (LinearLayout) findViewById(R.id.sheet_nominal));
        try {
              String rp = "Rp";
              jumlah = (EditText) bottomSheetView.findViewById(R.id.jumlah);
              jumlah.setRawInputType(InputType.TYPE_CLASS_TEXT);
              jumlah.setTextIsSelectable(true);

              InputConnection ic = jumlah.onCreateInputConnection(new EditorInfo());
              setInputConnection(ic);



              satu = (TextView) bottomSheetView.findViewById(R.id.satu);
              satu.setOnClickListener(this);

              dua = (TextView) bottomSheetView.findViewById(R.id.dua);
              dua.setOnClickListener(this);

              tiga = (TextView) bottomSheetView.findViewById(R.id.tiga);
              tiga.setOnClickListener(this);

              empat = (TextView) bottomSheetView.findViewById(R.id.empat);
              empat.setOnClickListener(this);

              lima = (TextView) bottomSheetView.findViewById(R.id.lima);
              lima.setOnClickListener(this);

              enam = (TextView) bottomSheetView.findViewById(R.id.enam);
              enam.setOnClickListener(this);

              tujuh = (TextView) bottomSheetView.findViewById(R.id.tujuh);
              tujuh.setOnClickListener(this);

              delapan = (TextView) bottomSheetView.findViewById(R.id.delapan);
              delapan.setOnClickListener(this);

              sembilan = (TextView) bottomSheetView.findViewById(R.id.sembilan);
              sembilan.setOnClickListener(this);

              kosong = (TextView) bottomSheetView.findViewById(R.id.kosong);
              kosong.setOnClickListener(this);

              clear = (TextView) bottomSheetView.findViewById(R.id.clear);
              clear.setOnClickListener(this);

              hapus= (TextView) bottomSheetView.findViewById(R.id.hapus);
              hapus.setOnClickListener(this);

              keyValues.put(R.id.satu, "1");
              keyValues.put(R.id.dua, "2");
              keyValues.put(R.id.tiga, "3");
              keyValues.put(R.id.empat, "4");
              keyValues.put(R.id.lima, "5");
              keyValues.put(R.id.enam, "6");
              keyValues.put(R.id.tujuh, "7");
              keyValues.put(R.id.delapan, "8");
              keyValues.put(R.id.sembilan, "9");
              keyValues.put(R.id.kosong, "0");
              keyValues.put(R.id.clear,"000");

              bottomSheetView.findViewById(R.id.btn_nominal_lanjut).setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      TextView a = findViewById(R.id.setNominal);
                      String nominal = jumlah.getText().toString();
                      setNominal[0] = findViewById(R.id.setNominal);
                      setNominal[0].setText(formatRupiah(Double.valueOf(nominal)));
                      bottomSheetDialog.dismiss();
                      cardView = findViewById(R.id.crd_nominal);
                      cardView.setCardBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.hijau_muda));
                      jumlah.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.purple_700));
                      a.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.purple_700));
                      a.setTextSize(17);
                      a.setHintTextColor(ContextCompat.getColor(getApplicationContext(),R.color.purple_500));
                      icon_plus.setImageResource(R.drawable.ic_baseline_add_circle_outline_24);
                      icon_plus.setColorFilter(ContextCompat.getColor(getApplicationContext(),R.color.hijau_tua));


                  }
              });



        }catch (Exception e){
          Log.e("error", String.valueOf(e));
        }

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }


    @Override
    public void onClick(View view) {
        if (inputConnection == null)
            return;

        if (view.getId() == R.id.hapus){
            CharSequence select_txt = inputConnection.getSelectedText(0);
            if (TextUtils.isEmpty(select_txt)){
                inputConnection.deleteSurroundingText(1,0);
            }else{
                inputConnection.commitText("", 1);
            }
        } else{
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value, 1);
        }
    }
    public void setInputConnection(InputConnection ic){
        inputConnection = ic;
    }

    private String formatRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }

    public void konfir_topUp(View view) {
        startActivity(new Intent(IsiSaldoActivity.this,Konfirmasi_Top_Up_Activity.class));
        finish();
    }
}