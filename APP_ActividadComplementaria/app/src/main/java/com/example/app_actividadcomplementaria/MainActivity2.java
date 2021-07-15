package com.example.app_actividadcomplementaria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    //Declarando variables de componentes a utilizar
    private EditText campo1, campo2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Activando componentes
        campo1 = findViewById(R.id.txtNum1);
        campo2 = findViewById(R.id.txtNum2);
        resultado = findViewById(R.id.txtResultado);

    }

    private void sumar() {
        String num1;
        String num2;
        num1 = campo1.getText().toString();
        num2 = campo2.getText().toString();
        if (!num1.isEmpty() && !num2.isEmpty()) {
            int suma = Integer.parseInt(num1) + Integer.parseInt(num2);
            resultado.setText("La suma es: " + suma);
        } else {
            Toast.makeText(this, "Campos vacíos", Toast.LENGTH_LONG).show();
        }

    }


    public void Suma(View view) {

        if (view.getId() == R.id.btnSumar) {
            this.sumar();
        }
    }
}