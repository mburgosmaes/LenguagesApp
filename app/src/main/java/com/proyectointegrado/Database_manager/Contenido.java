package com.proyectointegrado.Database_manager;

import java.util.ArrayList;
import java.util.List;

public class Contenido {

    private String urlCon, textoCon, tipoCon, tituloCon, descCon, estadoCon, idCon;
    private int indicecon;
    private List<Actividad> listActividades;
    private List <Examen> listExamen;

    public Contenido()
    {

    }

    public Contenido(String urlCon, String textoCon, String tipoCon, String tituloCon, String descCon, String estadoCon, String idCon, int indicecon, List<Actividad> listActividades, List<Examen> listExamen) {
        this.urlCon = urlCon;
        this.textoCon = textoCon;
        this.tipoCon = tipoCon;
        this.tituloCon = tituloCon;
        this.descCon = descCon;
        this.estadoCon = estadoCon;
        this.idCon = idCon;
        this.indicecon = indicecon;
        this.listActividades = listActividades;
        this.listExamen = listExamen;
    }

    public String getUrlCon() {
        return urlCon;
    }

    public void setUrlCon(String urlCon) {
        this.urlCon = urlCon;
    }

    public String getTextoCon() {
        return textoCon;
    }

    public void setTextoCon(String textoCon) {
        this.textoCon = textoCon;
    }

    public String getTipoCon() {
        return tipoCon;
    }

    public void setTipoCon(String tipoCon) {
        this.tipoCon = tipoCon;
    }

    public String getTituloCon() {
        return tituloCon;
    }

    public void setTituloCon(String tituloCon) {
        this.tituloCon = tituloCon;
    }

    public String getDescCon() {
        return descCon;
    }

    public void setDescCon(String descCon) {
        this.descCon = descCon;
    }

    public String getEstadoCon() {
        return estadoCon;
    }

    public void setEstadoCon(String estadoCon) {
        this.estadoCon = estadoCon;
    }

    public String getIdCon() {
        return idCon;
    }

    public void setIdCon(String idCon) {
        this.idCon = idCon;
    }

    public int getIndicecon() {
        return indicecon;
    }

    public void setIndicecon(int indicecon) {
        this.indicecon = indicecon;
    }

    public List<Actividad> getListActividades() {
        return listActividades;
    }

    public void setListActividades(List<Actividad> listActividades) {
        this.listActividades = listActividades;
    }

    public List<Examen> getListExamen() {
        return listExamen;
    }

    public void setListExamen(List<Examen> listExamen) {
        this.listExamen = listExamen;
    }

    @Override
    public String toString() {
        return "Contenido{" +
                "urlCon='" + urlCon + '\'' +
                ", textoCon='" + textoCon + '\'' +
                ", tipoCon='" + tipoCon + '\'' +
                ", tituloCon='" + tituloCon + '\'' +
                ", descCon='" + descCon + '\'' +
                ", estadoCon='" + estadoCon + '\'' +
                ", idCon='" + idCon + '\'' +
                ", indicecon=" + indicecon +
                ", listActividades=" + listActividades +
                ", listExamen=" + listExamen +
                '}';
    }
}
