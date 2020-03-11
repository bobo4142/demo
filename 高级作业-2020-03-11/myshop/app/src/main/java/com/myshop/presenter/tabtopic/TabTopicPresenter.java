package com.myshop.presenter.tabtopic;

import com.myshop.base.BasePresenter;
import com.myshop.common.ResponseSubscriber;
import com.myshop.interfaces.tabtopic.TabTopicConstract;
import com.myshop.model.HttpManager;
import com.myshop.model.bean.TabTopicBean;
import com.myshop.utils.RxUtils;

public class TabTopicPresenter extends BasePresenter<TabTopicConstract.View> implements TabTopicConstract.Presenter{

    @Override
    public void getTabTopicBean(int page, int size) {
        addSubscribe(HttpManager.getInstance().getMyServer().getTabTopic(page,size)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new ResponseSubscriber<TabTopicBean>(mView){
            @Override
            public void onNext(TabTopicBean tabTopicBean) {
                super.onNext(tabTopicBean);
                //得到请求的 TabTopicBean数据
                mView.tabTopicBeanReturn(tabTopicBean);
            }
        }));
    }
}
