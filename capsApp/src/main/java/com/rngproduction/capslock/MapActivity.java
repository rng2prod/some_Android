package com.rngproduction.capslock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.ImageProvider;


public class MapActivity extends AppCompatActivity {

    private final Point TARGET_LOCATION = new Point(**.829838, **.103868);

    private MapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#2C2C2C"));
            window.setNavigationBarColor(Color.parseColor("#222222"));
        }

        super.onCreate(savedInstanceState);
        mapView = (MapView) findViewById(R.id.mapview);

        // Маркер
        mapView.getMap().getMapObjects().addPlacemark(
                new Point(**.829838, **.103868),
                ImageProvider.fromResource(this, R.drawable.round_capslock_ico_map_marker));

        // Перемещение камеры
        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION, 17.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 4),
                null);

        final android.view.animation.Animation animHover = AnimationUtils.loadAnimation(this, R.anim.animclck);
        View zoomUp = findViewById(R.id.MapBtnUp);
        View zoomDown = findViewById(R.id.MapBtnDown);
        View capslock = findViewById(R.id.MapBtnCapsLock);


        capslock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capslock.startAnimation(animHover);
                mapView.getMap().move(
                        new CameraPosition(TARGET_LOCATION, 17.0f, 0.0f, 0.0f),
                        new Animation(Animation.Type.SMOOTH, 2),
                        null);
            }
        });
        zoomUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomUp.startAnimation(animHover);
                mapView.getMap().move(new CameraPosition(mapView.getMap().getCameraPosition().getTarget(),
                                mapView.getMap().getCameraPosition().getZoom()+1, 0.0f, 0.0f),
                        new Animation(Animation.Type.SMOOTH, 1),
                        null);
            }
        });
        zoomDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomDown.startAnimation(animHover);
                mapView.getMap().move(new CameraPosition(mapView.getMap().getCameraPosition().getTarget(),
                                mapView.getMap().getCameraPosition().getZoom()-1, 0.0f, 0.0f),
                        new Animation(Animation.Type.SMOOTH, 1),
                        null);
            }
        });

    }


        @Override
        protected void onStop() {
            // Вызов onStop нужно передавать инстансам MapView и MapKit.
            mapView.onStop();
            MapKitFactory.getInstance().onStop();
            super.onStop();
        }

        @Override
        protected void onStart() {
            // Вызов onStart нужно передавать инстансам MapView и MapKit.
            super.onStart();
            MapKitFactory.getInstance().onStart();
            mapView.onStart();
        }



    public void onclck_menu1(View view) {
        Intent intent = new Intent(MapActivity.this, HomeActivity.class);
        startActivity(intent);
    }
    public void onclck_menu2(View view) {
        Intent intent = new Intent(MapActivity.this, BookingActivity.class);
        startActivity(intent);
    }
    public void onclck_menu3(View view) {
        Intent intent = new Intent(MapActivity.this, CapsActivity.class);
        startActivity(intent);
    }
    public void onclck_menu4(View view) {
        Intent intent = new Intent(MapActivity.this, SpaceActivity.class);
        startActivity(intent);
    }
    public void onclck_menu5(View view) {
        Intent intent = new Intent(MapActivity.this, MoreActivity.class);
        startActivity(intent);
    }
}
