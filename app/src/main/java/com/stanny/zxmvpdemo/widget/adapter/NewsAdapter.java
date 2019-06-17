package com.stanny.zxmvpdemo.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stanny.zxmvpdemo.R;
import com.stanny.zxmvpdemo.bean.NewsEntity;
import com.zx.zxutils.other.ZXRecyclerAdapter.ZXRecycleSimpleAdapter;
import com.zx.zxutils.util.ZXImageLoaderUtil;

import java.util.List;

/**
 * Created by Xiangb on 2017/10/18.
 * 功能：
 */

public class NewsAdapter extends ZXRecycleSimpleAdapter {
    private List<NewsEntity.ResultBean.DataBean> dataList;

    public NewsAdapter(List<NewsEntity.ResultBean.DataBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onItemHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder mHolder = (MyHolder) viewHolder;
        NewsEntity.ResultBean.DataBean mEntity = dataList.get(i);
        mHolder.tvTitle.setText(mEntity.getTitle());
        mHolder.tvSource.setText("来源：" + mEntity.getAuthor_name());
        mHolder.tvDate.setText(mEntity.getDate());
        ZXImageLoaderUtil.display(mHolder.ivPic1, mEntity.getThumbnail_pic_s());
        if (mEntity.getThumbnail_pic_s02() != null) {
            ZXImageLoaderUtil.display(mHolder.ivPic2, mEntity.getThumbnail_pic_s02());
        }
        if (mEntity.getThumbnail_pic_s03() != null) {
            ZXImageLoaderUtil.display(mHolder.ivPic3, mEntity.getThumbnail_pic_s03());
        }
    }

    private class MyHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvSource, tvDate;
        private ImageView ivPic1, ivPic2, ivPic3;

        public MyHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_news_title);
            tvSource = (TextView) itemView.findViewById(R.id.tv_news_source);
            tvDate = (TextView) itemView.findViewById(R.id.tv_news_date);
            ivPic1 = (ImageView) itemView.findViewById(R.id.iv_news_pic1);
            ivPic2 = (ImageView) itemView.findViewById(R.id.iv_news_pic2);
            ivPic3 = (ImageView) itemView.findViewById(R.id.iv_news_pic3);
        }
    }

    @Override
    public List onItemList() {
        return dataList;
    }
}
