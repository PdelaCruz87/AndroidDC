package com.example.app_fragment_static;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class F_Button extends Fragment {


    public F_Button() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_f__button, container, false);
        Button button;
        button = v.findViewById(R.id.btnEnviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dato = "Guatemala";
                TextView textView;
                textView = getActivity().findViewById(R.id.txtMostrar);
                textView.setText(dato);
            }
        });
        return v;
    }
}