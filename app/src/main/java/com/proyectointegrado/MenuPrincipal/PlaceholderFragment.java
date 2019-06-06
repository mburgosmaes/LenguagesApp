package com.proyectointegrado.MenuPrincipal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.Cursos.Cursos_inicio;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    Intent i;
    FragmentManager fragmentManager = getFragmentManager();

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

  /*  @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.i("PRUEBA", s);
                switch (s)
                {
                    case "Activity1":

                        Cursos_inicio c = new Cursos_inicio();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fg_principal,c)
                                .addToBackStack(null)
                                .commit();
                        break;
                        case "Activity2":

                        Cursos_inicio c3 = new Cursos_inicio();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fg_principal,c3)
                                .addToBackStack(null)
                                .commit();
                        break;
                        case "Activity3":

                        Cursos_inicio c2 = new Cursos_inicio();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fg_principal,c2)
                                .addToBackStack(null)
                                .commit();
                        break;
                        case "Activity4":

                        Cursos_inicio c1 = new Cursos_inicio();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fg_principal,c1)
                                .addToBackStack(null)
                                .commit();
                        break;

                }

            }
        });
        return root;
    }*/
}