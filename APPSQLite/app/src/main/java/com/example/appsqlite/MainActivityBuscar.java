package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsqlite.complemento.ConectorSQLit;
import com.example.appsqlite.complemento.ConstantesSQL;

public class MainActivityBuscar extends AppCompatActivity {
    private EditText editTextID;
    private TextView textViewNombre, textViewRaza, textViewColor, textViewEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buscar);
        editTextID = findViewById(R.id.etbuscarMascota);
        textViewNombre = findViewById(R.id.txtNombreBuscar);
        textViewRaza = findViewById(R.id.txtRazaBuscar);
        textViewColor = findViewById(R.id.txtColorBuscar);
        textViewEdad = findViewById(R.id.txtEdadBuscar);

    }

    public void onClick(View view) {
    this.buscarMascota();
    }


    private void buscarMascota() {
        ConectorSQLit conectorSQLit = new ConectorSQLit(this, ConstantesSQL.BD_Mascota,
                null, ConstantesSQL.VERSION);
        SQLiteDatabase database = conectorSQLit.getReadableDatabase();

        String[] parametro = {editTextID.getText().toString()};
        if (!editTextID.getText().toString().isEmpty()) {
            try {


                //Consulta por ID
                String consultaID;
                consultaID = " SELECT " + ConstantesSQL.CAMPO_Nombre + ", " +
                        ConstantesSQL.CAMPO_Raza + ", " + ConstantesSQL.CAMPO_Color + ", " +
                        ConstantesSQL.CAMPO_Edad + " FROM " + ConstantesSQL.TABLA_Mascota +
                        " WHERE " + ConstantesSQL.CAMPO_ID + " = ?;";
                //Objeto que permite obtener datos de una consulta de base de datos
                Cursor cursor = database.rawQuery(consultaID, parametro);
                cursor.moveToFirst();
                textViewNombre.setText(cursor.getString(0));
                textViewRaza.setText(cursor.getString(1));
                textViewColor.setText(cursor.getString(2));
                textViewEdad.setText(cursor.getString(3));
                cursor.close();

            } catch (Exception e) {
                e.getMessage();
            }
        } else {
            Toast.makeText(this, "Debe de llenar el campo", Toast.LENGTH_LONG).show();
        }


    }

}