package com.example.appswlocalhost;

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

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnInsertarSW:
                intent = new Intent(getApplicationContext(), MainActivityInsertarSW.class);
                startActivity(intent);
                break;


        }


    }
}