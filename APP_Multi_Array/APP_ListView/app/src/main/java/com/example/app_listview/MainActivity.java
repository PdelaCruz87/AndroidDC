package com.example.app_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    ArrayList<String> vocales = new ArrayList<>();
    private ArrayList<Integer> img = new ArrayList<>(); //Este se representa como un entero las imágenes
    ArrayList<Integer> info = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lv_Lista);

        //Llenado del ArrayList
        vocales.add("A");
        vocales.add("E");
        vocales.add("I");
        vocales.add("O");
        vocales.add("U");

        info.add(R.string.dato1);
        info.add(R.string.dato2);
        info.add(R.string.dato3);
        info.add(R.string.dato4);
        info.add(R.string.dato5);
        //Declarando las imágenes
        img.add(R.drawable.ic_a);
        img.add(R.drawable.ic_e);
        img.add(R.drawable.ic_i);
        img.add(R.drawable.ic_o);
        img.add(R.drawable.ic_u);


//Declarando el adaptador del Arraylist y su llenado
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vocales);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), activity_ima_vocales.class);
                intent.putExtra("imagen", img.get(i));
                intent.putExtra("texto", info.get(i));
                startActivity(intent);


            }
        }); //Escuchador del ListView y se debe de sobreescribir


    }
}