package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etn, etp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn = findViewById(R.id.txt_nombre);
        etp = findViewById(R.id.contraseña);
    }
    public void Registrar(View view){
        String nombre = etn.getText().toString();
        String password = etp.getText().toString();

        if(nombre.length() == 0){
            Toast.makeText(this, "Ingresa un nombre", Toast.LENGTH_SHORT).show();
        }
        if(password.length() == 0){
            Toast.makeText(this, "Ingresa una contraseña", Toast.LENGTH_SHORT).show();
        }
        if(nombre.length() != 0 && password.length() != 0 ){
            Toast.makeText(this, "Registro en proceso...", Toast.LENGTH_SHORT).show();
        }
    }
}
