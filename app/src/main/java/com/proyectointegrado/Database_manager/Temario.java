package com.proyectointegrado.Database_manager;

import java.util.ArrayList;
import java.util.List;

public class Temario {

    private String nivel;
    private int indice;
    private String titulo;
    private String descripcion;
    private String id;
    private List<Subtemarios> listSubtemarios;
    private String estadoTemario;


    public Temario() {
    }

    public Temario(String nivel, int indice, String titulo, String descripcion, String id, List<Subtemarios> listSubtemarios, String estadoTemario) {
        this.nivel = nivel;
        this.indice = indice;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id = id;
        this.listSubtemarios = listSubtemarios;
        this.estadoTemario = estadoTemario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Subtemarios> getListSubtemarios() {
        return listSubtemarios;
    }

    public void setListSubtemarios(List<Subtemarios> listSubtemarios) {
        this.listSubtemarios = listSubtemarios;
    }

    public String getEstadoTemario() {
        return estadoTemario;
    }

    public void setEstadoTemario(String estadoTemario) {
        this.estadoTemario = estadoTemario;
    }

    @Override
    public String toString() {
        return "Temario{" +
                "nivel='" + nivel + '\'' +
                ", indice=" + indice +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", id='" + id + '\'' +
                ", listSubtemarios=" + listSubtemarios +
                ", estadoTemario='" + estadoTemario + '\'' +
                '}';
    }
}
