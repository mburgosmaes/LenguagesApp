package com.proyectointegrado.ClasesVideos;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.proyecto.appproyectointegrado.R;
import com.proyectointegrado.Database_manager.Cursos;

import java.io.IOException;

public class TemarioVideo extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView mYoutubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    private static String TAG ="PRUEBA";
    private static Cursos curso;
    private static VideoView vVideo;
    private static Button btn_ver;
    private static String [] urlY;
    private static String url;

    YouTubePlayerFragment myFragment;

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        /*Bundle bundle = getArguments();

        curso = (Cursos) bundle.getSerializable("OBJECTOCURSO");*/

        btn_ver = findViewById(R.id.btn_ver);
       // myFragment = (YouTubePlayerFragment) findViewById(R.id.fragment_seleccionado_c2);
       // myFragment.initialize(YoutubeConfig.getApiKey(),this);

        Log.i(TAG, "onCreateView: CURSO OBTENIDO:"+curso.toString());

        // vVideo = rootView.findViewById(R.id.videoView_temarioVideos);

        urlY=curso.getListTemarios().get(0)
                .getListSubtemarios().get(0).getListContenido().get(0).getUrlCon().split("=");

        String url = urlY[1];
        Log.i(TAG, "onCreateView: URL: "+url);

         mYoutubePlayerView =(YouTubePlayerView) findViewById(R.id.view_youtubePlayer);

    }

  /*  @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_temarios_video, container, false);
        Bundle bundle = getArguments();

        curso = (Cursos) bundle.getSerializable("OBJECTOCURSO");

        btn_ver = rootView.findViewById(R.id.btn_ver);

        Log.i(TAG, "onCreateView: CURSO OBTENIDO:"+curso.toString());

       // vVideo = rootView.findViewById(R.id.videoView_temarioVideos);

        urlY=curso.getListTemarios().get(0)
                .getListSubtemarios().get(0).getListContenido().get(0).getUrlCon().split("=");

        url = urlY[1];
        Log.i(TAG, "onCreateView: URL: "+url);


        mYoutubePlayerView =(YouTubePlayerView) rootView.findViewById(R.id.view_youtubePlayer);
        YouTubePlayerSupportFragment youTubePlayerSupportFragment =

        mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListener);



        return rootView;

    }*/
}
