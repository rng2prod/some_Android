package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SpaceFirstFragment extends Fragment {

    public SpaceFirstFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_space1, container, false);
    }

    private ImageView tvImgSp;

    @Override
    public void onStart() {
        super.onStart();

        final int[] j = {0};
        tvImgSp = (ImageView)getActivity().findViewById(R.id.imageSpace1scroll);

        String[] ImgURLs1 = {"https://**********/spaces/space_kov1.jpg","https://**********/spaces/space_kov2.jpg","https://**********/spaces/space_kov3.jpg"};
        ImageManager.fetchImage(ImgURLs1[0], tvImgSp);

        tvImgSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View p1) {
                j[0]++;
                if (j[0] == ImgURLs1.length) {
                    j[0] = 0;
                }
                ImageManager.fetchImage(ImgURLs1[j[0]], tvImgSp);
            }
        });
    }
}