package com.proyectointegrado.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.Cursos.Curso_seleccionado;
import com.proyectointegrado.Cursos.Cursos_inicio;
import com.proyectointegrado.Database_manager.Cursos;
import com.proyectointegrado.Temarios.Temarios_inicio;

import java.util.List;


public class Adapter_cursosInicio extends RecyclerView.Adapter<Adapter_cursosInicio.ViewHolder> {

    private static List<Cursos> items;
    private static Context context;
    private static View v;
    private static int x;

    private static SharedPreferences sharedPreferences;
    private static Toast toast;
    private static String nombre_user,id_curso;




    public static class ViewHolder extends RecyclerView.ViewHolder {

        EditText et_nombre_curso, et_creador_curso, et_idioma_curso, et_desc_curso, et_estado_curso;
        Button btn_inscribirse, btn_entrar;
        CardView cardView;

        public ViewHolder(View v) {
            super(v);

            et_nombre_curso = (EditText) v.findViewById(R.id.et_titulo_cardCursos);
            et_idioma_curso = (EditText) v.findViewById(R.id.et_idioma_cardCursos);
            et_creador_curso = (EditText) v.findViewById(R.id.et_titulo_cardCursos);
            et_desc_curso = (EditText) v.findViewById(R.id.et_desc_cursos);
            cardView = (CardView) v.findViewById(R.id.cardview_cursos_inicio);
            btn_entrar = (Button) v.findViewById(R.id.btn_entrar_cardCursos);
            btn_inscribirse = (Button) v.findViewById(R.id.btn_inscri_cursos);

        }

    }

    public Adapter_cursosInicio(List<Cursos> items, Context context) {
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
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_cursos_inicio, viewGroup, false);

        sharedPreferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {

        sharedPreferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        viewHolder.et_idioma_curso.setText(items.get(i).getIdiomaCurso());
        viewHolder.et_desc_curso.setText(items.get(i).getDescripcionCurso());
        viewHolder.et_creador_curso.setText(items.get(i).getCreadorCurso());
        viewHolder.et_nombre_curso.setText(items.get(i).getTituloCurso());
        //id_curso = items.get(i).getId_curso();


       /* viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i= new Intent(v.getContext(), Curso_seleccionado.class);
                //Intent i = new Intent(Cursos_inicio.this, Curso_seleccionado.class);
                i.putExtra("_id_curso",id_curso);

                v.getContext().startActivity(i);
                //context.startActivity(i);
            }
        });*/

        viewHolder.btn_inscribirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: FALTA HACER FUNCIONALIDAD PARA INSCRIBIR UN USUARIO A UN CURSO.
            }
        });

        viewHolder.btn_entrar.setOnClickListener(v -> {
           // int clickedPosition = ((Integer) viewHolder.btn_entrar.getTag()).intValue();
           // int clickedPosition = ((Integer) viewHolder.cardView.getTag()).intValue();
            //id_curso = items.get(clickedPosition).getId_curso();
          //  setId_curso(items.get(clickedPosition).getId_curso());

            /*Intent intent = new Intent("curso_seleccionado");
            //            intent.putExtra("quantity",Integer.parseInt(quantity.getText().toString()));
            intent.putExtra("idCurso",id_curso);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent); */

            final Intent i2= new Intent(v.getContext(), Curso_seleccionado.class);

            //Intent i = new Intent(Cursos_inicio.this, Curso_seleccionado.class);

            i2.putExtra("_id_curso",items.get(i).getId_curso().toString());
          //  i2.putExtra("_id_curso",id_curso);

            v.getContext().startActivity(i2);

        });

    }

    public static String getId_curso() {
        return id_curso;
    }

    public static void setId_curso(String id_curso) {
        Adapter_cursosInicio.id_curso = id_curso;
    }
}