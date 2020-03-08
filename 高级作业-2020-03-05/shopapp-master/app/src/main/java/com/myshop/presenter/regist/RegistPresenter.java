package com.myshop.presenter.regist;

import com.myshop.base.BasePresenter;
import com.myshop.common.ResponseSubscriber;
import com.myshop.interfaces.regist.RegistConstract;
import com.myshop.model.HttpManager;
import com.myshop.model.bean.RegistBean;
import com.myshop.utils.RxUtils;

public class RegistPresenter extends BasePresenter<RegistConstract.View> implements RegistConstract.Presenter {

    @Override
    public void regist(String nickname, String pw) {
        addSubscribe(HttpManager.getInstance().getMyServer().regist(nickname,pw)
        .compose(RxUtils.<RegistBean>rxScheduler())
        .subscribeWith(new ResponseSubscriber<RegistBean>(mView){
            @Override
            public void onNext(RegistBean rb) {
                if(rb.getErrno() == 0){
                    mView.registReturn(rb);
                }else{
                    super.onNext(rb);
                }
            }
        }));
    }
}
