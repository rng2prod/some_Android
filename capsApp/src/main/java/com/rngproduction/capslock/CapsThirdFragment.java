package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class CapsThirdFragment extends Fragment  {

    public CapsThirdFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caps3, container, false);
    }

    private ImageView tvImg3;

    @Override
    public void onStart() {
        super.onStart();

        final int[] j = {0};
        tvImg3 = (ImageView)getActivity().findViewById(R.id.imageCaps3scroll);

        String[] ImgURL3 = {"https://**********/caps/caps_d1.jpg","https://**********/caps/caps_d2.jpg","https://**********/caps/caps_d3.jpg"};
        ImageManager.fetchImage(ImgURL3[0], tvImg3);

        tvImg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View p1) {
                j[0]++;
                if (j[0] == ImgURL3.length) {
                    j[0] = 0;
                }
                ImageManager.fetchImage(ImgURL3[j[0]], tvImg3);
            }
        });
    }
}




