package com.example.app_traslado_datos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText campoN, campoA, campoD, campoE, campoT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campoN = findViewById(R.id.txt_Nom);
        campoA = findViewById(R.id.txt_Ape);
        campoD = findViewById(R.id.txt_Dire);
        campoT = findViewById(R.id.txt_tel);
        campoE = findViewById(R.id.txt_Edad);


    }

    private void datos() {
        String No = campoN.getText().toString();
        String Ap = campoA.getText().toString();
        String Di = campoD.getText().toString();
        String Te = campoT.getText().toString();
        String Ed = campoE.getText().toString();
        if (!No.isEmpty() && !Ap.isEmpty() && !Di.isEmpty() && !Te.isEmpty() && !Ed.isEmpty()) {
            Intent intent = new Intent(this, Receptor2.class);
            intent.putExtra("nom", No);
            intent.putExtra("ape", Ap);
            intent.putExtra("dir", Di);
            intent.putExtra("tel", Te);
            intent.putExtra("eda", Ed);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClick(View view) {

        if (view.getId() == R.id.btn_enviar) {
            this.datos();
        }

    }
}