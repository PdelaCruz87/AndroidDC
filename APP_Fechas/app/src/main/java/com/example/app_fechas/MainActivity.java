package com.example.app_fechas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private ArrayList<String> mes = new ArrayList<>();
    private ArrayList<Integer> historia = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lv_mes);

        //Llenando ArrayList
        mes.add("Enero");
        mes.add("Febrero");
        mes.add("Marzo");
        mes.add("Abril");
        mes.add("Mayo");
        mes.add("Junio");
        mes.add("Julio");
        mes.add("Agosto");
        mes.add("Septiembre");
        mes.add("Octubre");
        mes.add("Noviembre");
        mes.add("Diciembre");
        //Llenado ArrayList historia

        historia.add(R.string.h1);
        historia.add(R.string.h2);
        historia.add(R.string.h3);
        historia.add(R.string.h4);
        historia.add(R.string.h5);
        historia.add(R.string.h6);
        historia.add(R.string.h7);
        historia.add(R.string.h8);
        historia.add(R.string.h9);
        historia.add(R.string.h10);
        historia.add(R.string.h11);
        historia.add(R.string.h12);

       // ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mes);
        // lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Meses.class);
                intent.putExtra("txt", historia.get(i));
                startActivity(intent);
            }
        });
AdaptadorLista adaptadorLista = new AdaptadorLista(this, R.layout.lista_personalizada, mes);
lista.setAdapter(adaptadorLista);

    }
}