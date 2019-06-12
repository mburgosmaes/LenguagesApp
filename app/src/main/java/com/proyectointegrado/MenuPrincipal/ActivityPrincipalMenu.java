package com.proyectointegrado.MenuPrincipal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.MenuPrincipal.SectionsPagerAdapter;

public class ActivityPrincipalMenu extends AppCompatActivity {

    EditText txtBloc;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        setContentView(R.layout.activity_notas);

        //Notas
        txtBloc =  findViewById(R.id.txtBloc);
        pref = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        txtBloc.setText(pref.getString("BlocDeNotas", ""));
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("BlocDeNotas", txtBloc.getText().toString());
        editor.commit();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        editor.putString("Notas", txtBloc.getText().toString());
        editor.commit();
        return false;
    }
}