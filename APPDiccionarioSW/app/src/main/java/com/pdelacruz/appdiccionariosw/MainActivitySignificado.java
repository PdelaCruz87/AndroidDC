package com.pdelacruz.appdiccionariosw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.ArrayList;

import Complementos.DiccionarioVO;
import Complementos.MetodosSW;

public class MainActivitySignificado extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    ListView listView;
    ArrayList<String> listaPalabras;
    ArrayList<DiccionarioVO> listaDiccionarioVO;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_significado);
    listView = findViewById(R.id.lvlistadoDefinicion);

    }






    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }


}