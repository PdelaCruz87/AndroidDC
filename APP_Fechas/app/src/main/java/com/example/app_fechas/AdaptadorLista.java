package com.example.app_fechas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {

    private Context context;
    private int referenciaLista;
    private ArrayList<String> dato = new ArrayList<>();

    public AdaptadorLista(Context context, int referenciaLista, ArrayList<String> dato) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.dato = dato;
    }

    @Override

    public int getCount() {
        return this.dato.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.lista_personalizada, null);

        String mes;
        mes = this.dato.get(i);
        TextView campo;
        campo = v.findViewById(R.id.txtLista);
        campo.setText(String.valueOf(mes));
        return v;
    }
}
