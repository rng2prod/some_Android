package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class HomeThirdPromoFragment extends Fragment  {

    public HomeThirdPromoFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mainpromo3, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        String mainPromoImgURL3 = "https://**********/main_promo/mainPromo3.jpg";
        ImageView imageMainPromo3 = requireView().findViewById(R.id.imageMainPromo3);
        ImageManager.fetchImage(mainPromoImgURL3, imageMainPromo3);
    }
}




