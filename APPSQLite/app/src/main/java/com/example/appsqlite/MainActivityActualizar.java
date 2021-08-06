package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appsqlite.complemento.ConectorSQLit;
import com.example.appsqlite.complemento.ConstantesSQL;

import java.security.spec.ECField;

public class MainActivityActualizar extends AppCompatActivity {
    private EditText editTextBuscar, editTextNombre, editTextRaza,
            editTextColor, editTextEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar);

        editTextBuscar = findViewById(R.id.edtbuscarMascotaActualizar);
        editTextNombre = findViewById(R.id.edtNombreActualizar);
        editTextRaza = findViewById(R.id.edtRazaActualizar);
        editTextColor = findViewById(R.id.edtColorActualizar);
        editTextEdad = findViewById(R.id.edtEdadActualizar);
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnbuscarMascotaActualizar:
                this.consultarID();

                break;
            case R.id.btn_actualizarMascota:

                this.actualizarMascota();
                break;


        }

    }

    private void consultarID() {
        if (!editTextBuscar.getText().toString().isEmpty()) {
            ConectorSQLit conectorSQLit = new ConectorSQLit(this, ConstantesSQL.BD_Mascota, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLit.getReadableDatabase();
            String[] parametro = {editTextBuscar.getText().toString()};
            try {
                String consultarID;
                consultarID = "SELECT " + ConstantesSQL.CAMPO_Nombre + ", " + ConstantesSQL.CAMPO_Raza + ", "
                        + ConstantesSQL.CAMPO_Color + ", " + ConstantesSQL.CAMPO_Edad + " FROM " +
                        ConstantesSQL.TABLA_Mascota + " WHERE " + ConstantesSQL.CAMPO_ID + " = ?;";
                Cursor cursor = database.rawQuery(consultarID, parametro);
                cursor.moveToFirst();
                editTextNombre.setText(cursor.getString(0));
                editTextRaza.setText(cursor.getString(1));
                editTextColor.setText(cursor.getString(2));
                editTextEdad.setText(cursor.getString(3));
                cursor.close();
            } catch (Exception e) {
                e.getMessage();
                Toast.makeText(this, "Dato no encontrado", Toast.LENGTH_LONG).show();


            }
        } else {

            Toast.makeText(this, "Debe de ingresar el dato a buscar", Toast.LENGTH_LONG).show();
        }
    }

    private void actualizarMascota() {
        if (!editTextBuscar.getText().toString().isEmpty() && !editTextNombre.getText().toString().isEmpty() && !editTextRaza.getText().toString().isEmpty()
                && !editTextColor.getText().toString().isEmpty() && !editTextEdad.getText().toString().isEmpty()) {
            ConectorSQLit conectorSQLit = new ConectorSQLit(this, ConstantesSQL.BD_Mascota, null, ConstantesSQL.VERSION);
            SQLiteDatabase database = conectorSQLit.getWritableDatabase();
            try {

                String consultarActualizar;
                consultarActualizar = "UPDATE " + ConstantesSQL.TABLA_Mascota + " SET " +
                        ConstantesSQL.CAMPO_Nombre + "= '" + editTextNombre.getText().toString() + "', " +
                        ConstantesSQL.CAMPO_Raza + "= '" + editTextRaza.getText().toString() + "', " +
                        ConstantesSQL.CAMPO_Color + "= '" + editTextColor.getText().toString() + "', " +
                        ConstantesSQL.CAMPO_Edad + "= '" + editTextEdad.getText().toString() + "' WHERE " +
                        ConstantesSQL.CAMPO_ID + "= " + editTextBuscar.getText().toString() + "; ";

                database.execSQL(consultarActualizar);
                database.close();
                editTextBuscar.setText("");
                editTextNombre.setText("");
                editTextRaza.setText("");
                editTextColor.setText("");
                editTextEdad.setText("");
                Toast.makeText(this, "Datos actualizaddos correctamente", Toast.LENGTH_SHORT).show();


            } catch (Exception e) {
                e.getMessage();
            }

        } else {
            Toast.makeText(null, "Debe de llenar todos los datos", Toast.LENGTH_SHORT).show();
        }

    }
}