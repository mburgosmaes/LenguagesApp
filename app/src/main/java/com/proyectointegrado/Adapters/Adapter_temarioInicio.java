package com.proyectointegrado.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.Database_manager.Cursos;
import com.proyectointegrado.Database_manager.Temario;

import java.util.List;


public class Adapter_temarioInicio extends RecyclerView.Adapter<Adapter_temarioInicio.ViewHolder> {

    private static List<Temario> items;
    private static Context context;
    private static View v;
    private static int x;


    private static SharedPreferences sharedPreferences;
    private static Toast toast;
    private static String nombre_user;




    public static class ViewHolder extends RecyclerView.ViewHolder {

        EditText et_titulo, et_nivel, et_desc;


        public ViewHolder(View v) {
            super(v);

            et_titulo = (EditText) v.findViewById(R.id.et_titulo_cardTemarios);
            et_desc = (EditText) v.findViewById(R.id.et_desc_cardtemario);
            et_nivel = (EditText) v.findViewById(R.id.et_nivel_cardTemarios);


        }

    }

    public Adapter_temarioInicio(List<Temario> items, Context context) {
        this.items = items;
        this.context = context;


        Log.i("Lista: ","items"+items.size());

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_cardview_temarios, viewGroup, false);

        sharedPreferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {

        sharedPreferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        viewHolder.et_titulo.setText(items.get(i).getTitulo());
        viewHolder.et_nivel.setText(items.get(i).getNivel());
        viewHolder.et_desc.setText(items.get(i).getDescripcion());


    }

}