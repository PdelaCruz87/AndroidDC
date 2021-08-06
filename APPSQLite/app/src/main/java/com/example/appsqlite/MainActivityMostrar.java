package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appsqlite.complemento.ConectorSQLit;
import com.example.appsqlite.complemento.ConstantesSQL;
import com.example.appsqlite.complemento.MascotaVO;

import java.util.ArrayList;

public class MainActivityMostrar extends AppCompatActivity {
    private ListView listView;
    //Arreglos para llenar la lista y obtener datos
    ArrayList<String> listaDatos;

    ArrayList<MascotaVO> listaMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar);
        listView = findViewById(R.id.listaMostrar);
        this.mostrarMascota();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladoInformacion(position);
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
        listView.setAdapter(arrayAdapter);


    }

    private void mostrarMascota() {
        ConectorSQLit conectorSQLit = new ConectorSQLit(this, ConstantesSQL.BD_Mascota, null, ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLit.getReadableDatabase();
        try {
            MascotaVO mascotaVO;
            listaMascota = new ArrayList<>();
            String consultaCompleta;
            consultaCompleta = "SELECT * FROM " + ConstantesSQL.TABLA_Mascota + ";";
            Cursor cursor = database.rawQuery(consultaCompleta, null);
            //Llenando variables
            while (cursor.moveToNext()) {
                mascotaVO = new MascotaVO();
                mascotaVO.setId(cursor.getInt(0));
                mascotaVO.setNombre(cursor.getString(1));
                mascotaVO.setRaza(cursor.getString(2));
                mascotaVO.setColor(cursor.getString(3));
                mascotaVO.setEdad(cursor.getString(4));
                listaMascota.add(mascotaVO);

            }
            listaDatos = new ArrayList<>();
            for (int i = 0; i < listaMascota.size(); i++) {
                listaDatos.add(listaMascota.get(i).getId() + " . " + listaMascota.get(i).getNombre());


            }

        } catch (Exception e) {
            e.getMessage();
        }

    }

    private void trasladoInformacion(int position) {

        String idM, nombreM, razaM, colorM, edadM;
        idM = String.valueOf(listaMascota.get(position).getId());
        nombreM = listaMascota.get(position).getNombre();
        razaM = listaMascota.get(position).getRaza();
        colorM = listaMascota.get(position).getColor();
        edadM = listaMascota.get(position).getEdad();

        Intent intent = new Intent(getApplicationContext(), MainActivityDetalle.class);

        intent.putExtra("id", idM);
        intent.putExtra("nombre", nombreM);
        intent.putExtra("raza", razaM);
        intent.putExtra("color", colorM);
        intent.putExtra("edad", edadM);
        startActivity(intent);
    }
}