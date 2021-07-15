package com.example.app_actividadcomplementaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSumar(View view) {

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }

    public void onDiv(View view) {
        Intent intentd = new Intent(this, MainDiv.class);
        startActivity(intentd);
    }

    public void onMulti(View view) {
        Intent intentm = new Intent(this, MainMulti.class);
        startActivity(intentm);
    }

    public void onRestar(View view) {
        Intent intentr = new Intent(this, MainResta.class);
        startActivity(intentr);
    }
}