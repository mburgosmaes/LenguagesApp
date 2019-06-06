package com.proyectointegrado.Database_manager;

import java.util.ArrayList;
import java.util.List;

public class ActividadEjTest {

    private List<ActividadEjTestImagenes> listActividadEjTestImagenes;
    private List<ActividadEjTestOpciones> listActividadEjTestOpciones;

    public ActividadEjTest()
    {

    }

    public ActividadEjTest(List<ActividadEjTestImagenes> listActividadEjTestImagenes, List<ActividadEjTestOpciones> listActividadEjTestOpciones) {
        this.listActividadEjTestImagenes = listActividadEjTestImagenes;
        this.listActividadEjTestOpciones = listActividadEjTestOpciones;
    }

    public List<ActividadEjTestImagenes> getListActividadEjTestImagenes() {
        return listActividadEjTestImagenes;
    }

    public void setListActividadEjTestImagenes(List<ActividadEjTestImagenes> listActividadEjTestImagenes) {
        this.listActividadEjTestImagenes = listActividadEjTestImagenes;
    }

    public List<ActividadEjTestOpciones> getListActividadEjTestOpciones() {
        return listActividadEjTestOpciones;
    }

    public void setListActividadEjTestOpciones(List<ActividadEjTestOpciones> listActividadEjTestOpciones) {
        this.listActividadEjTestOpciones = listActividadEjTestOpciones;
    }

    @Override
    public String toString() {
        return "ActividadEjTest{" +
                "listActividadEjTestImagenes=" + listActividadEjTestImagenes +
                ", listActividadEjTestOpciones=" + listActividadEjTestOpciones +
                '}';
    }
}
