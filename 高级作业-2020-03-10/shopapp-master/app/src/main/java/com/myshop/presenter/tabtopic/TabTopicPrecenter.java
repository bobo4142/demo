package com.myshop.presenter.tabtopic;

import com.myshop.base.BasePresenter;
import com.myshop.common.ResponseSubscriber;
import com.myshop.interfaces.tabtopic.TabTopicConstract;
import com.myshop.model.HttpManager;
import com.myshop.model.bean.TabTopicBean;
import com.myshop.utils.RxUtils;

public class TabTopicPrecenter extends BasePresenter<TabTopicConstract.View> implements TabTopicConstract.Presenter {
    @Override
    public void getTabTopicData(int page, int size) {
        this.addSubscribe(HttpManager.getInstance().getMyServer().getTabTopic(page,size)
        .compose(RxUtils.rxScheduler())//子线程
        .subscribeWith(new ResponseSubscriber<TabTopicBean>(mView){//主线程
            @Override
            public void onNext(TabTopicBean tabTopicBean) {
                super.onNext(tabTopicBean);
                mView.getTabTopicDataReturn(tabTopicBean);
            }
        })
        );
    }
}
