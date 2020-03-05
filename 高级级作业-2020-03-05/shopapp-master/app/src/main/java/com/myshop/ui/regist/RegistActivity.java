package com.myshop.ui.regist;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.myshop.R;
import com.myshop.base.BaseActivity;
import com.myshop.interfaces.regist.RegistConstract;
import com.myshop.model.bean.RegistBean;
import com.myshop.presenter.regist.RegistPresenter;
import com.myshop.utils.SpUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class RegistActivity extends BaseActivity<RegistConstract.Presenter> implements RegistConstract.View {
    @BindView(R.id.edit_nickname)
    EditText editNickname;
    @BindView(R.id.edit_pw)
    EditText editPw;
    @BindView(R.id.btn_regist)
    Button btnLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_regist;
    }

    @Override
    protected RegistConstract.Presenter createPresenter() {
        return new RegistPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    //注册成功
    @Override
    public void registReturn(RegistBean result) {
//        String token = result.getData().getToken();
//        SpUtils.getInstance().setValue("token",token);

        finish();
    }

    @OnClick(R.id.btn_regist)
    public void onViewClicked() {
       regist();
    }

    //执行注册
    private void regist(){
        String nickname = editNickname.getText().toString();
        String pw = editPw.getText().toString();
        if(!TextUtils.isEmpty(nickname) && !TextUtils.isEmpty(pw)){
            presenter.regist(nickname,pw);
        }
    }
}
