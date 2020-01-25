package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Creamos variables para modificar y almacenar los textos a utilizar
    private EditText et1;
    private EditText et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hacemos la comunicación entre la parte lógica y la gráfica
        et1 = (EditText)findViewById(R.id.txt_num1);
        et2 = (EditText)findViewById(R.id.txt_num2);
        tv1 = (TextView) findViewById(R.id.txt_resultado);
    }
    //Este método realiza la suma
    public void Suma(View view){
        //Almacenamos los valores que tenemos en las cajas de texto numerico y los pasamos a String
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        //Creamos las variables para realizar la suma y les pasamos los valores anteriores
        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);

        //Realizamos la suma
        int suma = num1 + num2;

        //Almacenamos el resultado de la suma en una variable String
        String result =  String.valueOf(suma);

        //Modificamos el valor de tv1 por el resultado de la suma
        tv1.setText(result);
    }
}