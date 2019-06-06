package com.proyectointegrado.Login;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.Database_manager.Users;
import com.proyectointegrado.Database_manager.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

public class Registre_activity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "PRUEBA";
    private static CompositeDisposable compositeDisposable = new CompositeDisposable();
    private static Intent i;
    private static Button btn_register;
    private static EditText et_name, et_surname, et_pass, et_email, et_type;
    private static String name, surname, email, insert_pass, pass, type;
    private static Spinner sp_type_user;
    private static  DefaultHttpClient client;
    private static  JSONObject respJSONObject;
    private static Users user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        btn_register = findViewById(R.id.btn_register);
        et_name = findViewById(R.id.et_user_registre);
        et_surname = findViewById(R.id.et_surname_registre);
        et_email = findViewById(R.id.et_mail_registre);
        et_pass = findViewById(R.id.et_pass_registre);
        sp_type_user = findViewById(R.id.sp_type_registre);

        //in_api_service = Utils.getAPIService();
        btn_register.setOnClickListener(this);

    }


    private void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                comprobar_et();
        }
    }

    private void montarUser(Users users) {
        users.setName(et_name.getText().toString().trim());
        users.setSurname(et_surname.getText().toString().trim());
        users.setEmail(et_email.getText().toString().trim());
        users.setPass(et_pass.getText().toString().trim());
        users.setType(et_type.getText().toString().trim());
    }

    private void log(String mensaje) {
        Log.i(TAG, mensaje);
    }

    private class ExecuteTaskRegisterUser extends AsyncTask<String, String, Users> {
        @Override
        protected Users doInBackground(String... params) {


             user = new Users();

             client = new DefaultHttpClient();
             respJSONObject = null;
            HttpConnectionParams.setConnectionTimeout(client.getParams(), 1000);

            try {
                HttpPost post = new HttpPost("https://proyecto-studium.herokuapp.com/api/user/setuser");
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(5);
                nameValuePairs.add(new BasicNameValuePair("Nombre", name));
                nameValuePairs.add(new BasicNameValuePair("Surname", surname));
                nameValuePairs.add(new BasicNameValuePair("Email", email));
                nameValuePairs.add(new BasicNameValuePair("Pass", pass));
                nameValuePairs.add(new BasicNameValuePair("Rol", type));

                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = client.execute(post);
                String responseStr = String.valueOf(EntityUtils.toString(response.getEntity()));
                respJSONObject = new JSONObject(responseStr);

                if (respJSONObject != null) {
                    log(responseStr);
                    log("SI");
                }

            } catch (Exception e) {
                log(e.getMessage());
            }
            return user;
        }

        @Override
        protected void onPostExecute(Users users) {
            super.onPostExecute(users);

            log("TODO OK");
        }
    }

    public void comprobar_et()
    {
        if (et_name.getText().length()==0
            || et_email.getText().length()==0
                || et_pass.getText().length()==0
                    || et_surname.getText().length()==0
                        || sp_type_user.getSelectedItem()==null)
        {
            mostrarToast("ERROR, COMPLETE TODOS LOS CAMPOS");
        }
        else
        {
            name = et_name.getText().toString().trim();
            surname = et_surname.getText().toString().trim();
            email = et_email.getText().toString().trim().toLowerCase();
            insert_pass = et_pass.getText().toString().trim();
            type = sp_type_user.getSelectedItem().toString().trim();

            if (type.equalsIgnoreCase(getResources().getString(R.string.ALUMNO_NAME)))
            {
                type="Student";
            }
            else if (type.equalsIgnoreCase(getResources().getString(R.string.PROFESOR_NAME)))
            {
                type="Professor";
            }

            pass = Utils.encrypt_pass_sha512(insert_pass);

            new ExecuteTaskRegisterUser().execute();
        }
    }
}
