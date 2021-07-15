package com.example.app_gui_telefono;

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
        recyclerView = findViewById(R.id.recyclerID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.llenarDatos();
        Adaptador_RV adaptador_rv = new Adaptador_RV(listaVO);
        recyclerView.setAdapter(adaptador_rv);


    }

    public void llenarDatos() {
        listaVO.add(new DatosVO("Juan López", "34562", R.drawable.ic_persona));
        listaVO.add(new DatosVO("Alma Pérez", "345699", R.drawable.ic_persona1));
        listaVO.add(new DatosVO("Hipòlito Chacaj", "34596", R.drawable.ic_persona2));
        listaVO.add(new DatosVO("Alma Castillo", "34568", R.drawable.ic_persona3));
        listaVO.add(new DatosVO("Tulio Sánchez", "34569", R.drawable.ic_persona4));
        listaVO.add(new DatosVO("Pablo Sánchez", "34564", R.drawable.ic_persona5));
        listaVO.add(new DatosVO("Raque de la Cruz", "34356", R.drawable.ic_persona6));
        listaVO.add(new DatosVO("Bernarda Silva", "323456", R.drawable.ic_persona7));
        listaVO.add(new DatosVO("Grecia Mèrida", "345226", R.drawable.ic_persona8));
        listaVO.add(new DatosVO("Manuel Méreida", "345622", R.drawable.ic_persona9));


    }
}