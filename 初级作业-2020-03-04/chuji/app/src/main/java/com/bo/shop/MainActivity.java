package com.bo.shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.bo.shop.adapter.VpImageAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private ViewPager mVp;
    private TabLayout mTabLayout;
    private ArrayList<String> mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initTitles();
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        toolbar();
        vp();
        tab();
        //viewpager翻页监听
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //tab选中监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                //设置当前的条目
                mVp.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void vp() {
        ArrayList<View> views = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.tab, null);
            TextView tv = inflate.findViewById(R.id.tv);
           // tv.setText("这是第"+(i+1)+"个页面");
            tv.setText(mTitles.get(i)+"主页");
            views.add(inflate);
        }

        VpImageAdapter adapter = new VpImageAdapter(views);
        mVp.setAdapter(adapter);

    }

    private void toolbar() {
        //设置标题
        mToolBar.setTitle(R.string.title);
        setSupportActionBar(mToolBar);
    }

    private void tab() {
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(tabView(0)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(tabView(1)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(tabView(2)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(tabView(3)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(tabView(4)));
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        String str = getResources().getString(R.string.main_page);
        mTitles.add(str);
        mTitles.add(getResources().getString(R.string.section));
        mTitles.add(getResources().getString(R.string.category));
        mTitles.add(getResources().getString(R.string.cart));
        mTitles.add(getResources().getString(R.string.me));

    }

    //对外提供tab的view
    public View tabView(int position){
        View inflate = LayoutInflater.from(this).inflate(R.layout.tab, null);
        ImageView iv = inflate.findViewById(R.id.iv);
        TextView tv = inflate.findViewById(R.id.tv);
        switch (position){
            case 0:
                iv.setImageResource(R.drawable.se_main_page);
                break;
            case 1:
                iv.setImageResource(R.drawable.se_section);
                break;
            case 2:
                iv.setImageResource(R.drawable.se_category);
                break;
            case 3:
                iv.setImageResource(R.drawable.se_cart);
                break;
            case 4:
                iv.setImageResource(R.drawable.se_me);
                break;
        }

        tv.setText(mTitles.get(position));
        return inflate;
    }

}