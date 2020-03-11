package com.myshop.ui.tabtopic;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myshop.R;
import com.myshop.base.BaseFragment;
import com.myshop.base.BasePresenter;
import com.myshop.interfaces.tabtopic.TabTopicConstract;
import com.myshop.model.bean.TabTopicBean;
import com.myshop.presenter.tabtopic.TabTopicPresenter;
import com.myshop.ui.tabtopic.adapter.TabTopicAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TabTopicFragment extends BaseFragment<TabTopicConstract.Presenter> implements TabTopicConstract.View {
    @BindView(R.id.rec_tabtopic)
    RecyclerView rec_tabtopic;
    private List<TabTopicBean.DataBeanX.DataBean> mData;
    private TabTopicAdapter mTopicAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_tabtopic;
    }

    //创建P对象
    @Override
    protected TabTopicConstract.Presenter createPresenter() {
        return new TabTopicPresenter();
    }

    @Override
    protected void initView() {
        //初始化 rec_tabtopic
        rec_tabtopic.setLayoutManager(new LinearLayoutManager(context));
        rec_tabtopic.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));//设置分割线
        mData = new ArrayList<>();
        mTopicAdapter = new TabTopicAdapter(context, mData);
        rec_tabtopic.setAdapter(mTopicAdapter);

    }

    @Override
    protected void initData() {
        presenter.getTabTopicBean(1,10);//去数据
    }

    @Override
    public void tabTopicBeanReturn(TabTopicBean result) {
        //p层返回的数据
        mTopicAdapter.updataListClearAddMore(result.getData().getData());
    }
}
