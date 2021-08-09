package com.pdelacruz.appswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import Complementos.MetodosSW;
import Complementos.ProductoVO;

public class MainActivityActualizarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    EditText editText, editTextNombre, editTextFecha, editTextPrecio, editTextUbicacion;

    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar_sw);
        editText = findViewById(R.id.edtidactualizarProducto);
        editTextNombre = findViewById(R.id.edtactualizarnombreP);
        editTextFecha = findViewById(R.id.edtactualizarfechaP);
        editTextPrecio = findViewById(R.id.edtactualizarprecioP);
        editTextUbicacion = findViewById(R.id.edtactualizarubicacionP);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnactualizarProducto:
                this.actualizar();
                break;
            case R.id.btnbuscarActualizar:
                this.buscarID();
                break;
        }
    }

    private void buscarID() {

        if (!editText.toString().isEmpty()) {
            metodosSW.buscarIDSW(this, Integer.parseInt(editText.getText().toString()), this, this);

        } else {
            Toast.makeText(this, "Debe de llenar el campo: ", Toast.LENGTH_LONG).show();
        }
    }

    private void resultadoConsulta(JSONObject response) {
        ProductoVO productoVO = new ProductoVO();
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        try {
            JSONObject jsonObject = null;
            jsonObject = jsonArray.getJSONObject(0);
            productoVO.setNombreProducto(jsonObject.optString("nombre_producto"));
            productoVO.setFechaPproducto(jsonObject.optString("fecha_producto"));
            productoVO.setPrecioProducto(jsonObject.optInt("precio_producto"));
            productoVO.setUbicacionProducto(jsonObject.optString("ubicacion_producto"));

            editTextNombre.setText(productoVO.getNombreProducto());
            editTextFecha.setText(productoVO.getFechaPproducto());
            editTextPrecio.setText(String.valueOf(productoVO.getPrecioProducto()));
            editTextUbicacion.setText(productoVO.getUbicacionProducto());

        } catch (Exception e) {
            Toast.makeText(this, "Error referente a B: ", Toast.LENGTH_SHORT).show();
            System.err.println("B****** " + e.getCause() + "----" + e.getMessage());

        }
    }


    private void actualizar() {
        if (!editText.getText().toString().isEmpty()
                && !editTextNombre.getText().toString().isEmpty()
                && !editTextFecha.getText().toString().isEmpty()
                && !editTextPrecio.getText().toString().isEmpty()
                && !editTextUbicacion.getText().toString().isEmpty()) {
            metodosSW.actualizarSW(this, Integer.parseInt(editText.getText().toString()),
                    editTextNombre.getText().toString(),
                    editTextFecha.getText().toString(),
                    Integer.parseInt(editTextPrecio.getText().toString()),
                    editTextUbicacion.getText().toString(), this, this);
            Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "Llenar todos los datos", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsulta(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error respuesta a B: " + error, Toast.LENGTH_SHORT).show();
        System.err.println("B***** " + error);
    }


}