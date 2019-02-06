package com.syntax.gloomeame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearPersonaje extends AppCompatActivity {

    EditText editNombre;
    Spinner jobSpinner;
    Spinner nivelSpinner;
    Spinner hpSpinner;
    Spinner goldSpinner;
    Button botonCrear;

    //
    ListasParaSpinners listaSpinners = new ListasParaSpinners();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personaje);

        //Inicializa un nuevo personaje
        final Personaje personaje = new Personaje();

        //designacion de vistas
        editNombre = findViewById(R.id.nombre);
        jobSpinner = findViewById(R.id.spinner_job);
        nivelSpinner = findViewById(R.id.level_spinner);
        hpSpinner = findViewById(R.id.hp_spinner);
        goldSpinner = findViewById(R.id.gold_spinner);
        botonCrear = findViewById(R.id.boton_crear);

        //Lista de profesiones para el spinner
        ArrayList<String> profesiones = new ArrayList<>();
        profesiones.add(listaSpinners.cuchillera);
        profesiones.add(listaSpinners.tanque);

        //Lista de niveles
        int[] nivel = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> niveles = new ArrayList<>();
        for (int n : nivel) {
            niveles.add(n);
        }

        //lista de hp

        int hp = 7;
        ArrayList<Integer> maxhp = new ArrayList<>();
        while (hp < 21){
            maxhp.add(hp);
            hp  = hp + 1;
        }


        //genera Spinner con todas las profesiones disponibles.

        jobSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, profesiones));
        jobSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String texto = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "" + texto + " seleccionade", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //genera Spinner para asignar nivel del personaje

        nivelSpinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, niveles));

        hpSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, maxhp));


        //Ingresa todos los datos obtenidos al nuevo personaje.
        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personaje.setName(editNombre.getText().toString());


                //Asigna la clase del personaje segun la posicion del spinner.
                if (jobSpinner.getSelectedItem() == listaSpinners.tanque) {
                    personaje.setJobClass(listaSpinners.tanque);
                } else {
                    personaje.setJobClass(listaSpinners.cuchillera);
                }

                //Asigna nivel
                personaje.setLevel((Integer) nivelSpinner.getSelectedItem());


                //Log para ver que esta creando al final de todoo.
                Log.v("Character:  ", " Name: " + personaje.getName() + " job: " + personaje.getJobClass()+
                " level: "+ personaje.getLevel());
            }
        });
    }
}
