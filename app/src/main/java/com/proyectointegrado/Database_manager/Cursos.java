package com.proyectointegrado.Database_manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cursos implements Serializable {
    private String tituloCurso, descripcionCurso, idiomaCurso, estadoCurso, creadorCurso, nivelCurso;
    private  int indiceCurso;
    private String fecha_inicioCurso, fecha_finCurso, fecha_inscripcionCurso;
    private String id_curso;
    private List<Users> listUsuarios;
    private List<Temario> listTemarios;


    public Cursos() {
    }

    public Cursos(String tituloCurso, String descripcionCurso, String idiomaCurso, String estadoCurso, String creadorCurso, String nivelCurso, int indiceCurso,
                  String fecha_inicioCurso, String fecha_finCurso, String fecha_inscripcionCurso, String id_curso,
                  List<Users> listUsuarios, List<Temario> listTemarios) {
        this.tituloCurso = tituloCurso;
        this.descripcionCurso = descripcionCurso;
        this.idiomaCurso = idiomaCurso;
        this.estadoCurso = estadoCurso;
        this.creadorCurso = creadorCurso;
        this.nivelCurso = nivelCurso;
        this.indiceCurso = indiceCurso;
        this.fecha_inicioCurso = fecha_inicioCurso;
        this.fecha_finCurso = fecha_finCurso;
        this.fecha_inscripcionCurso = fecha_inscripcionCurso;
        this.id_curso = id_curso;
        this.listUsuarios = listUsuarios;
        this.listTemarios = listTemarios;
    }

    public String getCreadorCurso() {
        return creadorCurso;
    }

    public void setCreadorCurso(String creadorCurso) {
        this.creadorCurso = creadorCurso;
    }


    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public String getIdiomaCurso() {
        return idiomaCurso;
    }

    public void setIdiomaCurso(String idiomaCurso) {
        this.idiomaCurso = idiomaCurso;
    }

    public String getEstadoCurso() {
        return estadoCurso;
    }

    public void setEstadoCurso(String estadoCurso) {
        this.estadoCurso = estadoCurso;
    }

    public String getFecha_inicioCurso() {
        return fecha_inicioCurso;
    }

    public void setFecha_inicioCurso(String fecha_inicioCurso) {
        this.fecha_inicioCurso = fecha_inicioCurso;
    }

    public String getFecha_finCurso() {
        return fecha_finCurso;
    }

    public void setFecha_finCurso(String fecha_finCurso) {
        this.fecha_finCurso = fecha_finCurso;
    }

    public String getFecha_inscripcionCurso() {
        return fecha_inscripcionCurso;
    }

    public void setFecha_inscripcionCurso(String fecha_inscripcionCurso) {
        this.fecha_inscripcionCurso = fecha_inscripcionCurso;
    }

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }

    public String getNivelCurso() {
        return nivelCurso;
    }

    public void setNivelCurso(String nivelCurso) {
        this.nivelCurso = nivelCurso;
    }

    public int getIndiceCurso() {
        return indiceCurso;
    }

    public void setIndiceCurso(int indiceCurso) {
        this.indiceCurso = indiceCurso;
    }

    public List<Users> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Users> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Temario> getListTemarios() {
        return listTemarios;
    }

    public void setListTemarios(List<Temario> listTemarios) {
        this.listTemarios = listTemarios;
    }

    @Override
    public String toString() {
        return "Cursos{" +
                "tituloCurso='" + tituloCurso + '\'' +
                ", descripcionCurso='" + descripcionCurso + '\'' +
                ", idiomaCurso='" + idiomaCurso + '\'' +
                ", estadoCurso='" + estadoCurso + '\'' +
                ", creadorCurso='" + creadorCurso + '\'' +
                ", nivelCurso='" + nivelCurso + '\'' +
                ", indiceCurso=" + indiceCurso +
                ", fecha_inicioCurso='" + fecha_inicioCurso + '\'' +
                ", fecha_finCurso='" + fecha_finCurso + '\'' +
                ", fecha_inscripcionCurso='" + fecha_inscripcionCurso + '\'' +
                ", id_curso='" + id_curso + '\'' +
                ", listUsuarios=" + listUsuarios +
                ", listTemarios=" + listTemarios +
                '}';
    }
}
