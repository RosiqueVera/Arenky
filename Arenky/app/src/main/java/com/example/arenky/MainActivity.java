package com.example.arenky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Converter.Factory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //Definimos el objeto BottomNavigationView
    BottomNavigationView bottomNavigationView;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.travelpayouts.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TravelPayoutsApi travelPayoutsApi = retrofit.create(TravelPayoutsApi.class);

        Call<PopularRoutes> call = travelPayoutsApi.getPopularRoutes();

        call.enqueue(new Callback<PopularRoutes>() {
            @Override
            public void onResponse(Call<PopularRoutes> call, Response<PopularRoutes> response) {

                if (!response.isSuccessful()) {
                    txtResult.setText("Code: " + response.code());
                    return;
                }

                PopularRoutes popularRoutes = response.body();
                    String content = "";
                    content += "Success: " + popularRoutes.getSuccess() + "\n";
                    content += "Error: " + popularRoutes.getError() + "\n";
                    content += "Currency: " + popularRoutes.getCurrency() + "\n\n";
                    txtResult.setText(content);

            }

            @Override
            public void onFailure(Call<PopularRoutes> call, Throwable t) {
                txtResult.setText(t.getMessage());
            }
        });

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
