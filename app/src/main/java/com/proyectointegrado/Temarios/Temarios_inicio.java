package com.proyectointegrado.Temarios;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.Adapters.Adapter_temarioInicio;
import com.proyectointegrado.Cursos.Cursos_inicio;
import com.proyectointegrado.Database_manager.Temario;
import com.proyectointegrado.Database_manager.Users;
import com.proyectointegrado.Database_manager.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Temarios_inicio extends Fragment {


    private static Intent i;
    private static DefaultHttpClient client;
    private static JSONObject respJSONObject;
    private static Users users;
    private static Temario temario;
    private static Utils utils;
    private static String TAG = "PRUEBA";
    private static String ALLOK;
    private static List<Users> listUser;
    private static List<Temario> listTemario;

    private static JSONObject jsonObject;

    private static String desc_temario, id_curso, titulo_temario, nivel_temario;

    private static int indice_temario;

    private static String id_user, nombre_user, email_user;

    private static RecyclerView rv;
    private static RecyclerView.LayoutManager lManager;
    private static Adapter_temarioInicio adapter;
    private static RecyclerView rv_Adolfo_Prueba3;

    private static Context context;

    Bundle bundle;

    @Nullable
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_temarios_inicio, container, false);
       // linearLayout = (LinearLayout) rootView.findViewById(R.id.linearlayout);

     /*   Bundle bundle = new Bundle();
        bundle = this.getArguments();
        id_curso = bundle.getString("_id_curso");


        log("ID:" +id_user);

        new ExecuteTask_ObtenerTemarioInscritos().execute();*/


        return rootView;
    }


  /*  @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos_inicio);

        rv_Adolfo_Prueba3 = findViewById(R.id.rv_cursos_inicio);
        bundle = getIntent().getExtras();
        id_user = bundle.getString("_id");
        //nombre_user = bundle.getString("Nombre");

        log("ID:" +id_user);

        new ExecuteTask_ObtenerTemarioInscritos().execute();
    }*/

    private class ExecuteTask_ObtenerTemarioInscritos extends AsyncTask<String, String, List<Temario> > {
        @Override
        protected  List<Temario> doInBackground(String... params) {

            client = new DefaultHttpClient();
            jsonObject = null;
            HttpConnectionParams.setConnectionTimeout(client.getParams(), 1000);

            try {

                HttpGet get = new HttpGet("https://proyecto-studium.herokuapp.com/api/curso/getCursos/"+ id_curso);

                HttpResponse response = client.execute(get);
                String responseStr = EntityUtils.toString(response.getEntity());//resultado del execute query
                log(responseStr);
                JSONObject object = new JSONObject(responseStr);//copiarr
                //JSONArray jsonarray = new JSONArray(responseStr);

                JSONArray jsonarray = object.getJSONArray("curso");//
                listTemario = new ArrayList<>();


                for (int i =0; i<jsonarray.length();i++)
                {

                    log("i:"+i);
                    JSONObject jsonData = jsonarray.getJSONObject(i);
                    JSONArray jsonArrayTemas = jsonData.getJSONArray("Temario");
                    log("TEMARIO[]: "+ jsonArrayTemas.toString());

                    for (int j=0; j<jsonArrayTemas.length(); j++)
                    {
                        log("j:"+j);

                        JSONObject jsonData2 = jsonArrayTemas.getJSONObject(j);
                        JSONArray jsonArraysubTemas = jsonData2.getJSONArray("SubTemario");
                        log("SUBTEMARIO[]: "+ jsonArraysubTemas.toString());

                        for (int x=0; x<jsonArraysubTemas.length();x++)
                        {
                            log("x:"+x);
                            JSONObject jsonObjectContenido = jsonArraysubTemas.getJSONObject(x);

                            log("CONTENIDO{}: "+ jsonObjectContenido.toString());


                              titulo_temario = jsonObjectContenido.getString("Titulo");
                              indice_temario = jsonObjectContenido.getInt("Indice");
                              desc_temario =jsonObjectContenido.getString("Descripcion");

                              log("INDICE: "+indice_temario);
                              log("TITULO: "+titulo_temario);

                          //  indice_temario = object.getInt("Indice");

                            temario = montarTemario(id_curso, nivel_temario, titulo_temario, desc_temario, indice_temario);
                            listTemario.add(temario);
                            log(listTemario.toString());
                        }
                    }
                }


                if (responseStr != null) {
                    ALLOK="si";
                    log(ALLOK);
                }

            } catch (Exception e) {
                e.printStackTrace();
               log("CATCH2: "+e.getMessage());
               ALLOK="No";
            }

            return listTemario;
        }


        @Override
        protected void onPostExecute(List<Temario> listTemario) {

            super.onPostExecute(listTemario);
            //Si se obtiene objeto
            if (ALLOK.equalsIgnoreCase("si"))
            {
                lManager = new LinearLayoutManager(getActivity().getApplicationContext());//inicializar
                rv_Adolfo_Prueba3.setLayoutManager(lManager);//
                adapter = new Adapter_temarioInicio(Temarios_inicio.listTemario, getActivity().getApplicationContext());//
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

    public Temario montarTemario (String id, String nivel, String titulo, String desc, int indice)
    {
       temario = new Temario();

       temario.setDescripcion(desc);
       temario.setIndice(indice);
       temario.setId(id);
       temario.setNivel(nivel);
       temario.setTitulo(titulo);

        return temario;
    }

    private class ExecuteTask_ObtenerTemarioInscritos2 extends AsyncTask<String, String, List<Temario> > {
        @Override
        protected  List<Temario> doInBackground(String... params) {

            client = new DefaultHttpClient();
            jsonObject = null;
            HttpConnectionParams.setConnectionTimeout(client.getParams(), 1000);

            try {

                HttpGet get = new HttpGet("https://proyecto-studium.herokuapp.com/api/curso/getCursos");

                HttpResponse response = client.execute(get);
                String responseStr = EntityUtils.toString(response.getEntity());//resultado del execute query
                log(responseStr);
                JSONObject object = new JSONObject(responseStr);//copiarr
                //JSONArray jsonarray = new JSONArray(responseStr);

                JSONObject object2 = object.getJSONObject("curso");//
                JSONArray childrenArray = object2.getJSONArray("Temario.SubTemario");
                listTemario = new ArrayList<>();


                for (int i =0; i<childrenArray.length();i++)
                {
                    JSONObject jsonObjectContenido = childrenArray.getJSONObject(i);

                    titulo_temario = jsonObjectContenido.getString("Titulo");
                    indice_temario = jsonObjectContenido.getInt("Indice");
                    desc_temario =jsonObjectContenido.getString("Descripcion");

                    log("INDICE: "+indice_temario);
                    log("TITULO: "+titulo_temario);

                    //  indice_temario = object.getInt("Indice");

                    temario = montarTemario(id_curso, nivel_temario, titulo_temario, desc_temario, indice_temario);
                    listTemario.add(temario);
                    log(listTemario.toString());
                }


                if (responseStr != null) {
                    ALLOK="si";
                    log(ALLOK);
                }

            } catch (Exception e) {
                e.printStackTrace();
                log("CATCH2: "+e.getMessage());
                ALLOK="No";
            }

            return listTemario;
        }


        @Override
        protected void onPostExecute(List<Temario> listTemario) {

            super.onPostExecute(listTemario);
            //Si se obtiene objeto
            if (ALLOK.equalsIgnoreCase("si"))
            {
                lManager = new LinearLayoutManager(getActivity().getApplicationContext());//inicializar
                rv_Adolfo_Prueba3.setLayoutManager(lManager);//
                adapter = new Adapter_temarioInicio(Temarios_inicio.listTemario, getActivity().getApplicationContext());//
                rv_Adolfo_Prueba3.setAdapter(adapter);
            }
        }
    }

}
