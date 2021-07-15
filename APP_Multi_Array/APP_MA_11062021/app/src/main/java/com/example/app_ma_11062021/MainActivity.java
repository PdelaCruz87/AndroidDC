package com.example.app_ma_11062021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText nombre;
private EditText edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    nombre = findViewById(R.id.txtNombre);
    edad = findViewById(R.id.txtEdad);

    }
    private void comparar(){
        int edadPersona;
        //edadPersona= edad.getText().toString();
        //if()
    }


    public void inicio(View view) {

        switch (view.getId()){
            case R.id.btnInicio:
                this.comparar();
                break;
        }

    }
}