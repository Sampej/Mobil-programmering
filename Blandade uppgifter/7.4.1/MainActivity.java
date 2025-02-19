package com.example.gyroscope;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor gyroscope;
    private SensorEventListener sensorEventListener;

    // Ändrar bakgrundsfärgen när telefonen roteras
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[2]  > 0.3f){
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }else if (event.values[2] < -0.3f){
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);

                }
            }
            // Anropas när sensor ändras
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

    }
    // Anropas när appen används
    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(sensorEventListener,gyroscope,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

}