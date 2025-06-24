package com.rngproduction.capslock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.yandex.mapkit.MapKitFactory;

public class MainActivity extends AppCompatActivity {

    private final String MAPKIT_API_KEY = "*******************";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                   WindowManager.LayoutParams.FLAG_FULLSCREEN);


        if (Utils.hasInetConnection(getApplicationContext())) {
            Utils.checkHost();
            Utils.checkHostBookingOur();
            Utils.checkHostBookingAlien();
            Utils.checkHostExcursionOur();
            Utils.checkHostExcursionAlien();
            Utils.checkHostVisaSupportOur();
            Utils.checkHostVisaSupportAlien(); }

        setContentView(R.layout.splash_logo);

           if (Build.VERSION.SDK_INT >= 21) {
               Window window = getWindow();
               window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
               window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
               window.setStatusBarColor(Color.parseColor("#2C2C2C"));
               window.setNavigationBarColor(Color.parseColor("#222222"));
           }

        MapKitFactory.setApiKey(MAPKIT_API_KEY);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, 1500);


    }

    @Override
    protected void onStop() {
        super.onStop();
        Utils.deleteCache(getApplicationContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Utils.deleteCache(getApplicationContext());
    }

}