package com.frankchang.qrcode_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class ShowQRCodeActivity extends AppCompatActivity {

    private TextView tvShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_qrcode);

        findViews();
    }

    private void findViews() {
        tvShow = findViewById(R.id.tvShow);
    }

    @Override
    protected void onResume() {
        super.onResume();

        tvShow.setText(getIntent().getStringExtra("showMsg"));
    }

}
