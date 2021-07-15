package com.example.app_multi_array;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Menor_Edad extends AppCompatActivity {
    private TextView aleatorio1, aleatorio2;
    private EditText respuestaME, nombre;
    private int n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menor_edad);
        respuestaME = findViewById(R.id.txt_rme);
        aleatorio1 = findViewById(R.id.txt_meNum1);
        aleatorio2 = findViewById(R.id.txt_meNum2);
        nombre = findViewById(R.id.txt_Nombre);
    }

    private void aleatorioS() {
        n1 = (int) (Math.random() * 10);
        n2 = (int) (Math.random() * 10);
        aleatorio1.setText(String.valueOf(n1));
        aleatorio2.setText(String.valueOf(n2));
    }

    private void validarS() {
        String respuesta;
        String nombre1;
        respuesta = respuestaME.getText().toString();
        nombre1 = nombre.getText().toString();
        int solucion = Integer.parseInt(respuesta);
        if (n1 + n2 == solucion) {
            Toast.makeText(this, "Felicidades no eres tan bebé" + nombre1, Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Sigues siendo un bebé" + nombre1, Toast.LENGTH_SHORT).show();
        }
    }

    public void menor(View view) {
        if (view.getId() == R.id.btn_sMenor) {
            Intent principal2 = new Intent(this, MainActivity.class);
            startActivity(principal2);

        }
        if (view.getId() == R.id.btn_gmeNum) {
            this.aleatorioS();
        }
        if (view.getId() == R.id.btn_vMenor) {

            this.validarS();
        }
    }
}