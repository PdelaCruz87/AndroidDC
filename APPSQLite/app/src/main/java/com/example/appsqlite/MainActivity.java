package com.example.appsqlite;

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
            case R.id.btn_insertar:
                intent = new Intent(getApplicationContext(), MainActivityInsertar.class);
                startActivity(intent);
                break;
            case R.id.btn_buscar:
                intent = new Intent(getApplicationContext(), MainActivityBuscar.class);
                startActivity(intent);
                break;
            case R.id.btn_mostrar:
                intent = new Intent(getApplicationContext(), MainActivityMostrar.class);
                startActivity(intent);
                break;
            case R.id.btn_actualizar:
                intent = new Intent(getApplicationContext(), MainActivityActualizar.class);
                startActivity(intent);
                break;
            case R.id.btn_eliminar:
               intent = new Intent(getApplicationContext(), MainActivityEliminar.class);
               startActivity(intent);
                break;
        }

    }
}