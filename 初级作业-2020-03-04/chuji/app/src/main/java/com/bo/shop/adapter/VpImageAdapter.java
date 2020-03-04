package com.bo.shop.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class VpImageAdapter extends PagerAdapter {
    private ArrayList<View> mViews;

    public VpImageAdapter(ArrayList<View> views) {

        mViews = views;
    }

    /**
     * 返回当前有效视图的个数
     * @return
     */
    @Override
    public int getCount() {
        return mViews.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
        //return view == mViews.get((Integer) object);
    }

    /**
     * 初始化视图
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = mViews.get(position);
        container.addView(view);
        return view;
    }

    /**
     * 销毁视图页面的
*/
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
