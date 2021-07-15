package com.example.app_multi_array;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declarando variables
    private EditText Nombre, Edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nombre = findViewById(R.id.txt_Nombre);
        Edad = findViewById(R.id.txt_Edad);
    }

    private void validar() {
        String campoEdad;
        String campoNombre;
        int edad;
        campoNombre = Nombre.getText().toString();
        campoEdad = Edad.getText().toString();
        if (!campoEdad.isEmpty() && !campoNombre.isEmpty()) {
            edad = Integer.parseInt(campoEdad);
            if (edad <= 17) {
                Intent intentomE = new Intent(this, Menor_Edad.class);
                startActivity(intentomE);
            } else {
                Intent intentoME = new Intent(this, Adulto.class);
                startActivity(intentoME);
            }
        } else {
            Toast.makeText(this, "Verificar sus datos", Toast.LENGTH_SHORT).show();

        }
    }

    public void Arrays(View view) {
        //Ingresando a la pantalla
        if (view.getId() == R.id.btn_Validar) {
            this.validar();
        }
        //Cerrar la app
        if (view.getId() == R.id.btn_Salir) {
            ;
        }

    }
}