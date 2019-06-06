package com.proyectointegrado.Login;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.Cursos.Cursos_inicio;
import com.proyectointegrado.Database_manager.Users;
import com.proyectointegrado.Database_manager.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Login_activity extends AppCompatActivity implements View.OnClickListener {
    private static EditText et_email_login, et_pass_login, et_user, et_email_register, et_pass_register;
    private static Button btn_singup, btn_login;
    private static ImageView img_logo;
    private static Intent i;
    private static DefaultHttpClient client;
    private static JSONObject respJSONObject;
    private static Users users;
    private static Utils utils;
    private static String TAG = "PRUEBA";
    private static String insert_email, insert_pass;
    private static String ALLOK;
    private static List<Users> listUser;
    private static JSONObject jsonObject;

    private static Bundle bundle;

    private static String nombre="";
    private static  String id="";
    private static  String emailUser = "";

    //todo: la imagen del logo redirecciónará a la página web.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_email_login = findViewById(R.id.et_user);
        et_pass_login = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        btn_singup = findViewById(R.id.btn_singup);
        //img_logo = findViewById(R.id.img_logo);
        btn_login.setOnClickListener(this);
        btn_singup.setOnClickListener(this);
        utils = new Utils();


    }

    private void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                insert_email = et_email_login.getText().toString().trim().toLowerCase();
                insert_pass = et_pass_login.getText().toString().trim();
                new ExecuteTaskLoginUser().execute();

                break;

            case R.id.btn_singup:

                i = new Intent(getApplicationContext(), Registre_activity.class);

                i.putExtra("Nombre", nombre);
                i.putExtra("_id", id);
                i.putExtra("Email", emailUser);
                startActivity(i);

                break;
        }

    }

    private class ExecuteTaskLoginUser extends AsyncTask<String, String, String >{
        String pass ="";
        String decrypt_pass="";

        @Override
        protected String doInBackground(String... params) {

            client = new DefaultHttpClient();
            jsonObject = null;
            HttpConnectionParams.setConnectionTimeout(client.getParams(), 1000);

            try {

                HttpGet get = new HttpGet("https://proyecto-studium.herokuapp.com/api/user/getEmail/"+ insert_email);

                HttpResponse response = client.execute(get);
                String responseStr = EntityUtils.toString(response.getEntity());
                JSONObject object = new JSONObject(responseStr);

                jsonObject = object.getJSONObject("emailDocument");


                try {
                    emailUser = jsonObject.getString("Email");
                    pass = jsonObject.getString("Pass");
                    nombre = jsonObject.getString("Nombre");
                    id = jsonObject.getString("_id");

                    decrypt_pass = Utils.encrypt_pass_sha512(insert_pass);
                }
                catch (JSONException e)
                {
                    log(e.getMessage());
                }

                if (responseStr != null) {
                        ALLOK="si";
                    }

            } catch (Exception e) {
                //log( e.getMessage());
                ALLOK="no";
            }

            return ALLOK;
        }

        @Override
        protected void onPostExecute(String ALLOK2) {
            super.onPostExecute(ALLOK2);
            //Si se obtiene objeto
            if (ALLOK2.equalsIgnoreCase("si"))
            {
                if (emailUser.equalsIgnoreCase(insert_email) && pass.equals(decrypt_pass))
                {
                    //Aquí llamar a nueva actividad.
                    i = new Intent(getApplicationContext(), Cursos_inicio.class);

                    i.putExtra("Nombre", nombre);
                    i.putExtra("_id", id);
                    i.putExtra("Email", emailUser);
                    startActivity(i);

                   // lanzarActivity(ActivityPrincipalMenu.class,i);

                }
                else
                {
                    mostrarToast("Email o pass incorrectos");
                }

                //Si no se obtiene objeto.
            }
            else
                log("Error con el servidor");
        }
    }

    private void log(String mensaje) {
        Log.i(TAG, mensaje);
    }
    private Users montar(String e, String p)
    {
        users.setEmail(e);
        users.setPass(p);


        return users;
    }
}
