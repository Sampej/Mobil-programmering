package com.example.gesllprov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button kameraBtn;
    private Button videoBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Öppnar videokamera genom att kalla på videoAktivitet()
        videoBtn = findViewById(R.id.video);
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoAktivitet();
                Toast.makeText(MainActivity.this, "Öppnar videokamera",
                        Toast.LENGTH_LONG).show();
            }

        });

        // Öppnar kameran genom att kalla på kameraAktivitet()
        kameraBtn = findViewById(R.id.kamera);
        kameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kameraAktivitet();
                Toast.makeText(MainActivity.this, "Öppnar kamera", Toast.LENGTH_LONG)
                        .show();
            }

        });
    }

        // Startar kameran
        private void kameraAktivitet() {
            Intent i = new Intent(this, KameraActivity.class);
            startActivity(i);
        }
        // Startar videokameran
        private void videoAktivitet() {
            Intent i = new Intent(this, VideoActivity.class);
            startActivity(i);
        }


    }
