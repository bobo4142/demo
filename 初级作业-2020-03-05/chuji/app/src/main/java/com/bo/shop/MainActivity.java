package com.bo.shop;

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

import com.bo.shop.adapter.VpFragmentAdapter;
import com.bo.shop.adapter.VpImageAdapter;
import com.bo.shop.ui.fragment.CartFragment;
import com.bo.shop.ui.fragment.MainPageFragment;
import com.bo.shop.ui.fragment.MeFragment;
import com.bo.shop.ui.fragment.SortFragment;
import com.bo.shop.ui.fragment.TopicFragment;
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
//        tab();
      /*  //viewpager翻页监听
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
        });*/


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


        /*ArrayList<View> views = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.tab, null);
            TextView tv = inflate.findViewById(R.id.tv);
            // tv.setText("这是第"+(i+1)+"个页面");
            tv.setText(mTitles.get(i) + "主页");
            views.add(inflate);
        }

        VpImageAdapter adapter = new VpImageAdapter(views);
        mVp.setAdapter(adapter);*/

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
    //选项菜单

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //设置点击事件

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.one:
            showToast(item.getTitle());
            break;
            case R.id.two:
                showToast(item.getTitle());
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void showToast(CharSequence title) {
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
    }
}