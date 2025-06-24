package com.rngproduction.capslock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class OnasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onas);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2C2C2C"));
            window.setNavigationBarColor(Color.parseColor("#222222"));
        }

        if (Utils.hasInetConnection(getApplicationContext())&&Utils.hostA==1) {
        } else {
            Utils.showToast(getApplicationContext(),"Упс.. Не удается загрузить некоторые объекты. Отсутствует связь с сервером.");
        }

        String onasImgURL1 = "https://**********/onas/onas1.jpg";
        ImageView onasImg1 = findViewById(R.id.imageOnas1);
        ImageManager.fetchImage(onasImgURL1, onasImg1);
    }

    public void onclck_menu1(View view) {
        Intent intent = new Intent(OnasActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void onclck_menu2(View view) {
        Intent intent = new Intent(OnasActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_menu3(View view) {
        Intent intent = new Intent(OnasActivity.this, CapsActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(OnasActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
    public void onclck_menu5(View view) {
        Intent intent = new Intent(OnasActivity.this, MoreActivity.class);
        startActivity(intent);
    }
}
