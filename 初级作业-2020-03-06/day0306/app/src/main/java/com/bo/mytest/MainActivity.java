package com.bo.mytest;

import android.os.Bundle;
import android.os.storage.OnObbStateChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bo.mytest.adapter.VpFragmentAdapter;
import com.bo.mytest.ui.fragment.CartFragment;
import com.bo.mytest.ui.fragment.MainPageFragment;
import com.bo.mytest.ui.fragment.MeFragment;
import com.bo.mytest.ui.fragment.SortFragment;
import com.bo.mytest.ui.fragment.TopicFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private ViewPager mVp;
    private TabLayout mTabLayout;
    private ArrayList<String> mTitles;
    private ArrayList<Fragment> fregs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initTitles();
        initFrams();
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        toolbar();
        vp();
        //关联viewPager和TabLayout
        mTabLayout.setupWithViewPager(mVp);
        for (int i=0;i<fregs.size();i++){
            TabLayout.Tab tabAt = mTabLayout.getTabAt(i);
            tabAt.setCustomView(tabView(i));
        }


    }

    private void initFrams() {
        fregs = new ArrayList();
        fregs.add(MainPageFragment.newInstance());
        fregs.add(TopicFragment.newInstance());
        fregs.add(SortFragment.newInstance());
        fregs.add(CartFragment.newInstance());
        fregs.add(MeFragment.newInstance());
    }

    private void vp() {
        //设置Framgent
        VpFragmentAdapter vf = new VpFragmentAdapter(getSupportFragmentManager(), fregs, mTitles);
        mVp.setAdapter(vf);



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
    public View tabView(int position) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.tab, null);
        ImageView iv = inflate.findViewById(R.id.iv);
        TextView tv = inflate.findViewById(R.id.tv);
        switch (position) {
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

    private void showToast(CharSequence title) {
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
    }
}