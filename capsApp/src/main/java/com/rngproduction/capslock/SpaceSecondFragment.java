package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SpaceSecondFragment extends Fragment {

    public SpaceSecondFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_space2, container, false);
    }

    private ImageView tvImgSp2;

    @Override
    public void onStart() {
        super.onStart();

        final int[] j = {0};
        tvImgSp2 = (ImageView)getActivity().findViewById(R.id.imageSpace2scroll);

        String[] ImgURLs2 = {"https://**********/spaces/space_cin1.jpg","https://**********/spaces/space_cin2.jpg","https://**********/spaces/space_cin3.jpg"};
        ImageManager.fetchImage(ImgURLs2[0], tvImgSp2);

        tvImgSp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View p1) {
                j[0]++;
                if (j[0] == ImgURLs2.length) {
                    j[0] = 0;
                }
                ImageManager.fetchImage(ImgURLs2[j[0]], tvImgSp2);
            }
        });
    }
}