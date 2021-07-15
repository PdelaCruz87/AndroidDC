package com.example.app_paises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class img_paises extends AppCompatActivity {
    private ImageView img;
    private TextView tex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_paises);
        img = findViewById(R.id.imgpais);
        tex = findViewById(R.id.txtPoblación);
        this.recibirImagen();

    }

    private void recibirImagen() {

        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("img_p");
        int texto = bundle.getInt("texto");
        img.setImageResource(imagen);
        tex.setText(texto);
    }
}