package com.example.app_recyclerview_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<DatosVO> listaVO = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.insertarDatos();

        AdaptadorRV adaptadorRV = new AdaptadorRV(listaVO);
        recyclerView.setAdapter(adaptadorRV);

    }

    public void insertarDatos() {
        listaVO.add(new DatosVO("Dely", "Buena", R.drawable.ic_burguer));
        listaVO.add(new DatosVO("Huehue", "Caliente", R.drawable.ic_coffee));
        listaVO.add(new DatosVO("Homero", "Chocolate que da gusto", R.drawable.ic_donut));
        listaVO.add(new DatosVO("Italy", "Como en casa", R.drawable.ic_pizza));
        listaVO.add(new DatosVO("Pastor", "Con todo", R.drawable.ic_taco));
    }

}