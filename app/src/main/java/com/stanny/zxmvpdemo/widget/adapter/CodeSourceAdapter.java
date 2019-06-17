package com.stanny.zxmvpdemo.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.stanny.zxmvpdemo.R;
import com.stanny.zxmvpdemo.bean.CodeSorceEntity;
import com.zx.zxutils.other.ZXRecyclerAdapter.ZXRecycleSimpleAdapter;
import com.zx.zxutils.util.ZXImageLoaderUtil;

import java.util.List;

/**
 * Created by Xiangb on 2017/10/18.
 * 功能：
 */

public class CodeSourceAdapter extends ZXRecycleSimpleAdapter {

    private List<CodeSorceEntity.ResultsBean> dataList;

    public CodeSourceAdapter(List<CodeSorceEntity.ResultsBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onItemHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_code, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder mHolder = (MyHolder) viewHolder;
        CodeSorceEntity.ResultsBean mEntity = dataList.get(i);
        mHolder.tvTitle.setText(mEntity.getDesc());
        mHolder.tvDate.setText(mEntity.getPublishedAt());
        mHolder.tvSource.setText(mEntity.getSource());
        if (mEntity.getImages() == null || mEntity.getImages().size() == 0) {
            mHolder.ivPic1.setVisibility(View.GONE);
            mHolder.ivPic2.setVisibility(View.GONE);
            mHolder.ivBig.setVisibility(View.GONE);
        } else if (mEntity.getImages().size() == 1) {
            mHolder.ivPic1.setVisibility(View.GONE);
            mHolder.ivPic2.setVisibility(View.GONE);
            mHolder.ivBig.setVisibility(View.VISIBLE);
            ZXImageLoaderUtil.display(mHolder.ivBig, mEntity.getImages().get(0));
        } else {
            mHolder.ivBig.setVisibility(View.GONE);
            mHolder.ivPic1.setVisibility(View.VISIBLE);
            mHolder.ivPic2.setVisibility(View.VISIBLE);
            ZXImageLoaderUtil.display(mHolder.ivPic1, mEntity.getImages().get(0));
            ZXImageLoaderUtil.display(mHolder.ivPic2, mEntity.getImages().get(1));
        }
    }

    private class MyHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvSource, tvDate;
        private ImageView ivBig, ivPic1, ivPic2;

        public MyHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_code_title);
            tvSource = (TextView) itemView.findViewById(R.id.tv_code_source);
            tvDate = (TextView) itemView.findViewById(R.id.tv_code_date);
            ivBig = (ImageView) itemView.findViewById(R.id.iv_code_picBig);
            ivPic1 = (ImageView) itemView.findViewById(R.id.iv_code_pic1);
            ivPic2 = (ImageView) itemView.findViewById(R.id.iv_code_pic2);
        }
    }

    @Override
    public List onItemList() {
        return dataList;
    }
}
