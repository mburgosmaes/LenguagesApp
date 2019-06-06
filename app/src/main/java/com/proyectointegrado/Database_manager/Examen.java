package com.proyectointegrado.Database_manager;

import java.util.ArrayList;
import java.util.List;

public class Examen {
    private List<ExamenExTest> listExamenExTest;
    private int notaExamen;

    public Examen()
    {

    }

    public List<ExamenExTest> getListExamenExTest() {
        return listExamenExTest;
    }

    public void setListExamenExTest(List<ExamenExTest> listExamenExTest) {
        this.listExamenExTest = listExamenExTest;
    }

    public int getNotaExamen() {
        return notaExamen;
    }

    public void setNotaExamen(int notaExamen) {
        this.notaExamen = notaExamen;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "listExamenExTest=" + listExamenExTest +
                ", notaExamen=" + notaExamen +
                '}';
    }
}
