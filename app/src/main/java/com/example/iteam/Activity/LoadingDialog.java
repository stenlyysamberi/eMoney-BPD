package com.example.iteam.Activity;

import android.app.Activity;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

import com.example.iteam.R;

public class LoadingDialog {
    private Activity activity;
    private AlertDialog alertDialog;

    LoadingDialog(Activity myActivity){
        activity = myActivity;
    }

    public void loadingAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.costum_dialog, null));
        builder.setCancelable(true);
        alertDialog = builder.create();
        alertDialog.show();
    }

   public void dismissDialog(){
        alertDialog.dismiss();
    }
}
