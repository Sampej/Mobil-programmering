package com.example.internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn;

        btn = findViewById(R.id.internetBtn);

        // Visar om man är ansluten eller inte till internet genom att klicka på knappen.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (internetAnslutning()){
                    Toast.makeText(getApplicationContext(), "Ansluten till intertnet",
                            Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "Inte ansluten till intertnet",
                            Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    public boolean internetAnslutning(){
        ConnectivityManager c = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo n = c.getActiveNetworkInfo();
        if (n == null)
            return false;

        // Anslutningen är en wifi anlslutning
        if (n.getType() == ConnectivityManager.TYPE_WIFI){
            Toast.makeText(this, "Wifi-anslutning",Toast.LENGTH_SHORT).show();

        }
        return n.internetAnslutning();
    }


}