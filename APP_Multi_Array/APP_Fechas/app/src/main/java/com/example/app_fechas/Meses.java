package com.example.app_fechas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Meses extends AppCompatActivity {
    private TextView tex1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meses);

        tex1 = findViewById(R.id.txt_historia);
        this.recibirHistoria();

    }

    private void recibirHistoria() {
        Bundle bundle = getIntent().getExtras();
        int texto = bundle.getInt("txt");
        tex1.setText(texto);

    }
}