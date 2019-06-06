package com.proyectointegrado.Database_manager;

import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private List<ActividadEjTest> listActividadEjTest;
    private List<ActividadEjRellenar> listActividadEjRellenar;
    private String tituloActividad, descActividad, estadoActividad, tipoActividad;

    public Actividad()
    {

    }

    public Actividad(List<ActividadEjTest> listActividadEjTest, List<ActividadEjRellenar> listActividadEjRellenar, String tituloActividad, String descActividad, String estadoActividad, String tipoActividad) {
        this.listActividadEjTest = listActividadEjTest;
        this.listActividadEjRellenar = listActividadEjRellenar;
        this.tituloActividad = tituloActividad;
        this.descActividad = descActividad;
        this.estadoActividad = estadoActividad;
        this.tipoActividad = tipoActividad;
    }

    public String getTituloActividad() {
        return tituloActividad;
    }

    public void setTituloActividad(String tituloActividad) {
        this.tituloActividad = tituloActividad;
    }

    public String getDescActividad() {
        return descActividad;
    }

    public void setDescActividad(String descActividad) {
        this.descActividad = descActividad;
    }

    public String getEstadoActividad() {
        return estadoActividad;
    }

    public void setEstadoActividad(String estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

    public List<ActividadEjTest> getListActividadEjTest() {
        return listActividadEjTest;
    }

    public void setListActividadEjTest(List<ActividadEjTest> listActividadEjTest) {
        this.listActividadEjTest = listActividadEjTest;
    }

    public List<ActividadEjRellenar> getListActividadEjRellenar() {
        return listActividadEjRellenar;
    }

    public void setListActividadEjRellenar(List<ActividadEjRellenar> listActividadEjRellenar) {
        this.listActividadEjRellenar = listActividadEjRellenar;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "listActividadEjTest=" + listActividadEjTest +
                ", listActividadEjRellenar=" + listActividadEjRellenar +
                ", tituloActividad='" + tituloActividad + '\'' +
                ", descActividad='" + descActividad + '\'' +
                ", estadoActividad='" + estadoActividad + '\'' +
                ", tipoActividad='" + tipoActividad + '\'' +
                '}';
    }
}

