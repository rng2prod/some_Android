package com.rngproduction.capslock;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class BookingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Utils.hasInetConnection(getApplicationContext())) {
            Utils.checkHostBookingOur();
            Utils.checkHostBookingAlien();
        }

        setContentView(R.layout.activity_booking);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2C2C2C"));
            window.setNavigationBarColor(Color.parseColor("#222222"));
        }

        WebView webView = (WebView) findViewById (R.id.webView_booking);

        String loadBookingURL ="https://**********"; 


        if (Utils.hasInetConnection(getApplicationContext())&&Utils.hostBookingOur==1&&Utils.hostBookingAlien==1) {
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            webView.loadUrl(loadBookingURL);

            webView.setWebViewClient(new WebViewClient() {
                
                @Override //логика ссылок
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url.contains("tel:")) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                        return true; //в телефон
                    }
                    if (url.contains("https://**********.pdf")) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                        return true; //в браузер
                    }
                    return url.contains("https://**********");
                }

            });
        } else {
            webView.setBackgroundColor(Color.parseColor("#4F5254"));
            Utils.showToast(getApplicationContext(),"Модуль ****** недоступен. Отсутствует связь с сервером.");
        }
    }

    public void onclck_menu1(View view) {
        Intent intent = new Intent(BookingActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void onclck_menu3(View view) {
        Intent intent = new Intent(BookingActivity.this, CapsActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(BookingActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
    public void onclck_menu5(View view) {
        Intent intent = new Intent(BookingActivity.this, MoreActivity.class);
        startActivity(intent);
    }

}