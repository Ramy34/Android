package com.example.miapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText matematicas;
    private EditText fisica;
    private EditText quimica;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matematicas = (EditText)findViewById(R.id.txt_matematicas);
        fisica = (EditText)findViewById(R.id.txt_fisica);
        quimica = (EditText)findViewById(R.id.txt_quimica);
        tv1 = (TextView)findViewById(R.id.tv_mensaje);
    }

    public void promedio(View view){
        String matematicas_String = matematicas.getText().toString();
        String fisica_String = fisica.getText().toString();
        String quimica_String = quimica.getText().toString();

        int matematicas_int = Integer.parseInt(matematicas_String);
        int fisica_int = Integer.parseInt(fisica_String);
        int quimica_int = Integer.parseInt(quimica_String);

        int promedio = (matematicas_int + fisica_int + quimica_int)/3;

        if(promedio >= 6) {
            tv1.setText("El alumno está aprobado con: " + promedio + " de calificación");
        }else{
            tv1.setText("El alumno está reprobado con: " + promedio + " de calificación");
        }
    }
}
