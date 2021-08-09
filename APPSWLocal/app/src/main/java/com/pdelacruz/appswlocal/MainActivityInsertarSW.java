package com.pdelacruz.appswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import Complementos.MetodosSW;

public class MainActivityInsertarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText editTextNombre, editTextFecha, editTextPrecio, editTextUbicacion;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar_sw);
        editTextNombre = findViewById(R.id.edtnombreProducto);
        editTextFecha = findViewById(R.id.edtfechaProducto);
        editTextPrecio = findViewById(R.id.edtprecioProducto);
        editTextUbicacion = findViewById(R.id.edtubicacionProducto);


    }

    public void onClick(View view) {
        this.insertar();

    }


    private void insertar() {

        if (!editTextNombre.getText().toString().isEmpty()
                && !editTextFecha.getText().toString().isEmpty()
                && !editTextPrecio.getText().toString().isEmpty()
                && !editTextUbicacion.getText().toString().isEmpty()) {
            //Utilizando el metodo respectivo de la clase MetodoSW

            metodosSW.insertarSW(this, editTextNombre.getText().toString(),
                    editTextFecha.getText().toString(),
                    Integer.parseInt(editTextPrecio.getText().toString()),
                    editTextUbicacion.getText().toString(), this, this);

            editTextNombre.setText("");
            editTextFecha.setText("");
            editTextPrecio.setText("");
            editTextUbicacion.setText("");

        } else {
            Toast.makeText(this, "Debe de llenar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a: " + error, Toast.LENGTH_SHORT).show();
        System.err.println("***** " + error);
    }


}