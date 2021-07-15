package com.example.app_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    ArrayList<String> nombres = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gv_principal);
        nombres.add("Toyota");
        nombres.add("Datsun");
        nombres.add("BMW");
        nombres.add("Hyundai");
        nombres.add("Ford");
        nombres.add("KIA");
        nombres.add("Jaguar");
        nombres.add("Peugeot");
        nombres.add("Ferrari");
        nombres.add("Mahindra");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nombres);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "A pulsado " + nombres.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
