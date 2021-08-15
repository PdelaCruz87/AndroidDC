package com.pdelacruz.appdiccionariosw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import Complementos.DiccionarioVO;
import Complementos.MetodosSW;


public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    ListView listView;
    ArrayList<String> listaDatos;
    ArrayList<DiccionarioVO> listaDiccionarioVO;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lvlistadoPalabra);

        metodosSW.consultarSW(this, this, this);




    }
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.btnlistado:
            this.resultaConsultaPalabra().;
            break;
    }
    }
    private void resultaConsultaPalabra(JSONObject response) {
        DiccionarioVO diccionarioVO;
        JSONArray jsonArray = response.optJSONArray("tbl_diccionario");
        listaDiccionarioVO = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                diccionarioVO = new DiccionarioVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                diccionarioVO.setId_diccionario(jsonObject.optInt("id_diccionario"));
                diccionarioVO.setPalabra_diccionario(jsonObject.optString("palabra_diccionario"));
                diccionarioVO.setSignificado_diccionario(jsonObject.optString("significado_diccionario"));
                listaDiccionarioVO.add(diccionarioVO);
            }
            listaDatos = new ArrayList<>();
            for (int i = 0; i < listaDiccionarioVO.size(); i++) {

                listaDatos.add(listaDiccionarioVO.get(i).getPalabra_diccionario());
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

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error respuesta a M: " + error, Toast.LENGTH_SHORT).show();
        System.err.println("M***** " + error);
    }



}