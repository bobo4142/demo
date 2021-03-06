package com.xts.shop.net;

import com.xts.shop.bean.HomeBean;
import com.xts.shop.bean.TopicBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String sBaseUrl = "https://cdwan.cn/api/";

    //专题数据请求接口
    @GET("topic/list")
    Flowable<TopicBean> getTopic(@Query("page") int page, @Query("size") int size);

    //主页接口
    @GET("index")
    Flowable<HomeBean> getHomeData();

}
