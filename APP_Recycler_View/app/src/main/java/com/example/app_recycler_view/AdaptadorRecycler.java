package com.example.app_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    //Errores a solventar
    // 1 implementar la clase ViewHolder
    // 2 crear la clase ViewHolder
    // 3 Extender en la clase ViewHolder crear RecyclerView.ViewHolder
    // 4 Constructor de la clase

    private ArrayList<String> lista = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<String> lista) {
        this.lista = lista;
    }

    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null, false);
        ViewHolder viewHolder = new ViewHolder((v));


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
        holder.asignarDatos(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtTexto);
        }

        public void asignarDatos(String datos) {
            textView.setText(datos);
        }

    }
}
