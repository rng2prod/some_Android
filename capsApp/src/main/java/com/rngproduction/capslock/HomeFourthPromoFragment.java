package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class HomeFourthPromoFragment extends Fragment  {

    public HomeFourthPromoFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mainpromo4, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        String mainPromoImgURL4 = "https://**********/main_promo/mainPromo4.jpg";
        ImageView imageMainPromo4 = requireView().findViewById(R.id.imageMainPromo4);
        ImageManager.fetchImage(mainPromoImgURL4, imageMainPromo4);
    }
}




