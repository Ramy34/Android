package com.example.parametros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_nombre);
    }
    public void Enviar(View view){

        String nombre = et1.getText().toString();

        if(nombre.isEmpty()){
            Toast.makeText(this, "Ingresa un nombre", Toast.LENGTH_SHORT).show();
        }else{
            Intent enviar = new Intent(this, Main2Activity.class);
            enviar.putExtra("dato", et1.getText().toString());
            startActivity(enviar);
        }
    }
}
