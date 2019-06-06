package com.proyectointegrado.Database_manager;

public class ActividadEjTestImagenes {

    private int indiceActividadEjTestImagenes;
    private String urlActividadEjTestImagenes;

    public ActividadEjTestImagenes()
    {

    }

    public ActividadEjTestImagenes(int indiceActividadEjTestImagenes, String urlActividadEjTestImagenes) {
        this.indiceActividadEjTestImagenes = indiceActividadEjTestImagenes;
        this.urlActividadEjTestImagenes = urlActividadEjTestImagenes;
    }

    public int getIndiceActividadEjTestImagenes() {
        return indiceActividadEjTestImagenes;
    }

    public void setIndiceActividadEjTestImagenes(int indiceActividadEjTestImagenes) {
        this.indiceActividadEjTestImagenes = indiceActividadEjTestImagenes;
    }

    public String getUrlActividadEjTestImagenes() {
        return urlActividadEjTestImagenes;
    }

    public void setUrlActividadEjTestImagenes(String urlActividadEjTestImagenes) {
        this.urlActividadEjTestImagenes = urlActividadEjTestImagenes;
    }

    @Override
    public String toString() {
        return "ActividadEjTestImagenes{" +
                "indiceActividadEjTestImagenes=" + indiceActividadEjTestImagenes +
                ", urlActividadEjTestImagenes='" + urlActividadEjTestImagenes + '\'' +
                '}';
    }
}
