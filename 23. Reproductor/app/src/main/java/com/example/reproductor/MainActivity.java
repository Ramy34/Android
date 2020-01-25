package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play_pause;
    Button btn_repetir;
    ImageView iv;
    MediaPlayer mp;
    boolean repetir = false; //repetir = 2,
    int posicion = 0;

    MediaPlayer[] vectormp = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_pause = findViewById(R.id.byn_play);
        btn_repetir = findViewById(R.id.btn_repetir);
        iv = findViewById(R.id.imageView);
        agregarCanciones();
    }

    public void agregarCanciones(){
        vectormp[0] = MediaPlayer.create(this, R.raw.race);
        vectormp[1] = MediaPlayer.create(this, R.raw.sound);
        vectormp[2] = MediaPlayer.create(this, R.raw.tea);
    }

    public void portadas(){
        if(posicion == 0){
            iv.setImageResource(R.drawable.portada1);
        }else if(posicion == 1){
            iv.setImageResource(R.drawable.portada2);
        } else if(posicion == 2){
            iv.setImageResource(R.drawable.portada3);
        }
    }

    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        }else{
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();
            agregarCanciones();
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            portadas();
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    public void Repetir(View view){
        if(repetir){
            repetir = false;
            vectormp[posicion].setLooping(repetir);
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
        }else{
            repetir = true;
            vectormp[posicion].setLooping(repetir);
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
        }
    }

    public void Siguiente(View view){
        if(posicion < vectormp.length -1){
            posicion += 1;
            if(vectormp[posicion-1].isPlaying()){
                vectormp[posicion-1].stop();
                vectormp[posicion].start();
            }
            portadas();
        }else{
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }

    public void Anterior(View view){
        if(posicion >= 1){
            posicion -= 1;
            if(vectormp[posicion+1].isPlaying()){
                vectormp[posicion+1].stop();
                agregarCanciones();
                vectormp[posicion].start();
            }
            portadas();
        }else{
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }
}
