package com.example.sd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    private EditText nameFile, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameFile = findViewById(R.id.nameFile);
        mensaje = findViewById(R.id.mensaje);
    }

    public void Guardar(View view){
        String nombre = nameFile.getText().toString();
        String contenido = mensaje.getText().toString();
        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this, tarjetaSD.getPath(), Toast.LENGTH_SHORT).show();
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE));
            crearArchivo.write(contenido);
            crearArchivo.flush();
            crearArchivo.close();
            Toast.makeText(this, "Guardado correctamente", Toast.LENGTH_SHORT).show();
            nameFile.setText("");
            mensaje.setText("");
        }catch (IOException e){
            Toast.makeText(this, "Error, no se pudo guardar.", Toast.LENGTH_SHORT).show();
        }
    }

    public void Buscar(View view){
        String nombre = nameFile.getText().toString();
        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));
            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
            String linea = leerArchivo.readLine();
            String contenido = "";
            while(linea != null){
                contenido = contenido + linea + "\n";
                linea = leerArchivo.readLine();
            }
            leerArchivo.close();
            abrirArchivo.close();
            mensaje.setText(contenido);
            Toast.makeText(this, "Archivo recuperado", Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Toast.makeText(this, "Error, no se pudo leer el archivo..", Toast.LENGTH_SHORT).show();
        }

    }

}
