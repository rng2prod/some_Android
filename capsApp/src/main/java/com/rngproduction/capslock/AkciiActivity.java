package com.rngproduction.capslock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;


public class AkciiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Utils.hasInetConnection(getApplicationContext())) {Utils.checkHost();}
        setContentView(R.layout.activity_akcii);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2C2C2C"));
            window.setNavigationBarColor(Color.parseColor("#222222"));
        }

        String promoImgURL1B = "https://**********/caps_promo/caps_promo_big_1.jpg";
        String promoImgURL2B = "https://**********/caps_promo/caps_promo_big_2.jpg";
        String promoImgURL3B = "https://**********/caps_promo/caps_promo_big_3.jpg";
        String promoImgURL4B = "https://**********/caps_promo/caps_promo_big_4.jpg";
        String promoImgURL5B = "https://**********/caps_promo/caps_promo_big_5.jpg";
        String promoImgURL6B = "https://**********/caps_promo/caps_promo_big_6.jpg";

        ImageView promoImg1b = findViewById(R.id.imagePromoBig1);
        ImageView promoImg2b = findViewById(R.id.imagePromoBig2);
        ImageView promoImg3b = findViewById(R.id.imagePromoBig3);
        ImageView promoImg4b = findViewById(R.id.imagePromoBig4);
        ImageView promoImg5b = findViewById(R.id.imagePromoBig5);
        ImageView promoImg6b = findViewById(R.id.imagePromoBig6);
        ImageManager.fetchImage(promoImgURL1B, promoImg1b);
        ImageManager.fetchImage(promoImgURL2B, promoImg2b);
        ImageManager.fetchImage(promoImgURL3B, promoImg3b);
        ImageManager.fetchImage(promoImgURL4B, promoImg4b);
        ImageManager.fetchImage(promoImgURL5B, promoImg5b);
        ImageManager.fetchImage(promoImgURL6B, promoImg6b);

        if (Utils.hasInetConnection(getApplicationContext())&&Utils.hostA==1) {
        } else {
            Utils.showToast(getApplicationContext(),"Упс.. Не удается загрузить некоторые объекты. Отсутствует связь с сервером.");
        }


        ScrollView scrl = (ScrollView) findViewById(R.id.scrlPromo);
        ImageView sv;
        switch (HomeActivity.poz) {
            case (1):
                sv = (ImageView) findViewById(R.id.imagePromoBig1);break;
            case (2):
                sv = (ImageView) findViewById(R.id.imagePromoBig2);break;
            case (3):
                sv = (ImageView) findViewById(R.id.imagePromoBig3);break;
            case (4):
                sv = (ImageView) findViewById(R.id.imagePromoBig4);break;
            case (5):
                sv = (ImageView) findViewById(R.id.imagePromoBig5);break;
            case (6):
                sv = (ImageView) findViewById(R.id.imagePromoBig6);break;
            default:
                throw new IllegalStateException("Unexpected value: " + HomeActivity.poz);
        }
        scrl.scrollTo(0, sv.getBottom());
    }


    public void onclck_menu1(View view) {
        Intent intent = new Intent(AkciiActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void onclck_menu2(View view) {
        Intent intent = new Intent(AkciiActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_menu3(View view) {
        Intent intent = new Intent(AkciiActivity.this, CapsActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(AkciiActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
    public void onclck_menu5(View view) {
        Intent intent = new Intent(AkciiActivity.this, MoreActivity.class);
        startActivity(intent);
    }

}