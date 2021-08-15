package com.pdelacruz.appgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorGrid extends BaseAdapter {
    private Context context;
    private int referencia;
    private ArrayList<String> colores = new ArrayList<>();
    private ArrayList<Integer> codigoColores = new ArrayList<>();

    public AdaptadorGrid(Context context, int referencia, ArrayList<String> colores, ArrayList<Integer> codigoColores) {
        this.context = context;
        this.referencia = referencia;
        this.colores = colores;
        this.codigoColores = codigoColores;
    }

    @Override
    public int getCount() {
        return this.colores.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.grid_color, null);

        String nom;
        nom = this.codigoColores.get(position);

        int col;
        TextView colorNombre;
        colorNombre = v.findViewById(R.id.tvColor);
        colorNombre.setText(String.valueOf(nom));

        return null;
    }
}
