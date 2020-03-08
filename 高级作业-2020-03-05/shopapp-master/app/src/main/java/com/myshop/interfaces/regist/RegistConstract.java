package com.myshop.interfaces.regist;

import com.myshop.interfaces.IBasePresenter;
import com.myshop.interfaces.IBaseView;
import com.myshop.interfaces.login.LoginConstract;
import com.myshop.model.bean.LoginBean;
import com.myshop.model.bean.RegistBean;

public interface RegistConstract {
    interface View extends IBaseView {
        void registReturn(RegistBean result);
    }

    interface Presenter extends IBasePresenter<RegistConstract.View> {
        void regist(String nickname,String pw);
    }
}
