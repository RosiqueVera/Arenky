package com.example.arenky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    //Definimos el objeto BottomNavigationView
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conectamos el objeto con el item en pantalla
        bottomNavigationView = findViewById(R.id.bottomNav);

        if (savedInstanceState == null) {
            //En el caso de que no se encuentre un estado guardado por default nos va a mandar a HomeFragment
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
        }
        /*
         *Creamos el listener de forma ánonima para el Nav en el cual implementamos un switch case
         para crear un fragmento dependiendo de la opción va a recuperar el fragmetno y al final del listener
         * va a ejecutar (reemplazar el fragmento actual  por el que tomó dependiendo de la opción)
         */
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.map:
                        fragment = new MapFragment();
                        break;
                    case R.id.restaurants:
                        fragment = new RestaurantsFragment();
                        break;
                    case R.id.calendar:
                        fragment = new CalendarFragment();
                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                return false;
            }
        });
    }
}
