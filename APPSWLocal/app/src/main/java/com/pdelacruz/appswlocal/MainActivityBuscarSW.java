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

public class MainActivityBuscarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText editText;
    TextView textViewNombre, textViewFecha, textViewPrecio, textViewUbicacion;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buscar_sw);
        editText = findViewById(R.id.edtidProducto);
        textViewNombre = findViewById(R.id.tvnombreBuscarP);
        textViewFecha = findViewById(R.id.tvfechaBuscarP);
        textViewPrecio = findViewById(R.id.tvprecioBuscarP);
        textViewUbicacion = findViewById(R.id.tvubicacionBuscarP);

    }


    public void onClick(View view) {
        this.buscarID();
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
            jsonObject= jsonArray.getJSONObject(0);
            productoVO.setNombreProducto(jsonObject.optString("nombre_producto"));
            productoVO.setFechaPproducto(jsonObject.optString("fecha_producto"));
            productoVO.setPrecioProducto(jsonObject.optInt("precio_producto"));
            productoVO.setUbicacionProducto(jsonObject.optString("ubicacion_producto"));

            textViewNombre.setText(productoVO.getNombreProducto());
            textViewFecha.setText(productoVO.getFechaPproducto());
            textViewPrecio.setText(String.valueOf(productoVO.getPrecioProducto()));
            textViewUbicacion.setText(productoVO.getUbicacionProducto());

        } catch (Exception e) {
            Toast.makeText(this, "Error referente a B: ", Toast.LENGTH_SHORT).show();
            System.err.println("B****** " + e.getCause() + "----" + e.getMessage());

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
