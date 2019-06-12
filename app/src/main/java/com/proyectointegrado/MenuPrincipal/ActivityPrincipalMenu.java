package com.proyectointegrado.MenuPrincipal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.ImageView;
import android.view.View;

import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.MenuPrincipal.SectionsPagerAdapter;

public class ActivityPrincipalMenu extends AppCompatActivity {

    EditText txtBloc;
    SharedPreferences pref;
    Intent op2;
    ImageView imagenBloc;

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
        op2 = new Intent(this, BlocDeNotas.class);
        imagenBloc=findViewById(R.id.imagenBloc);

        imagenBloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bloc = new Intent(ActivityPrincipalMenu.this, BlocDeNotas.class);
                startActivity(bloc);
            }
        });
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
        getMenuInflater().inflate(R.menu.principal, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.opcion2: startActivity(op2);break;
        }
        return false;
    }
}