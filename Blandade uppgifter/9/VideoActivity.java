package com.example.gesllprov;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private Button huvudmenyBtn;

    private Button btnVideo;

    private VideoView video;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        huvudmenyBtn = findViewById(R.id.huvudmeny);
        btnVideo = findViewById(R.id.videoBtn);
        video = findViewById(R.id.videoView);

        // Kallar på funktion mainActivty() och tar användaren tillbaka till huvudmenyn genom att
        // klicka på "huvudmeny" knappen.
        huvudmenyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity();
                Toast.makeText(VideoActivity.this, "Tillbaka till huvudmenyn",
                        Toast.LENGTH_LONG).show();
            }

        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override

            //Kameran börjar filma
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,1);

            }
        });

    }

    @Override
    // Visar resultatet av videon
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            video.setVideoURI(data.getData());
            video.start();
        }

    }
        // Tillbaka till huvudmenyn
        private void mainActivity() {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
    }


}