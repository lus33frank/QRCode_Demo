package com.frankchang.qrcode_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 製造 QRCode
    public void mackQRCodeBtnClick(View view) {
        Intent makeIntent = new Intent(MainActivity.this, MakeQRCodeActivity.class);
        startActivity(makeIntent);
    }

    // Scan QRCode
    public void showQRCodeBtnClick(View view) {
        Intent scanIntent = new Intent(MainActivity.this, ScanQRCodeActivity.class);
        startActivity(scanIntent);
    }

}
