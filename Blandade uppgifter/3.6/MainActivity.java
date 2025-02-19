package com.example.texttilltal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button lasBtn;
    EditText editText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lasBtn = findViewById(R.id.lasBtn);
        editText = findViewById(R.id.editText);

        // Sätter språket i detta fall engelska
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        // Texten from editText läses upp
        lasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = editText.getText().toString();
                textToSpeech.speak(getText, TextToSpeech.QUEUE_FLUSH, null);

            }
        });

    }
}