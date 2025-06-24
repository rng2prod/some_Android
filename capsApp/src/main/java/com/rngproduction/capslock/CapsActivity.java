package com.rngproduction.capslock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class CapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caps);

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


        AdaptertoCaps adapter = new AdaptertoCaps(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.viewpagercaps);
        viewPager.setAdapter(adapter); // устанавливаем адаптер
        viewPager.setCurrentItem(1);  // начинаем с центрального экрана

    }



    public static class AdaptertoCaps extends FragmentPagerAdapter {
           AdaptertoCaps(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

           @Override
           public CharSequence getPageTitle(int position) {
               switch (position) {
                   case 0: return "some text";
                   case 1: return "some text";
                   case 2: return "some text";
                   default: return null;
               }
           };



        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CapsFirstFragment();
                case 1:
                    return new CapsSecondFragment();
                case 2:
                    return new CapsThirdFragment();

                default:
                    return new CapsFirstFragment();
            }
        }
    }

    public void onclck_menu1(View view) {
        Intent intent = new Intent(CapsActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void onclck_menu2(View view) {
        Intent intent = new Intent(CapsActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(CapsActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
    public void onclck_menu5(View view) {
        Intent intent = new Intent(CapsActivity.this, MoreActivity.class);
        startActivity(intent);
    }

}