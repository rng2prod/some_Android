package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class HomeSecondPromoFragment extends Fragment  {

    public HomeSecondPromoFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mainpromo2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        String mainPromoImgURL2 = "https://**********/main_promo/mainPromo2.jpg";
        ImageView imageMainPromo2 = requireView().findViewById(R.id.imageMainPromo2);
        ImageManager.fetchImage(mainPromoImgURL2, imageMainPromo2);
    }
}




