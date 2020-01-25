package com.example.app_radiobutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private RadioButton rb1, rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_operando1);
        et2 = (EditText)findViewById(R.id.txt_operando2);
        tv1 = (TextView)findViewById(R.id.txt_resultado);
        rb1 = (RadioButton)findViewById(R.id.rb_suma);
        rb2 = (RadioButton)findViewById(R.id.rb_resta);
    }

    //Método para el botón calcular
    public void Calcular(View view){
        String operando1_String = et1.getText().toString();
        String operando2_String = et2.getText().toString();

        int operando1_int = Integer.parseInt(operando1_String);
        int operando2_int = Integer.parseInt(operando2_String);
        int resultado_int = 0;



        if(rb1.isChecked() == true){
            resultado_int = operando1_int + operando2_int;

        }else if(rb2.isChecked() == true){
            resultado_int = operando1_int - operando2_int;
        }

        String resultado = String.valueOf(resultado_int);
        tv1.setText(resultado);
    }
}
