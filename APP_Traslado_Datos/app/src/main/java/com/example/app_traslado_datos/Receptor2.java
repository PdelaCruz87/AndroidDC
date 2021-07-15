package com.example.app_traslado_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Receptor2 extends AppCompatActivity {


    private TextView campoNo1, campoAp1, campoDi1, campoTe1, campoEd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor2);
        campoNo1 = findViewById(R.id.txtN);
        campoAp1 = findViewById(R.id.txtA);
        campoDi1 = findViewById(R.id.txtD);
        campoTe1 = findViewById(R.id.txtT);
        campoEd1 = findViewById(R.id.txtE);
        this.obtener();
    }

    private void obtener() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String nombre = bundle.getString("nom");
            String apellido = bundle.getString("ape");
            String direccion = bundle.getString("dir");
            String telefono = bundle.getString("tel");
            String edad = bundle.getString("edad");

            campoNo1.setText("Nombre: " + nombre);
            campoAp1.setText("Apellido: " + apellido);
            campoDi1.setText("Dirección: " + direccion);
            campoTe1.setText("Teléfono: " + telefono);
            campoEd1.setText("Edad: " + edad);

        } else {

            Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
        }

    }

}