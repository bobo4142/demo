package com.myshop.ui.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.model.bean.HomeBean;

import java.util.List;

public class TopicAdapter extends BaseAdapter {

    public TopicAdapter(Context context, List mDatas) {
        super(context, mDatas);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_item_good;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object data) {
        ImageView imgPicurl = (ImageView) holder.getViewById(R.id.list_pic_url);
        TextView txtName = (TextView) holder.getViewById(R.id.txt_name);
        TextView txtRetailPrice = (TextView) holder.getViewById(R.id.retail_price);
        HomeBean.DataBean.HotGoodsListBean bean= (HomeBean.DataBean.HotGoodsListBean) data;
        Glide.with(mContext).load(bean.getList_pic_url()).into(imgPicurl);
        txtName.setText(bean.getName());
        txtRetailPrice.setText(bean.getRetail_price()+"元起");

    }

    private void initView() {

    }
}
