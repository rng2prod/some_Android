package com.rngproduction.capslock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;


public class InstructionsActivity extends AppCompatActivity {

    final int REQUEST_CODE = 5000;
    public static int isVideo = 0;

    final String videoToPlay1 = "https://**********/capslockvideo/instruction_******.mp4";
    final String videoToPlay2 = "https://**********/capslockvideo/instruction_******.mp4";
    final String videoToPlay3 = "https://**********/capslockvideo/instruction_******.mp4";
    final String videoToPlay4 = "https://**********/capslockvideo/instruction_******.mp4";
    final String videoToPlay5 = "https://**********/capslockvideo/instruction_******.mp4";
    final String videoToPlay6 = "https://**********/capslockvideo/instruction_******.mp4";
    final String videoToPlay7 = "https://**********/capslockvideo/instruction_******.mp4";
    final String videoToPlay8 = "https://**********/capslockvideo/instruction_******.mp4";
    final String videoToPlay9 = "https://**********/capslockvideo/instruction_******.mp4";
    final String videoToPlay10 = "https://**********/capslockvideo/instruction_******.mp4";
    final String videoToPlay11 = "https://**********/capslockvideo/instruction_******.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2C2C2C"));
            window.setNavigationBarColor(Color.parseColor("#222222"));
        }

        final Animation animHover = AnimationUtils.loadAnimation(this, R.anim.animclck2);
        View btnInstr1Play = findViewById(R.id.instrlinear1);
        View btnInstr2Play = findViewById(R.id.instrlinear2);
        View btnInstr3Play = findViewById(R.id.instrlinear3);
        View btnInstr4Play = findViewById(R.id.instrlinear4);
        View btnInstr5Play = findViewById(R.id.instrlinear5);
        View btnInstr6Play = findViewById(R.id.instrlinear6);
        View btnInstr7Play = findViewById(R.id.instrlinear7);
        View btnInstr8Play = findViewById(R.id.instrlinear8);
        View btnInstr9Play = findViewById(R.id.instrlinear9);
        View btnInstr10Play = findViewById(R.id.instrlinear10);
        View btnInstr11Play = findViewById(R.id.instrlinear11);

        btnInstr1Play.setOnClickListener(v -> {
            isVideo = 1 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay1);
            startActivityForResult(videointent, REQUEST_CODE);
        });
        btnInstr2Play.setOnClickListener(v -> {
            isVideo = 2 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay2);
            startActivityForResult(videointent, REQUEST_CODE);
        });
        btnInstr3Play.setOnClickListener(v -> {
            isVideo = 3 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay3);
            startActivityForResult(videointent, REQUEST_CODE);
        });
        btnInstr4Play.setOnClickListener(v -> {
            isVideo = 4 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay4);
            startActivityForResult(videointent, REQUEST_CODE);
        });
        btnInstr5Play.setOnClickListener(v -> {
            isVideo = 5 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay5);
            startActivityForResult(videointent, REQUEST_CODE);
        });
        btnInstr6Play.setOnClickListener(v -> {
            isVideo = 6 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay6);
            startActivityForResult(videointent, REQUEST_CODE);
        });
        btnInstr7Play.setOnClickListener(v -> {
            isVideo = 7 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay7);
            startActivityForResult(videointent, REQUEST_CODE);
        });
        btnInstr8Play.setOnClickListener(v -> {
            isVideo = 8 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay8);
            startActivityForResult(videointent, REQUEST_CODE);
        });
        btnInstr9Play.setOnClickListener(v -> {
            isVideo = 9 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay9);
            startActivityForResult(videointent, REQUEST_CODE);
        });
        btnInstr10Play.setOnClickListener(v -> {
            isVideo = 10 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay10);
            startActivityForResult(videointent, REQUEST_CODE);
        });
        btnInstr11Play.setOnClickListener(v -> {
            isVideo = 11 ;
            v.startAnimation(animHover);
            Intent videointent = new Intent(InstructionsActivity.this, FullscreenVideo.class);
            videointent.putExtra("Url", videoToPlay11);
            startActivityForResult(videointent, REQUEST_CODE);
        });

    }




    public void onclck_menu1(View view) {
        Intent intent = new Intent(InstructionsActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void onclck_menu2(View view) {
        Intent intent = new Intent(InstructionsActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_menu3(View view) {
        Intent intent = new Intent(InstructionsActivity.this, CapsActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(InstructionsActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
    public void onclck_menu5(View view) {
        Intent intent = new Intent(InstructionsActivity.this, MoreActivity.class);
        startActivity(intent);
    }
}
