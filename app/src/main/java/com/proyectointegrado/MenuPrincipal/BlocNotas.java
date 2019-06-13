package com.proyectointegrado.MenuPrincipal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.proyecto.appproyectointegrado.R;

class BlocNotas extends AppCompatActivity {

    EditText txtBloc;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        txtBloc =   findViewById(R.id.txtBloc);
        pref = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        txtBloc.setText(pref.getString("BlocDeNotas", ""));
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("BlocDeNotas", txtBloc.getText().toString());
        editor.commit();
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notas, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("BlocDeNotas", txtBloc.getText().toString());
        editor.commit();
        return false;
    }
}
