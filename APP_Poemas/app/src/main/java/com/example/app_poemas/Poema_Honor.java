package com.example.app_poemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Poema_Honor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poema_honor);
    }

    public void salirH(View view) {

        if(view.getId()== R.id.btn_Honor){
            Intent intentoSH = new Intent(this, MainActivity.class);
            startActivity(intentoSH);

        }
    }
}