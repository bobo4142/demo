package com.bo.shop.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bo.shop.R;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainPageFragment extends Fragment {
    private Banner mBanner;
    public static MainPageFragment newInstance(){
        return new MainPageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main_page, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
    mBanner=view.findViewById(R.id.banner);
        ArrayList<Integer> imgs =new ArrayList<>();
        imgs.add(R.drawable.ic_launcher_foreground);
        imgs.add(R.drawable.ic_launcher_background);
        imgs.add(R.drawable.ic_launcher_foreground);
        imgs.add(R.drawable.ic_launcher_background);
        mBanner.setImages(imgs)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).start();
    }
}
