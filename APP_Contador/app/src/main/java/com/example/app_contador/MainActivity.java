package com.example.app_contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Declaración de objetos que tiene una acción aparte de los button

    TextView txtContador;
int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Establece y encuentra la vista por ID para ser utilizada dentro de la clase
        txtContador = findViewById(R.id.txtContador);
    }
private void mas(){
        contador++;
        txtContador.setText(contador+"");
        if(contador == 10){
            Toast.makeText(getApplicationContext(), "Felicidades, ha realizado 10 pulsos", Toast.LENGTH_SHORT).show();

        }

}
private void menos(){
        contador--;
        txtContador.setText(contador+"");
}
private void reinicio() {
    contador =0;
    txtContador.setText(String.valueOf(contador));
    Toast.makeText(getApplicationContext(), "El Contador se reinició a 0", Toast.LENGTH_SHORT).show();

}
public void pulsar(View view) {

        if (view.getId()==R.id.btnMas){
            mas();
        }
        if (view.getId()== R.id.btnMenos) {
            menos();
        }
        if(view.getId()== R.id.btnReinicio){
            reinicio();
        }
        }
    }
