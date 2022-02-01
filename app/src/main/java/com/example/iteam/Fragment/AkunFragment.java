package com.example.iteam.Fragment;

import static android.content.Context.WINDOW_SERVICE;

import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.biometric.BiometricFragment;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.example.iteam.Activity.Detail_Venue_Activity;
import com.example.iteam.Activity.Edit_Activity_profil;
import com.example.iteam.Activity.LoginActivity;
import com.example.iteam.Activity.MyOrderActivity;
import com.example.iteam.Activity.SliderActivity;
import com.example.iteam.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.zxing.WriterException;

import java.util.concurrent.Executor;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;


public class AkunFragment extends Fragment {
    TextView myOrder;
    private androidx.biometric.BiometricPrompt.PromptInfo promptInfo;
//  private androidx.biometric.BiometricPrompt.PromptInfo promptInfo;
    private Executor executor;
    private BiometricPrompt biometricPrompt;

    String jaki = "Jayapura Kita!";
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    private Switch aSwitch;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_akun,container,false);

        executor = ContextCompat.getMainExecutor(getActivity());

        biometricPrompt = new androidx.biometric.BiometricPrompt(getActivity(), executor, new androidx.biometric.BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getContext(), "Authentication error: " + errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull androidx.biometric.BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getContext(), "Authentication succeed...!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                //Toast.makeText(getContext(), "Authentication failed...!", Toast.LENGTH_SHORT).show();
            }
        });


        //setup title,description on auth dialog
        promptInfo = new androidx.biometric.BiometricPrompt.PromptInfo.Builder()
                .setTitle("Login")
                .setSubtitle("Login into your account")
                .setNegativeButtonText("Cancel")
                .setDescription("Put your finger on the fingerprint sensor to autohorise your account.")
                .build();


//       aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//           @Override
//           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//               if (b){
//                   biometricPrompt.authenticate(promptInfo);
//               }else{
//
//               }
//           }
//       });

       TextView login = v.findViewById(R.id.tv_smart_login);
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               biometricPrompt.authenticate(promptInfo);

           }
       });

       TextView tampil_qrcode = v.findViewById(R.id.tampil_barcode);
       tampil_qrcode.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               // below line is for getting
               // the windowmanager service.
               WindowManager manager = (WindowManager)getContext().getSystemService(WINDOW_SERVICE);

               // initializing a variable for default display.
               Display display = manager.getDefaultDisplay();

               // creating a variable for point which
               Point point = new Point();
               display.getSize(point);

               // getting width and
               // height of a point
               int width = point.x;
               int height = point.y;

               // generating dimension from width and height.
               int dimen = width < height ? width : height;
               dimen = dimen * 3 / 4;


               final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                       getContext(),R.style.bottomSheetDialogTheme);

               View bottomSheetView = LayoutInflater.from(getContext())
                       .inflate(R.layout.sheet_display_code, (LinearLayout) v.findViewById(R.id.sheet_display_code));

               qrgEncoder = new QRGEncoder(jaki, null, QRGContents.Type.TEXT, dimen);
               try {
                   bitmap = qrgEncoder.encodeAsBitmap();
                   ImageView rq = bottomSheetView.findViewById(R.id.idIVQrcode);
                   rq.setImageBitmap(bitmap);

               }catch (WriterException e){
                   Log.e("error", e.toString());
               }


               bottomSheetView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       bottomSheetDialog.dismiss();
                   }
               });

               bottomSheetDialog.setContentView(bottomSheetView);
               bottomSheetDialog.show();
           }
       });

        myOrder = v.findViewById(R.id.pesanan_saya);
        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MyOrderActivity.class));
            }
        });

        TextView ediprofil = v.findViewById(R.id.editProfil);
        ediprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Edit_Activity_profil.class));
            }
        });

        return v;
    }
}