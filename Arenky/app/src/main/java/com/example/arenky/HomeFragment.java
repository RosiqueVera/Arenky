package com.example.arenky;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//Extendemos la clase Fragment para poder emplear los fragmentos de cada opción del nav
public class HomeFragment extends Fragment {
    @Nullable
    @Override
    //En el onCreateView inflamos el fragmento de pantalla a desplegar
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }
}
