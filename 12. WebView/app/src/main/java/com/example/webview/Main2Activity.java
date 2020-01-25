package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        wv1 = findViewById(R.id.wv1);
        String URL = getIntent().getStringExtra("sitioWeb"); //Recupera el valor
        wv1.setWebViewClient(new WebViewClient()); //No permitir que se navegue afuera
        wv1.loadUrl("https://" + URL); //Abre el sitio solicitado
    }
    public void Cerrar(View view){
        finish();
    }
}
