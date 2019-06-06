package com.proyectointegrado.Database_manager;

import java.util.ArrayList;
import java.util.List;

public class ExamenExTest {

    private String preguntaExamenExTest;
    private int indiceExamenExTest;
    private List<ExamenExTestOpciones> listExamenExTestOpciones;

    public ExamenExTest()
    {

    }

    public ExamenExTest(String preguntaExamenExTest, int indiceExamenExTest, List<ExamenExTestOpciones> listExamenExTestOpciones) {
        this.preguntaExamenExTest = preguntaExamenExTest;
        this.indiceExamenExTest = indiceExamenExTest;
        this.listExamenExTestOpciones = listExamenExTestOpciones;
    }

    public String getPreguntaExamenExTest() {
        return preguntaExamenExTest;
    }

    public void setPreguntaExamenExTest(String preguntaExamenExTest) {
        this.preguntaExamenExTest = preguntaExamenExTest;
    }

    public int getIndiceExamenExTest() {
        return indiceExamenExTest;
    }

    public void setIndiceExamenExTest(int indiceExamenExTest) {
        this.indiceExamenExTest = indiceExamenExTest;
    }

    public List<ExamenExTestOpciones> getListExamenExTestOpciones() {
        return listExamenExTestOpciones;
    }

    public void setListExamenExTestOpciones(List<ExamenExTestOpciones> listExamenExTestOpciones) {
        this.listExamenExTestOpciones = listExamenExTestOpciones;
    }

    @Override
    public String toString() {
        return "ExamenExTest{" +
                "preguntaExamenExTest='" + preguntaExamenExTest + '\'' +
                ", indiceExamenExTest=" + indiceExamenExTest +
                ", listExamenExTestOpciones=" + listExamenExTestOpciones +
                '}';
    }
}
