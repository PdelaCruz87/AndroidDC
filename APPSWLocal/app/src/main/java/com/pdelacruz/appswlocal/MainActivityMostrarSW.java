package com.pdelacruz.appswlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import Complementos.MetodosSW;
import Complementos.ProductoVO;

public class MainActivityMostrarSW extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    ListView listView;
    ArrayList<String> listaDatos;
    ArrayList<ProductoVO> listaProductoVO;
    MetodosSW metodosSW = new MetodosSW();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar_sw);
        listView = findViewById(R.id.lvListaProducto);
        metodosSW.consultarSW(this, this, this);

    }

    private void resultadoConsultaCompleta(JSONObject response) {
        ProductoVO productoVO;
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        listaProductoVO = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                productoVO = new ProductoVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                productoVO.setIdProducto(jsonObject.optInt("id_producto"));
                productoVO.setNombreProducto(jsonObject.optString("nombre_producto"));
                productoVO.setFechaPproducto(jsonObject.optString("fecha_producto"));
                productoVO.setPrecioProducto(jsonObject.optInt("precio_producto"));
                productoVO.setUbicacionProducto(jsonObject.optString("ubicacion_producto"));

                listaProductoVO.add(productoVO);
            }
            listaDatos = new ArrayList<>();
            for (int i = 0; i < listaProductoVO.size(); i++) {

                listaDatos.add(listaProductoVO.get(i).getIdProducto() + ". " +
                        listaProductoVO.get(i).getNombreProducto());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatos);
            listView.setAdapter(arrayAdapter);
        } catch (Exception e) {

            Toast.makeText(this, "Error referente a C", Toast.LENGTH_LONG).show();
            System.err.println("C---- " + e.getCause() + " --- " + e.getMessage());
        }


    }

    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsultaCompleta(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error respuesta a M: " + error, Toast.LENGTH_SHORT).show();
        System.err.println("M***** " + error);
    }

}