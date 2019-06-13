package com.proyectointegrado.Cursos;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.Actividades.Actividades;
import com.proyectointegrado.ClasesVideos.TemarioVideo;
import com.proyectointegrado.Database_manager.Actividad;
import com.proyectointegrado.Database_manager.ActividadEjRellenar;
import com.proyectointegrado.Database_manager.ActividadEjTest;
import com.proyectointegrado.Database_manager.ActividadEjTestImagenes;
import com.proyectointegrado.Database_manager.ActividadEjTestOpciones;
import com.proyectointegrado.Database_manager.ActividadEjTestOpcionesOp;
import com.proyectointegrado.Database_manager.Contenido;
import com.proyectointegrado.Database_manager.Cursos;
import com.proyectointegrado.Database_manager.Examen;
import com.proyectointegrado.Database_manager.ExamenExTest;
import com.proyectointegrado.Database_manager.ExamenExTestOpciones;
import com.proyectointegrado.Database_manager.ExamenExTestOpcionesOp;
import com.proyectointegrado.Database_manager.Subtemarios;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Curso_seleccionado extends FragmentActivity {

    private static String _idUser, tipoUser, nombreUser, apeUser, emailUser;
    Button btn_actividades,  btn_temario, btn_examen;
    TextView tv_titulo, tv_fechaini, tv_desc, tv_idioma, tv_fechafin;
    private static String nombreCurso, creadorCurso, idiomaCurso, estadoCurso,desc_curso, idCurso, nivel_Curso, nombre_user;
    private static String tituloTemario, descTemario, nivelTemario, estadoTemario, _idTemario;
    private static String tituloSub, descSub, estadoSub, _idSub;
    private static String urlVideoContenido, textoVideoContenido, tipoContenido, tituloContenido, descContenido, estadoContenido, _idContenido;
    private static String urlEjTestImagenes;
    private static String opEjTestOpcionesOp,aciertoEjTestOpcionesOp;
    private static int notaxamen;
    private String preguntaExamenExTest;
    private static String opExamenExtestOpcionesOp, aciertoExamenExTestOpcionesOp;


    private static int indice_Curso, indiceTemario, indiceSub, indiceContenido, indiceEjTestImagenes, indiceExamenExTest;

    private static DefaultHttpClient client;
    private static JSONObject respJSONObject;
    private static Users user;
    private static Cursos curso;
    private static Utils utils;
    private static String TAG = "PRUEBA";
    private static String ALLOK;
    private static Cursos_inicio cursos_inicio;
    private static JSONObject jsonObject;
    private static Bundle bundle;
    private static  Fragment fragment;
    private static final int CONTENT_VIEW_ID = 10101010;

    //listas
    private static List<Users> listUser;
    private static List<Temario> listTemarios;
    private static List<Cursos> listCursos;
    private static List<Subtemarios> listSubtemarios;
    private static ArrayList<Contenido> listContenidos;
    private static List<Actividad> listCActividades;
    private static List<Examen> listTemarioSubtemarioContenidoActividadExamen;
    private static List<ActividadEjTest> listActividadEjTest;
    private static List<ActividadEjRellenar> listTemarioSubtemarioContenidoActividadEjRellenar;
    private static List<ActividadEjTestImagenes> listEjTestImagenes;
    private static List<ActividadEjTestOpciones> listEjTestOpciones;
    private static List<ActividadEjTestOpcionesOp> listEjTestOpcionesOp;
    private static List<ExamenExTest> listExamenExTest;
    private static List<ExamenExTestOpciones> listExamenTestOpciones;
    private static List<ExamenExTestOpcionesOp> listExamenTestOpcionesOp;

    //objetos
    Temario temario;
    Subtemarios subtemario;
    Contenido contenido;
    Actividad actividad;
    Examen examen;
    ActividadEjTest actividadEjTest;
    ActividadEjRellenar actividadEjRellenar;
    ActividadEjTestImagenes actividadEjTestImagenes;
    ActividadEjTestOpciones actividadEjTestOpciones;
    ActividadEjTestOpcionesOp actividadEjTestOpcionesOp;
    ExamenExTestOpciones examenExTestOpciones;
    ExamenExTestOpcionesOp examenExTestOpcionesOp;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_curso_seleccionado);


        tv_titulo = findViewById(R.id.tv_titulo_curso_c2);
        tv_fechaini = findViewById(R.id.tv_fecha_inicio_curso);
        tv_desc = findViewById(R.id.tv_desc_Curso_c2);
        tv_fechafin = findViewById(R.id.tv_fecha_fin_curso);
        tv_idioma = findViewById(R.id.tv_Idioma_Curso_c2);

        btn_actividades = findViewById(R.id.btn_actividades_c2);
        btn_temario = findViewById(R.id.btn_videos_c2);
        btn_examen = findViewById(R.id.btn_examen_c2);

        //INIZIALIZAR LISTAS
        listUser= new ArrayList<>();
        listCursos = new ArrayList<>();
        listTemarios = new ArrayList<>();
        listSubtemarios = new ArrayList<>();
        listContenidos = new ArrayList<>();
        listCActividades = new ArrayList<>();
        listTemarioSubtemarioContenidoActividadExamen = new ArrayList<>();
        listActividadEjTest = new ArrayList<>();
        listEjTestImagenes = new ArrayList<>();
        listEjTestOpciones = new ArrayList<>();
        listEjTestOpcionesOp = new ArrayList<>();
        listExamenExTest = new ArrayList<>();
        listExamenTestOpciones = new ArrayList<>();
        listExamenTestOpcionesOp = new ArrayList<>();



        bundle = new Bundle();
        bundle = getIntent().getExtras();
        idCurso = bundle.getString("_id_curso");


        // nombre_user="DEFECTO";


      /*  btn_temario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temarios_inicio fg_temarios = new Temarios_inicio();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_seleccionado_c2, fg_temarios);
                transaction.addToBackStack(null);
                fg_temarios.setArguments(bundle);
                // Commit the transaction
                transaction.commit();
            }
        });*/
        new ExecuteTask_ObtenerCursosInscritos3().execute();


        btn_temario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Fragment f = new TemarioVideo();

               // cambiarFragment(f);
            }
        });


        btn_actividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log("CLICK");

                Fragment f = new Actividades();
                cambiarFragment(f);

                log("FIN");
            }
        });

    }

    private void log(String mensaje) {
        Log.i(TAG, mensaje);
    }
    public void cambiarFragment(Fragment f)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        bundle = new Bundle();
        bundle.putSerializable("OBJECTOCURSO", curso);
        // fragment = new Temarios_inicio();
        f.setArguments(bundle);
        fragmentTransaction.add(R.id.fragment_seleccionado_c2, f);
        fragmentTransaction.replace(R.id.fragment_seleccionado_c2, f);
        fragmentTransaction.commit();
    }

    private class ExecuteTask_ObtenerCursosInscritos3 extends AsyncTask<String, String, Cursos> {
        @Override
        protected Cursos doInBackground(String... params) {

            client = new DefaultHttpClient();
            jsonObject = null;
            HttpConnectionParams.setConnectionTimeout(client.getParams(), 1000);

            try {

                HttpGet get = new HttpGet("https://proyecto-studium.herokuapp.com/api/curso/getCurso/" + idCurso);

                HttpResponse response = client.execute(get);
                String responseStr = EntityUtils.toString(response.getEntity());//resultado del execute query
                JSONObject object = new JSONObject(responseStr);//copiarr

                //Se recorren cursos.

                //ITERATOR DE CURSOS
                Iterator<?> objectCurso = object.keys();

                while (objectCurso.hasNext()) {

                    //CLAVES DE CURSOS
                    String key = (String) objectCurso.next();

                    if (object.get(key) instanceof JSONObject) {
                        //Valores de las claves de curso.
                        JSONObject dataCurso = new JSONObject(object.get(key).toString());

                        curso = new Cursos();
                        listCursos = new ArrayList<>();


                        curso.setDescripcionCurso(dataCurso.getString("Descripcion"));
                        curso.setIdiomaCurso(dataCurso.getString("Idioma"));
                        curso.setTituloCurso(dataCurso.getString("Titulo"));
                        curso.setId_curso(dataCurso.getString("_id"));
                        curso.setEstadoCurso(dataCurso.getString("Estado"));
                        curso.setFecha_inicioCurso(dataCurso.getString("Fecha_inicio"));
                        curso.setFecha_finCurso(dataCurso.getString("Fecha_cierre"));
                        curso.setFecha_inscripcionCurso(dataCurso.getString("Fecha_inscripcion"));

                        JSONArray jsonArrayTemarios = dataCurso.getJSONArray("Temario");
                        JSONArray jsonArrayUsers = dataCurso.getJSONArray("Usuarios");

                        for (int j = 0; j < jsonArrayTemarios.length(); j++) {
                            JSONObject dataCursoTemario = jsonArrayTemarios.getJSONObject(j);
                            temario = new Temario();

                            temario.setEstadoTemario(dataCursoTemario.getString("Estado"));
                            temario.setTitulo(dataCursoTemario.getString("Titulo"));
                            temario.setNivel(dataCursoTemario.getString("Nivel"));
                            temario.setIndice(dataCursoTemario.getInt("Indice"));
                            temario.setDescripcion(dataCursoTemario.getString("Descripcion"));

                            JSONArray jsonArraySub = dataCursoTemario.getJSONArray("SubTemario");

                            for (int x = 0; x < jsonArraySub.length(); x++) {
                                JSONObject dataSubtemario = jsonArraySub.getJSONObject(x);

                                subtemario = new Subtemarios();

                                subtemario.setDescSub(dataSubtemario.getString("Descripcion"));
                                subtemario.setEstadoSub(dataSubtemario.getString("Estado"));
                                subtemario.setIndiceSub(dataSubtemario.getInt("Indice"));
                                subtemario.setTituloSub(dataSubtemario.getString("Titulo"));

                                Iterator<?> objectContenido = dataSubtemario.keys();

                                while (objectContenido.hasNext())
                                {

                                    String keyConte = (String) objectContenido.next();


                                    if (dataSubtemario.get(keyConte) instanceof JSONObject)
                                    {
                                        //Valores de las claves de curso.
                                        JSONObject dataContenido = new JSONObject(dataSubtemario.get(keyConte).toString());

                                        contenido = new Contenido();
                                        listContenidos = new ArrayList<>();

                                        try
                                        {

                                            contenido.setTextoCon(dataContenido.getString("Texto"));
                                            contenido.setUrlCon(dataContenido.getString("UrlVideo"));
                                            contenido.setTipoCon(dataContenido.getString("Tipo"));





                                                  /*  Iterator<?> objectEjTest = dataActividad.keys();

                                                    while (objectEjTest.hasNext())
                                                    {

                                                        String keyEjTest = (String) objectEjTest.next();

                                                        if (dataActividad.get(keyEjTest) instanceof JSONObject) {
                                                        }
                                                        JSONObject dataEjTest = new JSONObject(dataActividad.get(keyConte).toString());
                                                        Log.i(TAG, "doInBackground: EJTEEEST: "+dataEjTest.toString());

                                                    }*/

                                        }
                                        catch (Exception e3)
                                        {

                                        }


                                        JSONArray arrayActividades =dataContenido.getJSONArray("Actividad");

                                        for (int a = 0; a < arrayActividades.length(); a++)
                                        {
                                            JSONObject dataActividad = arrayActividades.getJSONObject(a);
                                            actividad = new Actividad();
                                            log("ACTIVIDAD: " + dataActividad);

                                            listActividadEjTest = new ArrayList<>();


                                            Iterator<?> objectEjTest = dataActividad.keys();

                                            while (objectEjTest.hasNext())
                                            {
                                                String keyEjTest = (String) objectEjTest.next();

                                                if (dataActividad.get(keyEjTest) instanceof JSONObject) {
                                                    JSONObject dataEjTest = new JSONObject(dataActividad.get(keyEjTest).toString());
                                                    Log.i(TAG, "doInBackground: EJTEEEST: "+dataEjTest.toString());

                                                    actividadEjTest = new ActividadEjTest();
                                                    listActividadEjTest = new ArrayList<>();

                                                    try {
                                                        JSONArray arrayImagenes = dataEjTest.getJSONArray("Imagenes");

                                                        for (int ai = 0; ai < arrayImagenes.length(); ai++) {
                                                            JSONObject dataImagenes = arrayImagenes.getJSONObject(ai);
                                                            log("IMAGENEEEES:" + dataImagenes.toString());

                                                            actividadEjTestImagenes = new ActividadEjTestImagenes();
                                                            //listEjTestImagenes = new ArrayList<>();

                                                            actividadEjTestImagenes.setUrlActividadEjTestImagenes(dataImagenes.getString("Url"));
                                                            actividadEjTestImagenes.setIndiceActividadEjTestImagenes(dataImagenes.getInt("Indice"));

                                                            listEjTestImagenes.add(actividadEjTestImagenes);

                                                        }
                                                    }
                                                    catch (Exception eji)
                                                    {

                                                    }
                                                    actividadEjTest.setListActividadEjTestImagenes(listEjTestImagenes);














                                                    //TODO OK
                                                    listActividadEjTest.add(actividadEjTest);

                                                    actividad.setListActividadEjTest(listActividadEjTest);
                                                }
                                            }
                                            actividad.setListActividadEjTest(listActividadEjTest);

                                            listCActividades.add(actividad);

                                            contenido.setListActividades(listCActividades);

                                        }
                                        listContenidos.add(contenido);
                                    }
                                }

                                subtemario.setListContenido(listContenidos);
                                listSubtemarios.add(subtemario);

                            }

                            temario.setListSubtemarios(listSubtemarios);
                            listTemarios.add(temario);
                        }

                        for (int x = 0; x < jsonArrayUsers.length(); x++) {
                            JSONObject dataCursoUser = jsonArrayUsers.getJSONObject(x);
                            user = new Users();

                            user.setId_user(dataCursoUser.getString("IdUsuario"));
                            user.setType(dataCursoUser.getString("Tipo"));

                            listUser.add(user);

                        }

                        curso.setListTemarios(listTemarios);
                        curso.setListUsuarios(listUser);
                        log("CURSO MONTADO3: " + curso.toString());

                    }
                }
                if (responseStr != null) {
                    ALLOK = "si";
                }

            }
            catch (JSONException | IOException e)
            {
                // e.printStackTrace();
                //log(e.getMessage());
                ALLOK="no";
            }

            return curso;
        }


        @Override
        protected void onPostExecute(Cursos curso) {

            super.onPostExecute(curso);
            //Si se obtiene objeto
            if (ALLOK.equalsIgnoreCase("si"))
            {
                tv_desc.setText("DESCRIPCIÓN: \n"+curso.getDescripcionCurso());
                tv_idioma.setText("IDIOMA: "+curso.getIdiomaCurso());
                tv_titulo.setText(curso.getTituloCurso());
                tv_fechaini.setText("FECHA INICIO: "+curso.getFecha_inicioCurso());
                tv_fechafin.setText("FECHA FIN:"+curso.getFecha_finCurso());



                //tv_desc.setText(desc_curso);


            }
            else
            {
                log("ERROR FIN ASYNC");
            }
        }

    }



}
