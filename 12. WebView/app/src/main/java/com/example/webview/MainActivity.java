package com.example.webview;

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

        et1 = findViewById(R.id.txt_ws);
    }

    public void Ingresar(View view){
        String site = et1.getText().toString();
        if(site.isEmpty()){
            Toast.makeText(this, "Debes de ingresar un sitio web", Toast.LENGTH_SHORT).show();
        }else{
            Intent ingresar = new Intent(this, Main2Activity.class);
            ingresar.putExtra("sitioWeb", et1.getText().toString());
            startActivity(ingresar);
        }

    }
}
