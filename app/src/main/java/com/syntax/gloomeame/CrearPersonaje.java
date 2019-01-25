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
    Log log;
    EditText editNombre;
    Spinner jobSpinner;
    Button botonCrear;
    String cuchillera = "Cuchillera";
    String tanque = "Tanque";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personaje);

        //Inicializa un nuevo personaje
        final Personaje personaje = new Personaje();

        //designacion de vistas
        editNombre = findViewById(R.id.nombre);
        jobSpinner = findViewById(R.id.spinner_job);
        botonCrear = findViewById(R.id.boton_crear);

        //Lista de profesiones para el spinner
        ArrayList<String> profesiones = new ArrayList<>();
        profesiones.add(cuchillera);
        profesiones.add(tanque);


        //genera Spinner con todas las profesiones disponibles.
        jobSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, profesiones));
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

        //Ingresa todos los datos obtenidos al nuevo personaje.
        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personaje.setName(editNombre.getText().toString());


                //Asigna la clase del personaje segun la posicion del spinner.
                if (jobSpinner.getSelectedItem() == tanque) {
                    personaje.setJobClass(tanque);
                } else {
                    personaje.setJobClass(cuchillera);
                }

                //Log para ver que esta creando al final de todoo.
                Log.v("Character:  ", " Name: " + personaje.getName() + " job: " + personaje.getJobClass());
            }
        });
    }
}
