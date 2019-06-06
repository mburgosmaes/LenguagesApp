package com.proyectointegrado.Database_manager;

import android.support.v7.widget.RecyclerView;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Users {

    private String name;
    private String surname;
    private String email;
    private String pass;
    private String type;
    private String id_user;

    public Users() {
    }

    public Users (String idUser, String tipoUser)
    {
        this.id_user = idUser;
        this.type = tipoUser;
    }

    public Users(String name, String surname, String email, String pass, String type, String id_user) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.pass = pass;
        this.type = type;
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", type='" + type + '\'' +
                ", id_user='" + id_user + '\'' +
                '}';
    }
}
