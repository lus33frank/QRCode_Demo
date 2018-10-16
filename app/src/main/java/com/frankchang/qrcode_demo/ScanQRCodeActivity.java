package com.frankchang.qrcode_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class ScanQRCodeActivity extends AppCompatActivity {

    private IntentIntegrator integrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qrcode);
    }

    @Override
    protected void onResume() {
        super.onResume();

        integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Scan QRCode");
        integrator.setCameraId(1);
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(false);
        integrator.setOrientationLocked(false);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result != null) {
            if (result.getContents() != null) {
                String showMsg = result.getContents();
                Intent showIntent = new Intent(ScanQRCodeActivity.this,
                        ShowQRCodeActivity.class);
                showIntent.putExtra("showMsg", showMsg);
                startActivity(showIntent);

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

}
