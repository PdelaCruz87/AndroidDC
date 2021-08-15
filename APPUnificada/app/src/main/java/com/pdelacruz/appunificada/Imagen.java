package com.pdelacruz.appunificada;

import static com.pdelacruz.appunificada.R.drawable.ic_visibilidad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class Imagen extends AppCompatActivity {
    ImageView imageView;
    //Definir la activacion, uso y tipo de sensor
    private Sensor sensorProx;
    private SensorManager sensorManager;
    private SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);
        imageView = findViewById(R.id.iv_imagen);
        //Activando y uso del sensor
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorProx = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorProximidad();
        iniciarSensor();

    }

    private void sensorProximidad() {
        if (sensorProx == null) {
            Toast.makeText(this, "No cuenta con el sensor", Toast.LENGTH_SHORT).show();
            finish();

        }

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[0] < sensorProx.getMaximumRange()) {

                    //getWindow().getDecorView().setBackgroundColor(Color.RED);

                 imageView.setImageResource(ic_visibilidad);


                } else {

                    //getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    imageView.setImageResource(R.drawable.ic_cerrado);

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    //Método para iniciar y detener el sensor

    private void iniciarSensor() {

        sensorManager.registerListener(sensorEventListener, sensorProx, 2000 * 1000);

    }

    private void detenerSensor() {

        sensorManager.unregisterListener(sensorEventListener);

    }

    @Override
    protected void onResume() {
        super.onResume();
        iniciarSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detenerSensor();
    }
}