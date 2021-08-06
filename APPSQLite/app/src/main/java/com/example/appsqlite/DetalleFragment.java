package com.example.appsqlite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetalleFragment extends Fragment {
    private String id, nombre, raza, color, edad;

    public DetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString("id");
            nombre = getArguments().getString("nombre");
            raza = getArguments().getString("raza");
            color = getArguments().getString("color");
            edad = getArguments().getString("edad");


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detalle, container, false);

        TextView textViewId, textViewNombre, textViewRaza, textViewColor, textViewEdad;

        textViewId = v.findViewById(R.id.idFragMasc);
        textViewNombre = v.findViewById(R.id.NomFragMasc);
        textViewRaza = v.findViewById(R.id.RazaFragMasc);
        textViewColor = v.findViewById(R.id.ColorFragMasc);
        textViewEdad = v.findViewById(R.id.EdadFragMasc);

        textViewId.setText(id);
        textViewNombre.setText(nombre);
        textViewRaza.setText(raza);
        textViewColor.setText(color);
        textViewEdad.setText(edad);
        return v;
    }
}
