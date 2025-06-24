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


public class SpaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);

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

        AdaptertoSpace adapter = new AdaptertoSpace(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.viewpagercaps);
        viewPager.setAdapter(adapter); // устанавливаем адаптер
        viewPager.setCurrentItem(0);  // выводим первый экран
    }


    public static class AdaptertoSpace extends FragmentPagerAdapter {

        AdaptertoSpace(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return "some text";
                case 1: return "some text";
                case 2: return "some text";
                case 3: return "some text";
                case 4: return "some text";
                default: return null;
            }
        };

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new SpaceFirstFragment();
                case 1:
                    return new SpaceSecondFragment();
                case 2:
                    return new SpaceThirdFragment();
                case 3:
                    return new SpaceFourthFragment();
                case 4:
                    return new SpaceFifthFragment();
                default:
                    return new SpaceFirstFragment();
            }
        }
    }

    public void onclck_menu1(View view) {
        Intent intent = new Intent(SpaceActivity.this, HomeActivity.class);
        startActivity(intent);
    }
	
    public void onclck_menu2(View view) {
        Intent intent = new Intent(SpaceActivity.this, BookingActivity.class);
        startActivity(intent);
    }

    public void onclck_menu3(View view) {
        Intent intent = new Intent(SpaceActivity.this, CapsActivity.class);
        startActivity(intent);
    }

    public void onclck_menu5(View view) {
        Intent intent = new Intent(SpaceActivity.this, MoreActivity.class);
        startActivity(intent);
    }

}