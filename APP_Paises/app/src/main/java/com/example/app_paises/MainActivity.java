package com.example.app_paises;

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
    ArrayList<String> pais = new ArrayList<>();
    private ArrayList<Integer> img = new ArrayList<>();
    ArrayList<Integer> info = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lv_pais);

        //Llenando el ArrayList
        pais.add("Brasil");
        pais.add("China");
        pais.add("Estados Unidos");
        pais.add("Francia");
        pais.add("Alemania");
        pais.add("Guatemala");
        pais.add("Italia");
        pais.add("México");
        pais.add("España");
        pais.add("Reino Unido");
        // Llenando las imágenes
        img.add(R.drawable.ic_brazil);
        img.add(R.drawable.ic_china);
        img.add(R.drawable.ic_eeuu);
        img.add(R.drawable.ic_france);
        img.add(R.drawable.ic_germany);
        img.add(R.drawable.ic_guatemala);
        img.add(R.drawable.ic_italy);
        img.add(R.drawable.ic_mexico);
        img.add(R.drawable.ic_spain);
        img.add(R.drawable.ic_uk);
        info.add(R.string.dato1);
        info.add(R.string.dato2);
        info.add(R.string.dato3);
        info.add(R.string.dato4);
        info.add(R.string.dato5);
        info.add(R.string.dato6);
        info.add(R.string.dato7);
        info.add(R.string.dato8);
        info.add(R.string.dato9);
        info.add(R.string.dato10);

        //Adaptador de ArrayList y llenandolo
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pais);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), img_paises.class);
                intent.putExtra("img_p", img.get(i));
                intent.putExtra("texto", info.get(i));
                startActivity(intent);

            }
        });


    }
}