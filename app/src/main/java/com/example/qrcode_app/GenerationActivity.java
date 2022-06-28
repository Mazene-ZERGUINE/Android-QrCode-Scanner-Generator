package com.example.qrcode_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerationActivity extends AppCompatActivity {

    EditText qrCodeValue ;
    Button generate ;
    ImageView display ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generation);

        // variabls
        qrCodeValue = findViewById(R.id.qrcode) ;
        generate = findViewById(R.id.generate) ;
        display = findViewById(R.id.display) ;

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // edit text value
                String myQrCode = qrCodeValue.getText().toString().trim() ;
                MultiFormatWriter writer = new MultiFormatWriter();

                try
                {   // qr code generation
                    BitMatrix matrix = writer.encode(myQrCode, BarcodeFormat.QR_CODE,600,600);
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(matrix);
                    //set data image to imageview
                    display.setImageBitmap(bitmap);

                } catch (WriterException e)
                {
                    e.printStackTrace();
                }

            }
        });
    }



}