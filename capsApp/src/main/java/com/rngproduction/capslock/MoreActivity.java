package com.rngproduction.capslock;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2C2C2C"));
            window.setNavigationBarColor(Color.parseColor("#222222"));
        }

        final Animation animHover = AnimationUtils.loadAnimation(this, R.anim.animclck);
        String urlBookingCom = "https://**********";
        String urlHostelCapsLockCom = "https://**********";
        String urlYandexMapLegal = "https://**********";

        Button btnMore1 = (Button) findViewById(R.id.moremenu1);
        Button btnMore2 = (Button) findViewById(R.id.moremenu2);
        Button btnMore3 = (Button) findViewById(R.id.moremenu3);
        Button btnMore4 = (Button) findViewById(R.id.moremenu4);
        Button btnMore5 = (Button) findViewById(R.id.moremenu5);
        Button btnMore6 = (Button) findViewById(R.id.moremenu6);
        Button btnMore7 = (Button) findViewById(R.id.moremenu7);

        btnMore1.setOnClickListener(view -> {
            view.startAnimation(animHover);
            Intent intent = new Intent(MoreActivity.this, OnasActivity.class);
            startActivity(intent);
        });
        btnMore2.setOnClickListener(view -> {
            view.startAnimation(animHover);
            Intent intent = new Intent(MoreActivity.this, MapActivity.class);
            startActivity(intent);
        });
        btnMore3.setOnClickListener(view -> {
            view.startAnimation(animHover);
            Intent intent = new Intent(MoreActivity.this, InstructionsActivity.class);
            startActivity(intent);
        });
        btnMore4.setOnClickListener(view -> {
            view.startAnimation(animHover);
            Intent intent = new Intent(MoreActivity.this, VisasupportActivity.class);
            startActivity(intent);
        });
        btnMore5.setOnClickListener(view -> {
            view.startAnimation(animHover);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(urlBookingCom));
            startActivity(intent);
        });
        btnMore6.setOnClickListener(view -> {
            view.startAnimation(animHover);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(urlHostelCapsLockCom));
            startActivity(intent);
        });
        btnMore7.setOnClickListener(view -> {
            view.startAnimation(animHover);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(urlYandexMapLegal));
            startActivity(intent);
        });
    }



    public void onclck_menu1(View view) {
        Intent intent = new Intent(MoreActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void onclck_menu2(View view) {
        Intent intent = new Intent(MoreActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_menu3(View view) {
        Intent intent = new Intent(MoreActivity.this, CapsActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(MoreActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
}