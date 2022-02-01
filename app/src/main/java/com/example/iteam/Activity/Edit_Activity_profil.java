package com.example.iteam.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.iteam.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Edit_Activity_profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        TextView openCam = findViewById(R.id.ganti);
        openCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        Edit_Activity_profil.this,R.style.bottomSheetDialogTheme);

                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(R.layout.sheet_opengalery, (LinearLayout) findViewById(R.id.pilih_foto));

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });
    }
}