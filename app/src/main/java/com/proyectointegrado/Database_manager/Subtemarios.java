package com.proyectointegrado.Database_manager;

import java.util.ArrayList;
import java.util.List;

public class Subtemarios {

    private String tituloSub, descSub, idSub, estadoSub;
    private int indiceSub;
    private ArrayList<Contenido> listContenido;

    public Subtemarios()
    {

    }

    public Subtemarios(String tituloSub, String descSub, String idSub, String estadoSub, int indiceSub, ArrayList<Contenido> listContenido) {
        this.tituloSub = tituloSub;
        this.descSub = descSub;
        this.idSub = idSub;
        this.estadoSub = estadoSub;
        this.indiceSub = indiceSub;
        this.listContenido = listContenido;
    }

    public String getTituloSub() {
        return tituloSub;
    }

    public void setTituloSub(String tituloSub) {
        this.tituloSub = tituloSub;
    }

    public String getDescSub() {
        return descSub;
    }

    public void setDescSub(String descSub) {
        this.descSub = descSub;
    }

    public String getIdSub() {
        return idSub;
    }

    public void setIdSub(String idSub) {
        this.idSub = idSub;
    }

    public String getEstadoSub() {
        return estadoSub;
    }

    public void setEstadoSub(String estadoSub) {
        this.estadoSub = estadoSub;
    }

    public int getIndiceSub() {
        return indiceSub;
    }

    public void setIndiceSub(int indiceSub) {
        this.indiceSub = indiceSub;
    }

    public ArrayList<Contenido> getListContenido() {
        return listContenido;
    }

    public void setListContenido(ArrayList<Contenido> listContenido) {
        this.listContenido = listContenido;
    }

    @Override
    public String toString() {
        return "Subtemarios{" +
                "tituloSub='" + tituloSub + '\'' +
                ", descSub='" + descSub + '\'' +
                ", idSub='" + idSub + '\'' +
                ", estadoSub='" + estadoSub + '\'' +
                ", indiceSub=" + indiceSub +
                ", listContenido=" + listContenido +
                '}';
    }
}
