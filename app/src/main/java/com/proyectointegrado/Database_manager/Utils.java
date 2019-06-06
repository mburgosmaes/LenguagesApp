package com.proyectointegrado.Database_manager;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;


public class Utils {
    private static String SHA512 = "SHA-512";

    private static String toHexadecimal(byte[] digest) {
        String hash = "";
        for (byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }
            hash += Integer.toHexString(b);
        }
        return hash;
    }

    public static String encrypt_pass_sha512(String message) {
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SHA512);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();

        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("No se encontró el algoritmo de cifrado", ex);
        }
        return toHexadecimal(digest);
    }


    public static Temario montarTemario(String titulo, String desc, String estado, String nivel, int indice, ArrayList<Subtemarios> listSubtemario)
    {
        Temario temario = new Temario();

        temario.setTitulo(titulo);
        temario.setDescripcion(desc);
        temario.setEstadoTemario(estado);
        temario.setNivel(nivel);
        temario.setIndice(indice);
        temario.setListSubtemarios(listSubtemario);

        return temario;
    }

    public static Cursos montarCurso (String tituloCurso, String descripcionCurso, String idiomaCurso, String estadoCurso,
                                      String creadorCurso, String nivelCurso, int indiceCurso, String id_curso, List<Users> listUsuarios, List<Temario> listTemarios)
    {
        Cursos curso = new Cursos();

        curso.setId_curso(id_curso);
        curso.setTituloCurso(tituloCurso);
        curso.setCreadorCurso(creadorCurso);
        curso.setIdiomaCurso(idiomaCurso);
        curso.setEstadoCurso(estadoCurso);
        curso.setDescripcionCurso(descripcionCurso);
        curso.setNivelCurso(nivelCurso);
        curso.setIndiceCurso(indiceCurso);
        curso.setListTemarios(listTemarios);
        curso.setListUsuarios(listUsuarios);

        return curso;
    }
    public static Users montarUser(String id, String name, String surname,String email, String type)
    {
        Users users = new Users();
        users.setEmail(email);
        users.setId_user(id);
        users.setName(name);
        users.setSurname(surname);
        users.setType(type);

        return users;

    }

    public static Users montarUser2(String id, String type)
    {
        Users users = new Users();
        users.setId_user(id);
        users.setType(type);

        return users;

    }


}
