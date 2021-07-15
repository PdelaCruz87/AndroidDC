package com.example.app_poemas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

private void Amor(){
    Intent intentoA = new Intent(this, Poema_Amor.class);
    startActivity(intentoA);
    }
private void Honor(){
    Intent intentoH = new Intent(this, Poema_Honor.class);
    startActivity(intentoH);
}
private void Lealtad(){
        Intent intentoL = new Intent(this, Poema_Lealtad.class);
        startActivity(intentoL);

}

    public void Poema(View view) {
        if(view.getId()==R.id.btn_Amor){
            this.Amor();
        }
        if(view.getId()==R.id.btn_Honor){
            this.Honor();
        }
        if(view.getId()==R.id.btn_Lealtad){
            this.Lealtad();
        }



    }
}