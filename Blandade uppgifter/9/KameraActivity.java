package com.example.gesllprov;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class KameraActivity extends AppCompatActivity {


    private Button huvudmenyBtn;
    private ImageView bild;
    private Button btnKamera;
    private Button btnFilter;
    private Button btnFilter2;
    private Button btnFilter3;
    private Button btnIngeFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);

        bild = findViewById(R.id.imageview);
        btnKamera = findViewById(R.id.button);
        huvudmenyBtn = findViewById(R.id.huvudmeny);
        btnFilter = findViewById(R.id.filter);
        btnFilter2 = findViewById(R.id.filter2);
        btnFilter3 = findViewById(R.id.filter3);
        btnIngeFilter = findViewById(R.id.noFilter);

        // Be om tillstånd att använda kameran
        if (ContextCompat.checkSelfPermission(KameraActivity.this,
                android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(KameraActivity.this, new String[]{
                    Manifest.permission.CAMERA}, 100);

        }

        // Visar resultatet av bilden
        final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                       Bundle bundle = result.getData().getExtras();
                       Bitmap bitmap = (Bitmap) bundle.get("data");
                       bild.setImageBitmap(bitmap);
                    }
                }
        );

        // Ta bild genom att klicka på knappen
        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultLauncher.launch(i);
                Toast.makeText(KameraActivity.this, "Säg cheese",
                        Toast.LENGTH_LONG).show();

            }
        });

        // Sätt ett oranget filter på bilden
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView filter = (ImageView) findViewById(R.id.imageview);
                int orange = Color.parseColor("#66FF0000");
                filter.setColorFilter(orange);
            }
        });

        // Sätt ett blått filter på bilden
        btnFilter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView filter = (ImageView) findViewById(R.id.imageview);
                int blue = Color.parseColor("#660000FF");
                filter.setColorFilter(blue);
            }
        });

        // Sätt ett grönt filter på bilden
        btnFilter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView filter = (ImageView) findViewById(R.id.imageview);
                int green = Color.parseColor("#6600FF00");
                filter.setColorFilter(green);
            }
        });


        // Tillbaka till utan filter
        btnIngeFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView noFilter = (ImageView) findViewById(R.id.imageview);
                int transparent = Color.parseColor("#00FFFFFF");
                noFilter.setColorFilter(transparent);
            }
        });

        // Kallar på funktion mainActivty() och tar användaren tillbaka till huvudmenyn genom att
        // klicka på "huvudmeny" knappen.
        huvudmenyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity();
                Toast.makeText(KameraActivity.this, "Tillbaka till huvudmenyn",
                        Toast.LENGTH_LONG).show();
            }

        });
    }

    // Tillbaka till huvudmenyn
    private void mainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}



