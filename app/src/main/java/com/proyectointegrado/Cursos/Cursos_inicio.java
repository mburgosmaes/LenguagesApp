package com.proyectointegrado.Cursos;

import android.content.Context;
import android.content.Intent;
import com.proyectointegrado.Adapters.*;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.Database_manager.Cursos;
import com.proyectointegrado.Database_manager.Users;
import com.proyectointegrado.Database_manager.Utils;
import com.proyectointegrado.Temarios.Temarios_inicio;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Cursos_inicio extends AppCompatActivity {

    private static Intent i;
    private static DefaultHttpClient client;
    private static JSONObject respJSONObject;
    private static Users users;
    private static Cursos curso;
    private static Utils utils;
    private static String TAG = "PRUEBA";
    private static String ALLOK;
    private static List<Users> listUser;
    private static List<Cursos> listCursos;
    private static Cursos_inicio cursos_inicio;
    private static JSONObject jsonObject;

    private static String nombreCurso, creadorCurso, idiomaCurso, estadoCurso,desc_curso;
    private static String idCurso;
    private static int horasCurso;

    private static String id_user, nombre_user, email_user;

    private static RecyclerView rv;
    private static RecyclerView.LayoutManager lManager;
    private static Adapter_cursosInicio adapter;
    private static RecyclerView rv_Adolfo_Prueba3;

    private static Context context;

    Bundle bundle;

    @Nullable
   /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_cursos_inicio, container, false);
       // linearLayout = (LinearLayout) rootView.findViewById(R.id.linearlayout);


        bundle = getIntent().getExtras();
        id_user = bundle.getString("_id");


        log("ID:" +id_user);

        new ExecuteTask_ObtenerCursosInscritos().execute();


        return rootView;
    }*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos_inicio);

        rv_Adolfo_Prueba3 = findViewById(R.id.rv_cursos_inicio);
        bundle = getIntent().getExtras();
        id_user = bundle.getString("_id");
        nombre_user = bundle.getString("Nombre");


        new ExecuteTask_ObtenerCursosInscritos().execute();
    }

    private class ExecuteTask_ObtenerCursosInscritos extends AsyncTask<String, String, List<Cursos> > {
        @Override
        protected  List<Cursos> doInBackground(String... params) {

            client = new DefaultHttpClient();
            jsonObject = null;
            HttpConnectionParams.setConnectionTimeout(client.getParams(), 1000);

           try {

                HttpGet get = new HttpGet("https://proyecto-studium.herokuapp.com/api/curso/getCursos");

                HttpResponse response = client.execute(get);
                String responseStr = EntityUtils.toString(response.getEntity());//resultado del execute query
               JSONObject object = new JSONObject(responseStr);//copiarr
                //JSONArray jsonarray = new JSONArray(responseStr);

                JSONArray jsonarray = object.getJSONArray("curso");//
               listCursos = new ArrayList<>();


               for (int i =0; i<jsonarray.length();i++)
                {
                    JSONObject jsonData = jsonarray.getJSONObject(i);

                    idCurso = jsonData.getString("_id");
                    nombreCurso = jsonData.getString("Titulo");
                    estadoCurso = jsonData.getString("Estado");
                    idiomaCurso = jsonData.getString("Idioma");
                    desc_curso = jsonData.getString("Descripcion");
                    curso = montarCurso(idCurso,nombre_user,idiomaCurso,estadoCurso,desc_curso,nombreCurso);//aqui recojemos los valores 1 por 1
                    listCursos.add(curso);
                }


                if (responseStr != null) {
                    ALLOK="si";
                }

            } catch (Exception e) {
               ALLOK="no";

            }

            return listCursos;
        }


        @Override
        protected void onPostExecute(List<Cursos> listCursos) {

            super.onPostExecute(listCursos);
            //Si se obtiene objeto
            if (ALLOK.equalsIgnoreCase("si"))
            {
                lManager = new LinearLayoutManager(getApplicationContext());//inicializar
                rv_Adolfo_Prueba3.setLayoutManager(lManager);//
                adapter = new Adapter_cursosInicio(listCursos, getApplicationContext());//
                rv_Adolfo_Prueba3.setAdapter(adapter);


            }
        }
    }

    private void log(String mensaje) {
        Log.i(TAG, mensaje);
    }

    private void lanzarActivity (Class a)
    {
       /* Intent i = new Intent(this, a);
        startActivity(i);*/
    }

    public static Cursos montarCurso (String id_curso, String titulo, String idioma, String estado, String desc, String nom_cur)
    {
        curso = new Cursos();

        curso.setId_curso(id_curso);
        curso.setTituloCurso(titulo);
        //curso.setCreadorCurso(creador);
      //  curso.setHorasTotales(horas);
        curso.setIdiomaCurso(idioma);
        curso.setEstadoCurso(estado);
        curso.setDescripcionCurso(desc);
        curso.setTituloCurso(nom_cur);

        return curso;
    }
}
