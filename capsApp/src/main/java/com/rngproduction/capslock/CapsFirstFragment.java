package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class CapsFirstFragment extends Fragment  {

    public CapsFirstFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caps1, container, false);
    }

    private ImageView tvImg;


    @Override
    public void onStart() {
        super.onStart();

        final int[] j = {0};

        tvImg = (ImageView) getActivity().findViewById(R.id.imageCaps1scroll);

        String[] ImgURL = {"https://**********/caps/caps_g1.jpg","https://**********/caps/caps_g2.jpg","https://**********/caps/caps_g3.jpg"};
        ImageManager.fetchImage(ImgURL[0], tvImg);

        tvImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View p1) {
                j[0]++;
                if (j[0] == ImgURL.length) {
                    j[0] = 0;
                }
                ImageManager.fetchImage(ImgURL[j[0]], tvImg);
            }
        });
    }


}





