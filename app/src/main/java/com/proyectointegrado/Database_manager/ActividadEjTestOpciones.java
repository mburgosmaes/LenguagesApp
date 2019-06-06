package com.proyectointegrado.Database_manager;

import java.util.ArrayList;
import java.util.List;

public class ActividadEjTestOpciones {

    private List<ActividadEjTestOpcionesOp> listActividadEjTestOpcionesOp;

    public ActividadEjTestOpciones()
    {

    }

    public ActividadEjTestOpciones(List<ActividadEjTestOpcionesOp> listActividadEjTestOpcionesOp) {
        this.listActividadEjTestOpcionesOp = listActividadEjTestOpcionesOp;
    }

    public List<ActividadEjTestOpcionesOp> getListActividadEjTestOpcionesOp() {
        return listActividadEjTestOpcionesOp;
    }

    public void setListActividadEjTestOpcionesOp(List<ActividadEjTestOpcionesOp> listActividadEjTestOpcionesOp) {
        this.listActividadEjTestOpcionesOp = listActividadEjTestOpcionesOp;
    }

    @Override
    public String toString() {
        return "ActividadEjTestOpciones{" +
                "listActividadEjTestOpcionesOp=" + listActividadEjTestOpcionesOp +
                '}';
    }
}
