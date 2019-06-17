package com.stanny.zxmvpdemo.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stanny.zxmvpdemo.R;
import com.stanny.zxmvpdemo.bean.BeautyEntity;
import com.zx.zxutils.other.ZXRecyclerAdapter.ZXRecycleSimpleAdapter;
import com.zx.zxutils.util.ZXImageLoaderUtil;

import java.util.List;

/**
 * Created by Xiangb on 2017/10/18.
 * 功能：
 */

public class BeautyAdapter extends ZXRecycleSimpleAdapter {
    private List<BeautyEntity.ResultsBean> dataList;

    public BeautyAdapter(List<BeautyEntity.ResultsBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onItemHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_beauty, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder holder = (MyHolder) viewHolder;
        BeautyEntity.ResultsBean mEntity = dataList.get(i);
        ZXImageLoaderUtil.displaySmallPhoto(holder.ivBeauty, mEntity.getUrl());
        holder.tvSource.setText("来源：" + mEntity.getSource());
        holder.tvDate.setText(mEntity.getPublishedAt());
    }

    private class MyHolder extends RecyclerView.ViewHolder {

        private ImageView ivBeauty;
        private TextView tvSource, tvDate;

        public MyHolder(View itemView) {
            super(itemView);
            ivBeauty = (ImageView) itemView.findViewById(R.id.iv_beauty);
            tvSource = (TextView) itemView.findViewById(R.id.tv_beauty_source);
            tvDate = (TextView) itemView.findViewById(R.id.tv_beauty_date);
        }
    }

    @Override
    public List onItemList() {
        return dataList;
    }
}
