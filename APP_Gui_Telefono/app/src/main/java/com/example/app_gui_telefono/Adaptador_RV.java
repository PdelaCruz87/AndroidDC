package com.example.app_gui_telefono;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador_RV extends RecyclerView.Adapter<Adaptador_RV.ViewHolder> {
    ArrayList<DatosVO> listaDatos = new ArrayList<>();

    public Adaptador_RV(ArrayList<DatosVO> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @Override
    public Adaptador_RV.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_gt, null, false);
        ViewHolder vH = new ViewHolder(v);
        return vH;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador_RV.ViewHolder holder, int position) {
        holder.asignarDatos(listaDatos.get(position).getNombre(),
                listaDatos.get(position).getNumT(),
                listaDatos.get(position).getImaNom());
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre, textViewNum;
        ImageView imagePersona;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre= itemView.findViewById(R.id.txtNombre);
            textViewNum= itemView.findViewById(R.id.txtNT);
            imagePersona= itemView.findViewById(R.id.imgPersona);
        }
        public void asignarDatos(String nom, String numT, int img){
            textViewNombre.setText(nom);
            textViewNum.setText(numT);
            imagePersona.setImageResource(img);

        }
    }
}
