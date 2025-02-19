package com.example.email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText subject;
    EditText message;

    Button Btnsend;
    Button Btnbifoga;

    TextView bifogadFil;

    Uri URI = null;

    private static final int PICK_FROM_GALLERY = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.EmailAddress);
        subject = findViewById(R.id.ämne);
        message = findViewById(R.id.meddelande);
        Btnsend = findViewById(R.id.send);
        Btnbifoga = findViewById(R.id.bifoga);
        bifogadFil = findViewById(R.id.bifogadFil);
        Intent i = new Intent(Intent.ACTION_SEND);

        // Ger användaren möjlighet att skriva på varje fält samt
        // Skicka mailet genom "skicka mail" knappen
        Btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String till = email.getText().toString();
                String amne = subject.getText().toString();
                String meddelande = message.getText().toString();

                i.putExtra(Intent.EXTRA_EMAIL, new String[]{till});
                i.putExtra(Intent.EXTRA_SUBJECT, amne);
                i.putExtra(Intent.EXTRA_TEXT, meddelande);
                i.setType("text/plain");
                if (URI != null) {
                    i.putExtra(Intent.EXTRA_STREAM, URI);
                }
                startActivity(Intent.createChooser(i, ""));
                Toast.makeText(MainActivity.this, "Mail skickat",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Bifoga fil genom att klicka på knappen bifoga
        Btnbifoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.putExtra("return-data", true);
                startActivityForResult(Intent.createChooser(i, ""), PICK_FROM_GALLERY);
            }
        });
    }
    // Visa den bifogade filen i mailet
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            URI = data.getData();
            bifogadFil.setVisibility(View.VISIBLE);

        }
    }
}