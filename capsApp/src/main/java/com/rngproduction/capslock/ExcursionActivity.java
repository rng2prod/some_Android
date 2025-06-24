package com.rngproduction.capslock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;


public class ExcursionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Utils.hasInetConnection(getApplicationContext())) {
            Utils.checkHostExcursionOur();
            Utils.checkHostExcursionAlien();
        }

        setContentView(R.layout.activity_excursion);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2C2C2C"));
            window.setNavigationBarColor(Color.parseColor("#222222"));
        }

        WebView webView = (WebView) findViewById(R.id.webView_excursion);

        if (Utils.hasInetConnection(getApplicationContext())&&Utils.hostExcursionOur==1&&Utils.hostExcursionAlien==1) {
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl("*****************.html");
            webView.setWebViewClient(new WebViewClient());
        } else {
            webView.setBackgroundColor(Color.parseColor("#4F5254"));
            Utils.showToast(getApplicationContext(),"Модуль ****** недоступен. Отсутствует связь с сервером.");
        }
    }


    public void onclck_menu1(View view) {
        Intent intent = new Intent(ExcursionActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void onclck_menu2(View view) {
        Intent intent = new Intent(ExcursionActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_menu3(View view) {
        Intent intent = new Intent(ExcursionActivity.this, CapsActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(ExcursionActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
    public void onclck_menu5(View view) {
        Intent intent = new Intent(ExcursionActivity.this, MoreActivity.class);
        startActivity(intent);
    }
}