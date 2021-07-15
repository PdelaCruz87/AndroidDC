package com.example.bisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        año = findViewById(R.id.txtaño);

    }

    private void calculo() {
        int a = Integer.parseInt(año.getText().toString());
        Intent intent = new Intent(this, Detalle.class);
        intent.putExtra("año1", a);
        startActivity(intent);

    }

    public void onClick(View view) {
        if (view.getId() == R.id.btncalcular) {
            this.calculo();
        }
    }
}