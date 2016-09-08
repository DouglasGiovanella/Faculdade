package com.example.dougl.appbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class LoadingActivity extends AppCompatActivity {

    protected static final int TIMER_RUNTIME = 10000;
    protected boolean mbActive;
    protected ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading);

        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);

        final Thread timerThread = new Thread(){
            Intent intent = new Intent(LoadingActivity.this, LoginActivity.class);
            @Override
            public void run(){
                mbActive = true;
                try {
                    sleep(100);
                    int waited =0;
                    while(mbActive && (waited < TIMER_RUNTIME)){
                        sleep(40);
                        if(mbActive){
                            waited += 100;
                            updateProgress(waited);
                        }
                    }
                }catch (InterruptedException e){
                }finally {
                    //Chamar outra Activity aqui
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    public void updateProgress(final int timePassed){
        if(null != mProgressBar){
            final int progress = mProgressBar.getMax() * timePassed/ TIMER_RUNTIME;
            mProgressBar.setProgress(progress);
        }
    }


}
