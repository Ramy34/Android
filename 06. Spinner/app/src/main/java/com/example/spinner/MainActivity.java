package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_valor1);
        et2 = findViewById(R.id.txt_valor2);
        tv1 = findViewById(R.id.tv_mensaje);
        spinner1 = findViewById(R.id.spinner);

        String [] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_prueba, opciones);
        spinner1.setAdapter(adapter);
    }

    public void operar(View view){
        String operando1_String = et1.getText().toString();
        String operando2_String = et2.getText().toString();
        String resultado = "";

        if(operando1_String.isEmpty() || operando2_String.isEmpty()){
            Toast.makeText(this, "Debes de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            int operando1_int = Integer.parseInt(operando1_String);
            int operando2_int = Integer.parseInt(operando2_String);
            int resultado_int = 0;

            String seleccion = spinner1.getSelectedItem().toString();

            switch (seleccion){
                case "Sumar":
                    resultado_int = operando1_int + operando2_int;
                    break;
                case "Restar":
                    resultado_int = operando1_int - operando2_int;
                    break;
                case "Multiplicar":
                    resultado_int = operando1_int * operando2_int;
                    break;
                case "Dividir":
                    if(operando2_int != 0){
                        resultado_int = operando1_int / operando2_int;
                    }else{
                        Toast.makeText(this, "El segundo valor no puede ser 0", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
            resultado = String.valueOf(resultado_int);
            tv1.setText(resultado);
        }
    }
}
