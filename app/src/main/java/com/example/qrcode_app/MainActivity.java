package com.example.qrcode_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button scanBtn ;
    Button genBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanBtn = findViewById(R.id.scannBtn) ;
        genBtn = findViewById(R.id.genBtn) ;

        // redirection to the scan activity

        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ScanActivity = new Intent(MainActivity.this , ScanActivity.class) ;
                startActivity(ScanActivity);
            }
        });

        // redirection to the QR code generation activity

        genBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent genActivity = new Intent(MainActivity.this , GenerationActivity.class) ;
                startActivity(genActivity);
            }
        });
    }
}