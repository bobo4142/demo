package com.myshop.interfaces.tabtopic;

import com.myshop.interfaces.IBasePresenter;
import com.myshop.interfaces.IBaseView;
import com.myshop.model.bean.TabTopicBean;

public interface TabTopicConstract {
    //视图
    interface  View extends IBaseView{
        void getTabTopicDataReturn(TabTopicBean result);
    }
    //p层
    interface Presenter extends IBasePresenter<View>{
        void getTabTopicData(int page,int size);
    }
}
