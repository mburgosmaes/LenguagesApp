package com.proyectointegrado.MenuPrincipal;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.drm.DrmStore;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.Cursos.Cursos_inicio;
import com.proyectointegrado.Exercises.DragAndDrop;
import com.proyectointegrado.Login.Registre_activity;

public class PageViewModel extends ViewModel {

   private static String tag_Activity="StarActivity";
   private static SharedPreferences sharedPreferences;
   private static Context context;


    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    private LiveData<Integer> f= Transformations.map(mIndex, new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer input) {
            Integer input2=input;
            Log.i("PAGEVIEWMODEL", input2.toString());

            return input2;
        }
    });

    /*private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            String resultado="";
           sharedPreferences = context.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

           switch (input)
            {
                case 1:
                    resultado="Activity1";
                    editor.putString("Menu", "Inicio");4
                    editor.commit();
                  //  Snackbar.make(this, "PRUEBAAAAAAAAAAAAAAAAAAA", Snackbar.LENGTH_SHORT;
                    break;

                case 2:
                    resultado="Activity2";
                    break;

                case 3:
                    resultado="Activity3";
                    break;

                case 4:
                    resultado="Activity4";
                    break;
            }


            return resultado;
        }
    });*/

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    /*public LiveData<String> getText() {
        return mText;
    }*/

}