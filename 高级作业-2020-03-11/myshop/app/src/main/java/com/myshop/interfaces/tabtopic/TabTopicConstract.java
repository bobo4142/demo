package com.myshop.interfaces.tabtopic;

import com.myshop.interfaces.IBasePresenter;
import com.myshop.interfaces.IBaseView;
import com.myshop.model.bean.TabTopicBean;

public interface TabTopicConstract {
    interface View extends IBaseView{  //view接口
        void tabTopicBeanReturn(TabTopicBean result);
    }

    interface Presenter extends IBasePresenter<View>{
        void getTabTopicBean(int page ,int size);
    }
}
