package com.proyectointegrado.Database_manager;

import java.util.ArrayList;
import java.util.List;

public class ExamenExTestOpciones {
    private List<ExamenExTestOpcionesOp> listExamenExTestOpcionesOp;

    public ExamenExTestOpciones()
    {

    }

    public ExamenExTestOpciones(List<ExamenExTestOpcionesOp> listExamenExTestOpcionesOp) {
        this.listExamenExTestOpcionesOp = listExamenExTestOpcionesOp;
    }

    public List<ExamenExTestOpcionesOp> getListExamenExTestOpcionesOp() {
        return listExamenExTestOpcionesOp;
    }

    public void setListExamenExTestOpcionesOp(List<ExamenExTestOpcionesOp> listExamenExTestOpcionesOp) {
        this.listExamenExTestOpcionesOp = listExamenExTestOpcionesOp;
    }

    @Override
    public String toString() {
        return "ExamenExTestOpciones{" +
                "listExamenExTestOpcionesOp=" + listExamenExTestOpcionesOp +
                '}';
    }
}
