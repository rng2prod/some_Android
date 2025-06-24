package com.rngproduction.capslock;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;


public class FullscreenVideo extends Activity {

        private final static String TAG = "FullscreenVideo";
        VideoView videoView = null;
        int currenttime = 0;
        String Url="";


        @Override
        protected void onCreate(Bundle savedInstanceState) {

            Log.d(TAG, "Video number: " + InstructionsActivity.isVideo);
            super.onCreate(savedInstanceState);

            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                currenttime = extras.getInt("currenttime", 0);
                Url=extras.getString("Url");
            }
            setContentView(R.layout.fullscreen_video);

            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.parseColor("#2C2C2C"));
                window.setNavigationBarColor(Color.parseColor("#222222"));
            }

            TextView textViewVideoPlayer = (TextView) findViewById(R.id.textViewVideoPlayer);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

            if (InstructionsActivity.isVideo==1) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}
            if (InstructionsActivity.isVideo==2) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}
            if (InstructionsActivity.isVideo==3) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}
            if (InstructionsActivity.isVideo==4) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}
            if (InstructionsActivity.isVideo==5) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}
            if (InstructionsActivity.isVideo==6) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}
            if (InstructionsActivity.isVideo==7) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}
            if (InstructionsActivity.isVideo==8) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}
            if (InstructionsActivity.isVideo==9) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}
            if (InstructionsActivity.isVideo==10) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}
            if (InstructionsActivity.isVideo==11) {textViewVideoPlayer.setText("some text");
                Log.d(TAG, "Set Text on VideoPlayer: " + InstructionsActivity.isVideo);}

            if (Utils.hasInetConnection(getApplicationContext())&&Utils.hostA==1) {
            } else {
                Utils.showToast(getApplicationContext(),"Упс.. Не удается загрузить видео. Отсутствует связь с сервером.");
            }

            progressBar.setVisibility(ProgressBar.VISIBLE); //делаем с progressbar чтобы не блокировать ui

            videoView = (VideoView) findViewById(R.id.VideoViewfull);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);

            Uri video = Uri.parse(Url);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(video);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer arg0) {
                    //progressDialog.dismiss();
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    videoView.requestFocus();
                    videoView.start();
                    videoView.seekTo(currenttime);
                }
            });


            final Animation animHover = AnimationUtils.loadAnimation(this, R.anim.animclck2);
            View VideoBtnClose = findViewById(R.id.VideoBtnClose);
            VideoBtnClose.setOnClickListener(view -> {
                InstructionsActivity.isVideo = 0;
                Log.d(TAG, "Set isVideo = 0: " + InstructionsActivity.isVideo);
                view.startAnimation(animHover);
                Intent intent = new Intent(FullscreenVideo.this, InstructionsActivity.class);
                startActivity(intent);
            });
        }

        @Override
        public void finish() {
            Intent data = new Intent();
            data.putExtra("currenttime", videoView.getCurrentPosition());
            setResult(RESULT_OK, data);
            super.finish();
        }
    }

