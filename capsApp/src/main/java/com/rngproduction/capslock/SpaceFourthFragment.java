package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SpaceFourthFragment extends Fragment {

    public SpaceFourthFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_space4, container, false);
    }

    private ImageView tvImgSp4;

    @Override
    public void onStart() {
        super.onStart();

        final int[] j = {0};
        tvImgSp4 = (ImageView)getActivity().findViewById(R.id.imageSpace4scroll);

        String[] ImgURLs4 = {"https://**********/spaces/space_kit1.jpg","https://**********/spaces/space_kit2.jpg","https://**********/spaces/space_kit3.jpg"};
        ImageManager.fetchImage(ImgURLs4[0], tvImgSp4);

        tvImgSp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View p1) {
                j[0]++;
                if (j[0] == ImgURLs4.length) {
                    j[0] = 0;
                }
                ImageManager.fetchImage(ImgURLs4[j[0]], tvImgSp4);
            }
        });
    }
}