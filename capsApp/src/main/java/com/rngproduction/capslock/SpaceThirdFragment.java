package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SpaceThirdFragment extends Fragment {

    public SpaceThirdFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_space3, container, false);
    }

    private ImageView tvImgSp3;

    @Override
    public void onStart() {
        super.onStart();

        final int[] j = {0};
        tvImgSp3 = (ImageView)getActivity().findViewById(R.id.imageSpace3scroll);

        String[] ImgURLs3 = {"https://**********/spaces/space_bil1.jpg","https://**********/spaces/space_bil2.jpg","https://**********/spaces/space_bil3.jpg"};
        ImageManager.fetchImage(ImgURLs3[0], tvImgSp3);

        tvImgSp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View p1) {
                j[0]++;
                if (j[0] == ImgURLs3.length) {
                    j[0] = 0;
                }
                ImageManager.fetchImage(ImgURLs3[j[0]], tvImgSp3);
            }
        });
    }
}