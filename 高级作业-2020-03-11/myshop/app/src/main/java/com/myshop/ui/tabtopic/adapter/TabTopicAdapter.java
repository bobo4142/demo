package com.myshop.ui.tabtopic.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myshop.R;
import com.myshop.base.BaseAdapter;
import com.myshop.model.bean.TabTopicBean;

import java.util.List;

public class TabTopicAdapter extends BaseAdapter<TabTopicBean.DataBeanX.DataBean> {
    public TabTopicAdapter(Context context, List<TabTopicBean.DataBeanX.DataBean> datas) {
        super(context, datas);
    }

    @Override
    public int getLayout() {
        return R.layout.rec_item_tabtopic;
    }

    @Override
    public void bindData(BaseViewHolder holder, TabTopicBean.DataBeanX.DataBean data) {
        //找组件
        ImageView pic = (ImageView) holder.getViewById(R.id.img_tabtopic_pic);
        TextView title = (TextView) holder.getViewById(R.id.txt_tabtopic_title);
        //配置数据
        Glide.with(mContext).load(data.getScene_pic_url()).into(pic);
        title.setText(data.getTitle());
    }
}
