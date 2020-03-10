package com.myshop.ui.tabtopic;

import android.widget.LinearLayout;

import com.myshop.R;
import com.myshop.base.BaseFragment;
import com.myshop.interfaces.tabtopic.TabTopicConstract;
import com.myshop.model.bean.TabTopicBean;
import com.myshop.presenter.tabtopic.TabTopicPrecenter;
import com.myshop.ui.tabtopic.adapter.TabTopicAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class TabTopicFragment extends BaseFragment<TabTopicConstract.Presenter> implements TabTopicConstract.View {

    @BindView(R.id.rec_tabtopic)
    RecyclerView mRecTabtopic;
    TabTopicAdapter tabTopicAdapter;
    private List<TabTopicBean.DataBeanX.DataBean> mData;

    @Override
    protected int getLayout() {
        return R.layout.fragment_tabtopic;
    }

    @Override
    protected TabTopicConstract.Presenter createPresenter() {
        return new TabTopicPrecenter();
    }

    @Override
    protected void initView() {
        mRecTabtopic.setLayoutManager(new LinearLayoutManager(context));
        mRecTabtopic.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));
        mData=new ArrayList<>();
        tabTopicAdapter = new TabTopicAdapter(context, mData);
        mRecTabtopic.setAdapter(tabTopicAdapter);
    }

    @Override
    protected void initData() {
        presenter.getTabTopicData(1,10);
    }

    @Override
    public void getTabTopicDataReturn(TabTopicBean result) {
        tabTopicAdapter.updateList(result.getData().getData());
    }
}
