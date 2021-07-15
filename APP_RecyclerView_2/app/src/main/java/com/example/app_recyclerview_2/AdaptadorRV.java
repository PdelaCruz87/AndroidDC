package com.example.app_recyclerview_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRV extends RecyclerView.Adapter<AdaptadorRV.ViewHolder> {

    ArrayList<DatosVO> listaDatos = new ArrayList<>();

    public AdaptadorRV(ArrayList<DatosVO> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @Override
    public AdaptadorRV.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null, false);
        ViewHolder vH = new ViewHolder(v);
        return vH;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRV.ViewHolder holder, int position) {
        holder.asignarDatos(listaDatos.get(position).getNombreR(),
                listaDatos.get(position).getCalidadR(),
                listaDatos.get(position).getImagenR());
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewN, textViewC;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewN = itemView.findViewById(R.id.txtnombreR);
            textViewC = itemView.findViewById(R.id.txtcalidadR);
            imageView = itemView.findViewById(R.id.imgRest);
        }

        public void asignarDatos(String nom, String cali, int img) {
            textViewN.setText(nom);
            textViewC.setText(cali);
            imageView.setImageResource(img);


        }
    }
}
