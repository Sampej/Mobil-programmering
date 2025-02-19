package com.example.webbsidor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.aftonbladet);
        Button btn2 = findViewById(R.id.fotbollskanalen);

        // Genom att klicka på knappen öppnas aftonbladet
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.aftonbladet.se/"));
                startActivity(i);

            }
        });

        // Genom att klicka på knappen öppnas aftonbladet
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.fotbollskanalen.se/"));
                startActivity(i);
            }
        });
    }
}