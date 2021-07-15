package com.example.app_poemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Poema_Lealtad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poema_lealtad);
    }

    public void sLealtad(View view) {
        if(view.getId()== R.id.btn_SalirL){
            Intent intentoSL = new Intent(this, MainActivity.class);
            startActivity(intentoSL);

        }
    }
}