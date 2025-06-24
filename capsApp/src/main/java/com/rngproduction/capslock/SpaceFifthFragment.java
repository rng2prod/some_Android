package com.rngproduction.capslock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SpaceFifthFragment extends Fragment {

    public SpaceFifthFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_space5, container, false);
    }

    private ImageView tvImgSp5;

    @Override
    public void onStart() {
        super.onStart();

        final int[] j = {0};
        tvImgSp5 = (ImageView)getActivity().findViewById(R.id.imageSpace5scroll);

        String[] ImgURLs5 = {"https://**********/spaces/space_sho1.jpg","https://**********/spaces/space_sho2.jpg","https://**********/spaces/space_sho3.jpg"};
        ImageManager.fetchImage(ImgURLs5[0], tvImgSp5);

        tvImgSp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View p1) {
                j[0]++;
                if (j[0] == ImgURLs5.length) {
                    j[0] = 0;
                }
                ImageManager.fetchImage(ImgURLs5[j[0]], tvImgSp5);
            }
        });
    }
}