package com.xts.shop.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import com.bumptech.glide.Glide;
import com.xts.shop.R;
import com.xts.shop.adapter.HomeAdpater;
import com.xts.shop.bean.HomeBean;
import com.xts.shop.net.ApiService;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainPageFragment extends Fragment {

   private RecyclerView rv ;
   private ArrayList<HomeBean.DataBean.BannerBean> banners;
   private ArrayList<HomeBean.DataBean.NewGoodsListBean> goods;
   private HomeAdpater adapter;

    public static MainPageFragment newInstance(){
        MainPageFragment fragment = new MainPageFragment();
        return fragment;
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
        initData();
    }

    private void initData() {
        //获得retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.sBaseUrl).addCallAdapterFactory(RxJava2CallAdapterFactory.create())//访问接口
                .addConverterFactory(GsonConverterFactory.create()).build();//封装bean
        //获得接口
        ApiService apiService = retrofit.create(ApiService.class);
        //调方法
        Flowable<HomeBean> homeData = apiService.getHomeData();
        //执行请求
        homeData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())//主线程
        .subscribeWith(new ResourceSubscriber<HomeBean>() {//子线程
            @Override
            public void onNext(HomeBean homeBean) {
                List<HomeBean.DataBean.BannerBean> banner = homeBean.getData().getBanner();
                List<HomeBean.DataBean.NewGoodsListBean> newGoodsList = homeBean.getData().getNewGoodsList();
                banners.addAll(banner);
                goods.addAll(newGoodsList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void initView(View view) {
         rv = view.findViewById(R.id.rv);
         rv.setLayoutManager(new LinearLayoutManager(getActivity()));//设置管理器
         rv.addItemDecoration(new DividerItemDecoration(getActivity(),RecyclerView.VERTICAL));
         banners=new ArrayList<>();
         goods=new ArrayList<>();

         adapter=new HomeAdpater(getContext(),banners,goods);
         rv.setAdapter(adapter);

    }
}
