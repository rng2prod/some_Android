package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class CapsSecondFragment extends Fragment  {

    public CapsSecondFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caps2, container, false);
    }

    private ImageView tvImg2;

    @Override
    public void onStart() {
        super.onStart();

        final int[] j = {0};
        tvImg2 = (ImageView)getActivity().findViewById(R.id.imageCaps2scroll);

        String[] ImgURL2 = {"https://**********/caps/caps_v1.jpg","https://**********/caps/caps_v2.jpg","https://**********/caps/caps_v3.jpg"};
        ImageManager.fetchImage(ImgURL2[0], tvImg2);

        tvImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View p1) {
                j[0]++;
                if (j[0] == ImgURL2.length) {
                    j[0] = 0;
                }
                ImageManager.fetchImage(ImgURL2[j[0]], tvImg2);
            }
        });
    }
}




