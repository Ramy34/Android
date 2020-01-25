package com.example.practica_checkbox;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private CheckBox cb1, cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_valor1);
        et2 = findViewById(R.id.txt_valor2);
        tv1 = findViewById(R.id.tv_mensaje);
        cb1 = findViewById(R.id.cb_sumar);
        cb2 = findViewById(R.id.cb_restar);
    }

    public void operar(View view){
        String operando1_String = et1.getText().toString();
        String operando2_String = et2.getText().toString();
        String resultado_string = "";

        if(operando1_String.isEmpty() || operando2_String.isEmpty()){
            Toast.makeText(this, "Debes de llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{

            int operando1_int = Integer.parseInt(operando1_String);
            int operando2_int = Integer.parseInt(operando2_String);
            int resultado_suma_int = 0;
            int resultado_resta_int = 0;

            if(cb1.isChecked() && cb2.isChecked()){//Ambas están seleccionadas
                resultado_suma_int = operando1_int + operando2_int;
                resultado_resta_int = operando1_int - operando2_int;
                resultado_string = "El resultado de la suma es: " + resultado_suma_int + " / La resta es: " + resultado_resta_int ;
            }else if(cb1.isChecked() && !cb2.isChecked()){ //Solo la suma está seleccionada
                resultado_suma_int = operando1_int + operando2_int;
                resultado_string = "La suma es: " + resultado_suma_int;
            }else if(!cb1.isChecked() && cb2.isChecked()) { //Solo la resta está seleccionada
                resultado_resta_int = operando1_int - operando2_int;
                resultado_string = "La resta es: " + resultado_resta_int;
            }else{
                Toast.makeText(this, "Debes seleccionar al menos una opción", Toast.LENGTH_SHORT).show();
            }
            tv1.setText(resultado_string);
        }

    }
}