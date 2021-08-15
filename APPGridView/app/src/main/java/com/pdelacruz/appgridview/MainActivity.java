package com.pdelacruz.appgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    ArrayList<String> colores = new ArrayList<>();
    ArrayList<Integer> codigoColores = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gvPrincipal);


        colores.add("Indian Red #CD5C5C");
        colores.add("LihtCoral #F08080");
        colores.add("Salmón #FA8072");
        colores.add("Crimson #DC143C");
        colores.add("Red #FF0000");
        colores.add("Rosa #FFC0CB");
        colores.add("Deep Pink #FF1493");
        colores.add("Coral #FF7F50");
        colores.add("OrangeRed #FF4500");
        colores.add("Orange #FFA500");
        colores.add("Amarillo #FFFF00");
        colores.add("Moccasin #FFE4B5");
        colores.add("DarkKhaki #BDB76B");
        colores.add("Plum #DDA0DD");
        colores.add("Fucsia #FF00FF");

        codigoColores.add(R.color.Indian_Red);
        codigoColores.add(R.color.LihtCoral);
        codigoColores.add(R.color.Salmón);
        codigoColores.add(R.color.Crimson);
        codigoColores.add(R.color.Red);
        codigoColores.add(R.color.Rosa);
        codigoColores.add(R.color.Deep_Pink);
        codigoColores.add(R.color.Coral);
        codigoColores.add(R.color.Orange);
        codigoColores.add(R.color.Amarillo);
        codigoColores.add(R.color.Moccasin);
        codigoColores.add(R.color.DarkKhaki);
        codigoColores.add(R.color.Plum);
        codigoColores.add(R.color.Fucsia);


        /*ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, colores);
        gridView.setAdapter(adapter);*/

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }


        });
    }
}