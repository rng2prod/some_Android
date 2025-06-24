package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class HomeFirstPromoFragment extends Fragment  {


    public HomeFirstPromoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mainpromo1, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        String mainPromoImgURL1 = "https://**********/main_promo/mainPromo1.jpg";
        ImageView imageMainPromo1 = requireView().findViewById(R.id.imageMainPromo1);
        ImageManager.fetchImage(mainPromoImgURL1, imageMainPromo1);

    }
}




