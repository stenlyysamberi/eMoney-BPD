package com.example.iteam.Fragment;

import static android.Manifest.permission.VIBRATE;
import static android.Manifest.permission_group.CAMERA;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iteam.R;

import eu.livotov.labs.android.camview.ScannerLiveView;
import eu.livotov.labs.android.camview.scanner.decoder.zxing.ZXDecoder;


public class BayarFragment extends Fragment {

    private ScannerLiveView camera;
    private TextView scannedTV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bayar,container,false);



        // initialize scannerLiveview and textview.
        scannedTV = (TextView) v.findViewById(R.id.idTVscanned);
        camera    = (ScannerLiveView) v.findViewById(R.id.camview);

        // check permission method is to check that the
        // camera permission is granted by user or not.
        // request permission method is to request the
        // camera permission if not given.
        if (checkPermission()) {
            // if permission is already granted display a toast message
            Toast.makeText(getActivity(), "Permission Granted..", Toast.LENGTH_SHORT).show();
        } else {

            requestPermission();
        }

        camera.setScannerViewEventListener(new ScannerLiveView.ScannerViewEventListener() {
            @Override
            public void onScannerStarted(ScannerLiveView scanner) {
                // method is called when scanner is started
                //Toast.makeText(getActivity(), "Scanner Started", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onScannerStopped(ScannerLiveView scanner) {
                //Toast.makeText(getActivity(), "Scanner Stoped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onScannerError(Throwable err) {
                //Toast.makeText(getActivity(), "Scanner Error: " + err.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("error", String.valueOf(err));
            }
            @Override
            public void onCodeScanned(String data) {
                scannedTV.setText(data);
                Toast.makeText(getActivity(), "" + data, Toast.LENGTH_SHORT).show();
            }
        });


        return v;


    }

    @Override
    public void onResume() {
        super.onResume();
        ZXDecoder decoder = new ZXDecoder();
        // 0.5 is the area where we have
        // to place red marker for scanning.
        decoder.setScanAreaPercent(0.8);
        // below method will set secoder to camera.
        camera.setDecoder(decoder);
        camera.startScanner();
    }

    @Override
    public void onPause() {
        super.onPause();
        // on app pause the
        // camera will stop scanning.
        camera.stopScanner();
        super.onPause();
    }

    private boolean checkPermission(){
        // here we are checking two permission that is vibrate
        // and camera which is granted by user and not.
        // if permission is granted then we are returning
        // true otherwise false.
        int camera_permission = ContextCompat.checkSelfPermission(getActivity(), CAMERA);
        int vibrate_permission = ContextCompat.checkSelfPermission(getActivity(), VIBRATE);
        return camera_permission == PackageManager.PERMISSION_GRANTED && vibrate_permission == PackageManager.PERMISSION_GRANTED;
    }


    private void requestPermission(){
        // this method is to request
        // the runtime permission.
        int PERMISSION_REQUEST_CODE = 200;
        ActivityCompat.requestPermissions(getActivity(), new String[]{CAMERA, VIBRATE}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length> 0){
            boolean cameraaccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            boolean vibrateaccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
            if (cameraaccepted && vibrateaccepted) {
                Toast.makeText(getActivity(), "Permission granted..", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Permission Denined \n You cannot use app without providing permission", Toast.LENGTH_SHORT).show();
            }

        }
    }
}