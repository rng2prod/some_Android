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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class HomeActivity extends AppCompatActivity {

    static int poz;
    String contact = "***********";
    String urlwhatsapp = "https://api.whatsapp.com/send?phone=" + contact;
    String urlVk = "**********";
    String urltelegram = "**********";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Utils.hasInetConnection(getApplicationContext())) {Utils.checkHost();}
        setContentView(R.layout.activity_home);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2C2C2C"));
            window.setNavigationBarColor(Color.parseColor("#222222"));
        }

        String promoImgURL1 = "https://**********/caps_promo/caps_promo_1.jpg";
        String promoImgURL2 = "https://**********/caps_promo/caps_promo_2.jpg";
        String promoImgURL3 = "https://**********/caps_promo/caps_promo_3.jpg";
        String promoImgURL4 = "https://**********/caps_promo/caps_promo_4.jpg";
        String promoImgURL5 = "https://**********/caps_promo/caps_promo_5.jpg";
        String promoImgURL6 = "https://**********/caps_promo/caps_promo_6.jpg";

        ImageView promoImg1 = findViewById(R.id.imagePromo1);
        ImageView promoImg2 = findViewById(R.id.imagePromo2);
        ImageView promoImg3 = findViewById(R.id.imagePromo3);
        ImageView promoImg4 = findViewById(R.id.imagePromo4);
        ImageView promoImg5 = findViewById(R.id.imagePromo5);
        ImageView promoImg6 = findViewById(R.id.imagePromo6);

        ImageManager.fetchImage(promoImgURL1, promoImg1);
        ImageManager.fetchImage(promoImgURL2, promoImg2);
        ImageManager.fetchImage(promoImgURL3, promoImg3);
        ImageManager.fetchImage(promoImgURL4, promoImg4);
        ImageManager.fetchImage(promoImgURL5, promoImg5);
        ImageManager.fetchImage(promoImgURL6, promoImg6);



        if (Utils.hasInetConnection(getApplicationContext())&&Utils.hostA==1) {
        } else {
          Utils.showToast(getApplicationContext(),"Упс.. Не удается загрузить некоторые объекты. Отсутствует связь с сервером.");
        }

        AdaptertoMainPromo adapterP = new AdaptertoMainPromo(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.viewpagermain);
        viewPager.setAdapter(adapterP);
        viewPager.setCurrentItem(0);  // начинаем с первого экрана

  }


    public static class AdaptertoMainPromo extends FragmentPagerAdapter {
        AdaptertoMainPromo(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFirstPromoFragment();
                case 1:
                    return new HomeSecondPromoFragment();
                case 2:
                    return new HomeThirdPromoFragment();
                case 3:
                    return new HomeFourthPromoFragment();
                default:
                    return new HomeFirstPromoFragment();
            }
        }
    }
    public void onclck_booking(View view) {
        Intent intent = new Intent(HomeActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_excursion(View view) {
        Intent intent = new Intent(HomeActivity.this, ExcursionActivity.class);
        startActivity(intent);
    }
    public void onclck_meal(View view) {
        Intent intent = new Intent(HomeActivity.this, GetMealActivity.class);
        startActivity(intent);
    }
    public void onclck_bbq(View view) {
        Intent intent = new Intent(HomeActivity.this, BbqActivity.class);
        startActivity(intent);
    }
    public void onclck_akva(View view) {
        Intent intent = new Intent(HomeActivity.this, AkvaActivity.class);
        startActivity(intent);
    }
    public void onclck_promo1(View view) {
        poz=1;
        //Log.v(TAGHOME, "Home link Poz:" + poz);
        Intent intent = new Intent(HomeActivity.this, AkciiActivity.class);
        startActivity(intent);
    }
    public void onclck_promo2(View view) {
        poz=2;
        //Log.v(TAGHOME, "Home link Poz:" + poz);
        Intent intent = new Intent(HomeActivity.this, AkciiActivity.class);
        startActivity(intent);
    }
    public void onclck_promo3(View view) {
        poz=3;
        //Log.v(TAGHOME, "Home link Poz:" + poz);
        Intent intent = new Intent(HomeActivity.this, AkciiActivity.class);
        startActivity(intent);
    }
    public void onclck_promo4(View view) {
        poz=4;
        //Log.v(TAGHOME, "Home link Poz:" + poz);
        Intent intent = new Intent(HomeActivity.this, AkciiActivity.class);
        startActivity(intent);
    }
    public void onclck_promo5(View view) {
        poz=5;
        //Log.v(TAGHOME, "Home link Poz:" + poz);
        Intent intent = new Intent(HomeActivity.this, AkciiActivity.class);
        startActivity(intent);
    }
    public void onclck_promo6(View view) {
        poz=6;
        //Log.v(TAGHOME, "Home link Poz:" + poz);
        Intent intent = new Intent(HomeActivity.this, AkciiActivity.class);
        startActivity(intent);
    }

  
    public void onclck_towhatsapp(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlwhatsapp));
        startActivity(intent);
    }

    public void onclck_totelegram(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urltelegram));
        startActivity(intent);
    }

    public void onclck_tovk(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlVk));
        startActivity(intent);
    }

    public void onclck_menu1(View view) {
    }
    public void onclck_menu2(View view) {
        Intent intent = new Intent(HomeActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_menu3(View view) {
        Intent intent = new Intent(HomeActivity.this, CapsActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(HomeActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
    public void onclck_menu5(View view) {
        Intent intent = new Intent(HomeActivity.this, MoreActivity.class);
        startActivity(intent);
    }

}
