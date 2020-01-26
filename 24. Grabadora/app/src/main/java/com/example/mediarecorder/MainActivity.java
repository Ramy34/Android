package com.example.mediarecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaRecorder grabacion;
    private String archivoSalida = null;
    private Button btn_recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_recorder = findViewById(R.id.btn_rec);

        //Pedimos los permisos para grabar y almacenar datos
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }
    }

    public void Grabar(View view){
        if(grabacion == null){
            archivoSalida = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Grabación.mp3";
            grabacion = new MediaRecorder();
            //Configuramos la grabación
            grabacion.setAudioSource(MediaRecorder.AudioSource.MIC); //Habilitamos el micrófono
            grabacion.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP); //El formato de salida será 3gp
            grabacion.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB); //Colocamos el tipo de encoder
            grabacion.setOutputFile(archivoSalida); //Le decimos cdonde se guardará el audio
            try{
                grabacion.prepare(); //Preparamos
                grabacion.start(); //Iniciamos la grabación
            }catch (IOException e){

            }
            //Cambiamos la aparencia del botón
            btn_recorder.setBackgroundResource(R.drawable.rec);
            Toast.makeText(this, "Grabando...", Toast.LENGTH_SHORT).show();
        }else {
            grabacion.stop(); //Detenemos la grabación
            grabacion.release(); //Finalizamos la grabación
            grabacion = null;
            btn_recorder.setBackgroundResource(R.drawable.stop_rec);
            Toast.makeText(this, "Grabación finalizada...", Toast.LENGTH_SHORT).show();
        }
    }

    public void Reproducir(View view){
        MediaPlayer mediaPlayer = new MediaPlayer();

        try{
            mediaPlayer.setDataSource(archivoSalida);
            mediaPlayer.prepare();
        }catch (IOException e){
        }
        mediaPlayer.start();
        Toast.makeText(this, "Reproduciendo Audio", Toast.LENGTH_SHORT).show();
    }

}
