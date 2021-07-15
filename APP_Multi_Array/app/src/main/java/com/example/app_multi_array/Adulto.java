package com.example.app_multi_array;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Adulto extends AppCompatActivity {
    private TextView aleatorio1, aleatorio2;
    private int n1, n2;
    private EditText resultado, nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adulto);
        resultado = findViewById(R.id.txt_rNum);
        aleatorio1 = findViewById(R.id.txt_Num1);
        aleatorio2 = findViewById(R.id.txt_Num2);
        nombre = findViewById(R.id.txt_Nombre);
    }

    private void aleatorio() {

        n1 = (int) (Math.random() * 10);
        n2 = (int) (Math.random() * 10);
        aleatorio1.setText(String.valueOf(n1));
        aleatorio2.setText(String.valueOf(n2));
    }

    private void validar() {
        String respuesta;
        String nombre2;
        respuesta = resultado.getText().toString();
        nombre2 = nombre.getText().toString();
        int solucion = Integer.parseInt(respuesta);

        if (n1 * n2 == solucion) {
            Toast.makeText(this, "Eres todo un adulto " + nombre2, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No eres un adulto " + nombre2, Toast.LENGTH_SHORT).show();
        }


    }

    public void adulto(View view) {
        if (view.getId() == R.id.btn_sAdulto) {
            Intent principal1 = new Intent(this, MainActivity.class);
            startActivity(principal1);
        }
        if (view.getId() == R.id.btn_vAdulto) {
            this.validar();
        }
        if (view.getId() == R.id.btn_gNum) {
            this.aleatorio();
        }
    }
}