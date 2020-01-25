package com.example.imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MensajeBoton1(View view){
        Toast.makeText(this, "La Geekipedia", Toast.LENGTH_SHORT).show();
    }
    public void MensajeBoton2(View view){
        Toast.makeText(this, "Esto es una mano", Toast.LENGTH_SHORT).show();
    }

}
