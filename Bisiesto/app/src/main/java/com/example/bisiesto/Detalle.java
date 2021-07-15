package com.example.bisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {
    private TextView campoAf, campoM, campoS, campoD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        campoAf = findViewById(R.id.txtsi_no);
        campoM = findViewById(R.id.txtmes);
        campoS = findViewById(R.id.txtsemana);
        campoD = findViewById(R.id.txtdias);
        this.calculo();
    }

    private void calculo() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            int año = bundle.getInt("año1");


            if (año % 4 == 0 && año % 100 != 0 || año % 400 == 0) {
                campoAf.setText("El año SI es bisiesto.");
                campoM.setText("El año tiene 12 meses.");
                campoS.setText("El año tiene 52 semanas");
                campoD.setText("El año tiene 366 días.");
            } else {
                campoAf.setText("El año NO es bisiesto.");
                campoM.setText("El año tiene 12 meses.");
                campoS.setText("El año tiene 52 semanas");
                campoD.setText("El año tiene 365 días.");
            }

        }

    }
}
