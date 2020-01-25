package com.example.practica_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv1;
    private RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_operando1);
        et2 = findViewById(R.id.txt_operando2);
        tv1 = findViewById(R.id.txt_mensaje);
        rb1 = findViewById(R.id.rb_suma);
        rb2 = findViewById(R.id.rb_resta);
        rb3 = findViewById(R.id.rb_multiplicacion);
        rb4 = findViewById(R.id.rb_division);
    }

    public void calcular(View view){
        String operando1_String = et1.getText().toString();
        String operando2_String = et2.getText().toString();

        if(operando1_String.isEmpty() || operando2_String.isEmpty()){
            Toast.makeText(this, "Debes de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            int operando1_int = Integer.parseInt(operando1_String);
            int operando2_int = Integer.parseInt(operando2_String);
            int resultado_int = 0;

            if(rb1.isChecked()){ //Suma
                resultado_int = operando1_int + operando2_int;
            }else if(rb2.isChecked()){ //Resta
                resultado_int = operando1_int - operando2_int;
            } else if(rb3.isChecked()){ //Multiplicación
                resultado_int = operando1_int * operando2_int;
            } else if(rb4.isChecked()) { //División
                if(operando2_int != 0){
                    resultado_int = operando1_int / operando2_int;
                }else{
                    Toast.makeText(this, "El segundo valor no puede ser 0", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Selecciona una opción", Toast.LENGTH_SHORT).show();
            }
            String resultado = String.valueOf(resultado_int);
            tv1.setText(resultado);
        }
    }
}
