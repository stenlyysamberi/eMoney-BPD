package com.example.iteam.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iteam.Internet.Endpoint;
import com.example.iteam.Internet.RestClient;
import com.example.iteam.MainActivity;
import com.example.iteam.Model.MyResponse;
import com.example.iteam.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText nama,email,phone;
    String namas,emails,phones;
    CardView regisBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nama     = findViewById(R.id.nama);
        email    = findViewById(R.id.email);
        phone    = findViewById(R.id.phone);
        regisBTN = findViewById(R.id.regisBTN);

        regisBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namas  = nama.getText().toString();
                emails = email.getText().toString();
                phones = phone.getText().toString();

                if (namas.isEmpty()){
                    nama.setBackgroundResource(R.drawable.outline_red);
                    Toast.makeText(getApplicationContext(), "Nama lengkap harus di isi", Toast.LENGTH_SHORT).show();
                }else if(emails.isEmpty()){
                    email.setBackgroundResource(R.drawable.outline_red);
                    Toast.makeText(getApplicationContext(), "Alamat email harus di isi", Toast.LENGTH_SHORT).show();
                }else if(phones.isEmpty()){
                    phone.setBackgroundResource(R.drawable.outline_red);
                    Toast.makeText(getApplicationContext(), "Nomor HP harus di isi", Toast.LENGTH_SHORT).show();

                }else if (namas.isEmpty() && emails.isEmpty() && phones.isEmpty()){
                    nama.setBackgroundResource(R.drawable.outline_red);
                    email.setBackgroundResource(R.drawable.outline_red);
                    phone.setBackgroundResource(R.drawable.outline_red);
                    Toast.makeText(getApplicationContext(), "Data belum lengkap", Toast.LENGTH_SHORT).show();

                }else{
                    init(namas,emails,phones);
                }

            }
        });


    }

    private void init( String nama, String email, String phone){

        try {

            Endpoint endpoint = RestClient.getRetrofitInstance().create(Endpoint.class);
            Call<MyResponse> respon = endpoint.daftar(nama,email,phone);
            respon.enqueue(new Callback<MyResponse>() {
                @Override
                public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {

                    if (response.isSuccessful() && response.body()!=null){

                        if (response.body().getResult().equals("berhasil")){

                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                            finish();

                        }else{
                            Toast.makeText(getApplicationContext(), "Please Try again.", Toast.LENGTH_LONG).show();
                        }

                    }

                }

                @Override
                public void onFailure(Call<MyResponse> call, Throwable t) {

                }
            });

        }catch (Exception e){
            Log.e("daftar_err", String.valueOf(e));
        }

    }

}