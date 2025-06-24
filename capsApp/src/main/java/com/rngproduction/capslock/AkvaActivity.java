package com.rngproduction.capslock;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class AkvaActivity extends AppCompatActivity {
    String contact = "*******";
    String urlwhatsapp = "https://api.whatsapp.com/send?phone=" + contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akva);

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

        String akvaImgURL1 = "https://**********/akva/akva1.jpg";
        ImageView akvaImg1 = findViewById(R.id.imageAkva1);
        ImageManager.fetchImage(akvaImgURL1, akvaImg1);

    }

    public void onclck_akvawalink(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlwhatsapp));
        startActivity(intent);
    }


    public void onclck_menu1(View view) {
        Intent intent = new Intent(AkvaActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void onclck_menu2(View view) {
        Intent intent = new Intent(AkvaActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_menu3(View view) {
        Intent intent = new Intent(AkvaActivity.this, CapsActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(AkvaActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
    public void onclck_menu5(View view) {
        Intent intent = new Intent(AkvaActivity.this, MoreActivity.class);
        startActivity(intent);
    }
}
