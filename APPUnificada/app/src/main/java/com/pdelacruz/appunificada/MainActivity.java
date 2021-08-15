package com.pdelacruz.appunificada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnCamara:
                intent = new Intent(getApplicationContext(), Camara.class);
                startActivity(intent);
                break;
            case R.id.btnImagen:
                intent = new Intent(getApplicationContext(), Imagen.class);
                startActivity(intent);
                break;
            case R.id.btnLaser:
                intent = new Intent(getApplicationContext(), Laser.class);
                startActivity(intent);
                break;


        }
    }
}