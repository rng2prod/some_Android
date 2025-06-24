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


public class GetMealActivity extends AppCompatActivity {
    String contact = "*********";
    String urlwhatsapp = "https://api.whatsapp.com/send?phone=" + contact;
    String urlmealvariants = "https://**********";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getmeal);

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

        String getmealImgURL1 = "https://**********/meal/promo_meal.jpg";
        ImageView getmealImg1 = findViewById(R.id.imageGetMeal1);
        ImageManager.fetchImage(getmealImgURL1, getmealImg1);
    }

    public void onclck_getmealwalink(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlwhatsapp));
        startActivity(intent);
    }
    public void onclck_getmealvariantslink(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlmealvariants));
        startActivity(intent);
    }


    public void onclck_menu1(View view) {
        Intent intent = new Intent(GetMealActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void onclck_menu2(View view) {
        Intent intent = new Intent(GetMealActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_menu3(View view) {
        Intent intent = new Intent(GetMealActivity.this, CapsActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(GetMealActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
    public void onclck_menu5(View view) {
        Intent intent = new Intent(GetMealActivity.this, MoreActivity.class);
        startActivity(intent);
    }
}
