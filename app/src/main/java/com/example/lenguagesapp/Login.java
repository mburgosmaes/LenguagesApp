package com.example.lenguagesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView nombrelogo,registre;
    EditText user,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    nombrelogo  = findViewById(R.id.nombrelogo);
    registre = findViewById(R.id.registre);
    user        = findViewById(R.id.user);
    pwd         = findViewById(R.id.pwd);


        registre.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Login.this,registre_activity.class);
                startActivity(it);
            }
        });
    }


}
