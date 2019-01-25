package com.syntax.gloomeame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView BotonCrearPersonaje;
    TextView BotonCargarPersonaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BotonCrearPersonaje = findViewById(R.id.crear_nuevo_personaje);
        BotonCrearPersonaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CrearPersonaje.class);
                startActivity(intent);
            }
        });


    }
}
