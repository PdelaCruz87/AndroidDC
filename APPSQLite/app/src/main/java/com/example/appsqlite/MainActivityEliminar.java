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

public class MainActivityEliminar extends AppCompatActivity {
    private EditText editText;
    private TextView textViewNombre, textViewRaza, textViewColor, textViewEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eliminar);

        editText = findViewById(R.id.edtbuscarMascotaEliminar);
        textViewNombre = findViewById(R.id.edtNombreEliminar);
        textViewRaza = findViewById(R.id.edtRazaEliminar);
        textViewColor = findViewById(R.id.edtColorEliminar);
        textViewEdad = findViewById(R.id.edtEdadEliminar);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnbuscarMascotaEliminar:
                this.consultarID();
                break;
            case R.id.btn_eliminarMascota:
                this.eliminarMascota();
                break;
        }


    }


    private void consultarID() {
        if (!editText.getText().toString().isEmpty()) {
            ConectorSQLit conectorSQLit = new ConectorSQLit(this, ConstantesSQL.BD_Mascota, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLit.getReadableDatabase();
            String[] parametro = {editText.getText().toString()};
            try {

                String consultarID;
                consultarID = "SELECT " + ConstantesSQL.CAMPO_Nombre + ", " +
                        ConstantesSQL.CAMPO_Raza + ", " +
                        ConstantesSQL.CAMPO_Color + ", " +
                        ConstantesSQL.CAMPO_Edad + " FROM " + ConstantesSQL.TABLA_Mascota + " WHERE " +
                        ConstantesSQL.CAMPO_ID + "= ?;";

                Cursor cursor = database.rawQuery(consultarID, parametro);
                cursor.moveToFirst();
                textViewNombre.setText(cursor.getString(0));
                textViewRaza.setText(cursor.getString(1));
                textViewColor.setText(cursor.getString(2));
                textViewEdad.setText(cursor.getString(3));
                cursor.close();


            } catch (Exception e) {
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
        }
    }

    private void eliminarMascota() {
        if (!editText.getText().toString().isEmpty()) {
            ConectorSQLit conectorSQLite = new ConectorSQLit(this, ConstantesSQL.BD_Mascota, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLite.getWritableDatabase();
            try {
                String consultaEliminar;
                consultaEliminar = "DELETE FROM " + ConstantesSQL.TABLA_Mascota +
                        " WHERE " + ConstantesSQL.CAMPO_ID + "= " + editText.getText().toString() + ";";
                database.execSQL(consultaEliminar);
                database.close();
                editText.setText("");
                textViewNombre.setText("");
                textViewRaza.setText("");
                textViewColor.setText("");
                textViewEdad.setText("");
                Toast.makeText(this, "Datos Eliminados Correctamente", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debe de llenar el dato a buscar", Toast.LENGTH_SHORT).show();
        }
    }

}

