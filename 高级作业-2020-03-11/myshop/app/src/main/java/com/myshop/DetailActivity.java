package com.myshop;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myshop.model.bean.HomeBean;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.txt_brand_detail_desc)
    TextView mTxtDesc;
    @BindView(R.id.rec_brand_detail_img)
    ImageView mRecBrandDetailImg;
    @BindView(R.id.txt_brand_detail_name)
    TextView mTxtBrandDetailName;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mUnbinder = ButterKnife.bind(this);

//        String desc = getIntent().getStringExtra("desc");
//        mTxtDesc.setText(desc);
        HomeBean.DataBean.BrandListBean bean = (HomeBean.DataBean.BrandListBean) getIntent().getSerializableExtra("bean");
        mTxtBrandDetailName.setText(bean.getName());
        mTxtBrandDetailName.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mTxtDesc.setText(bean.getSimple_desc());
        Glide.with(this).load(bean.getList_pic_url()).into(mRecBrandDetailImg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();

        }
    }


}
