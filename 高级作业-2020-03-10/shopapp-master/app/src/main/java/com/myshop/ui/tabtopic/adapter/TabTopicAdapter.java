package com.myshop.ui.tabtopic.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.model.bean.TabTopicBean;

import java.util.List;

import butterknife.BindView;

public class TabTopicAdapter extends BaseAdapter<TabTopicBean.DataBeanX.DataBean> {

    public TabTopicAdapter(Context context, List mDatas) {
        super(context, mDatas);
    }

    @Override
    public int getLayout() {
        return R.layout.rec_item_tabtopic;
    }

    @Override
    public void bindData(BaseViewHolder holder, TabTopicBean.DataBeanX.DataBean data) {
        ImageView mImgTabtopicPic= (ImageView) holder.getViewById(R.id.img_tabtopic_pic);
        TextView mTxTabtopicTitle= (TextView) holder.getViewById(R.id.tx_tabtopic_title);
        TextView mTxTabtopicSubitle= (TextView) holder.getViewById(R.id.tx_tabtopic_subitle);
        TextView mTxTabtopicPirce= (TextView) holder.getViewById(R.id.tx_tabtopic_pirce);
        Glide.with(mContext).load(data.getScene_pic_url()).into(mImgTabtopicPic);
        mTxTabtopicTitle.setText(data.getTitle());
        mTxTabtopicSubitle.setText(data.getSubtitle());
        mTxTabtopicPirce.setText(data.getPrice_info()+"元起");
    }
}
