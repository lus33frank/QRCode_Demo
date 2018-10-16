package com.frankchang.qrcode_demo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class MakeQRCodeActivity extends AppCompatActivity {

    private EditText etMessage;
    private ImageView imgShowQRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_qrcode);

        findViews();
    }

    private void findViews() {
        etMessage = findViewById(R.id.etMessage);
        imgShowQRCode = findViewById(R.id.imgShowQRCode);
    }

    // Make QRCode
    public void mackBtnClick(View view) {
        String strMsg = etMessage.getText().toString();

        if (!strMsg.equals("")) {
            BarcodeEncoder encoder = new BarcodeEncoder();
            try {
                Bitmap bit = encoder.encodeBitmap(strMsg, BarcodeFormat.QR_CODE,
                        500, 500);
                imgShowQRCode.setImageBitmap(bit);
            } catch (WriterException e) {
                e.printStackTrace();
            }
        }
    }

}
