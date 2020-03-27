package com.example.arenky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splash extends AppCompatActivity {
                                                                                                    //Definimos la duración del splash
    private final int DURACION_SPLASH = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                                                                                                    //Definimos la orientación y parametros para que sea tipo fullSccreen
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
                                                                                                    //Creamos  el lanzador que contendra un intento explicito que nos mandará a la ActivityMain
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DURACION_SPLASH);                                                                        //Aqui le asignamos el tiempo que  va a durar
    }
}
