package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt_nombre, txt_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nombre = findViewById(R.id.txt_nombre);
        txt_datos =  findViewById(R.id.txt_direccion);
    }

    //Método para el botón guardar
    public void Guardar(View view){
        //Creamos variables y les almacenamos los datos que se escriben en los cuadros de texto
        String nombre = txt_nombre.getText().toString();
        String datos = txt_datos.getText().toString();

        //Creamos y abrimos el archivo donde se almacenarán los datos
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        //Pasamos el contenido a un objeto del tipo Editor para poder modificarlo
        SharedPreferences.Editor obj_editor = preferencias.edit();
        //Guardamos los datos almacenados en las variables en el editor
        obj_editor.putString(nombre, datos);
        //Actualizamos el archivo
        obj_editor.commit();

        Toast.makeText(this, "El contacto ha sido guardado", Toast.LENGTH_SHORT).show();
    }

    //Método para el botón buscar
    public void Buscar(View view){
        String nombre = txt_nombre.getText().toString();

        //Creamos y abrimos el archivo donde se almacenarán los datos
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        //Buscamos los datos del contacto por medio del nombre
        String datos = preferencias.getString(nombre, "");

        if(datos.length() == 0){
            Toast.makeText(this, "No se encontró el contacto", Toast.LENGTH_SHORT).show();
        }else{
            txt_datos.setText(datos);
        }

    }
}