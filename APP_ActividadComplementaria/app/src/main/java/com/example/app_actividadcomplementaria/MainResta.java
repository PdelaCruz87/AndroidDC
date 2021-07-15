package com.example.app_actividadcomplementaria;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainResta extends AppCompatActivity {
    private EditText campo1;
    private EditText campo2;
    private TextView resultador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_resta);
        campo1 = findViewById(R.id.txtNum1);
        campo2 = findViewById(R.id.txtNum2);
        resultador = findViewById(R.id.txtResultado);


    }

    private void resta() {
        String num1;
        String num2;
        num1 = campo1.getText().toString();
        num2 = campo2.getText().toString();
        if (!num1.isEmpty() && !num2.isEmpty()) {
            int restar = Integer.parseInt(num1) - Integer.parseInt(num2);
            resultador.setText("La resta es: " + restar);
        } else {
            Toast.makeText(this, "Campos vacíos", Toast.LENGTH_LONG).show();
        }

    }

    public void Restar(View view) {

        if (view.getId() == R.id.btnRestar) {
            this.resta();

        }
    }
}