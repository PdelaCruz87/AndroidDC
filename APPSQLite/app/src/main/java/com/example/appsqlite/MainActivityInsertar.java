package com.example.appsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appsqlite.complemento.ConectorSQLit;
import com.example.appsqlite.complemento.ConstantesSQL;

public class MainActivityInsertar extends AppCompatActivity {
    private EditText editTextNombre, editTextRaza, editTextColor, editTextEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar);
        editTextNombre = findViewById(R.id.edtNombreMascota);
        editTextColor = findViewById(R.id.edtColorMascota);
        editTextRaza = findViewById(R.id.edtRazaMascota);
        editTextEdad = findViewById(R.id.edtEdadMascota);

    }

    public void onClick(View view) {
        this.insertarMascota();
    }

    private void insertarMascota() {
        if (!editTextNombre.getText().toString().isEmpty() &&
                !editTextRaza.getText().toString().isEmpty() &&
                !editTextColor.getText().toString().isEmpty() &&
                !editTextEdad.getText().toString().isEmpty()) {
            //Realizando la conexión a base de datos por medio del conector
            ConectorSQLit ConectorSQLit = new ConectorSQLit(this, ConstantesSQL.BD_Mascota,
                    null, ConstantesSQL.VERSION);
            //Realizar el objet de base de datos para establecer lo que se va a realizar a cntinuación
            SQLiteDatabase database = ConectorSQLit.getWritableDatabase();
            //Creacion del query para la inserción de los datos

            try {
                String consultaInsertar;
                consultaInsertar = "INSERT INTO " + ConstantesSQL.TABLA_Mascota +
                        " (" + ConstantesSQL.CAMPO_Nombre + ", " + ConstantesSQL.CAMPO_Raza +
                        ", " + ConstantesSQL.CAMPO_Color + ", "
                        + ConstantesSQL.CAMPO_Edad + ") VALUES ('"
                        + editTextNombre.getText().toString()
                        + "', '" + editTextRaza.getText().toString() + "', '"
                        + editTextColor.getText().toString()
                        + "', '" + editTextEdad.getText().toString() + "');";
                //Acción de consulta
                database.execSQL(consultaInsertar);
                database.close();
                editTextNombre.setText("");
                editTextRaza.setText("");
                editTextColor.setText("");
                editTextEdad.setText("");
                Toast.makeText(this, "Datos Insertados Correctamente", Toast.LENGTH_LONG).show();
            } catch (Exception e) {

                e.getMessage();
            }

        } else {
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
        }

    }
}