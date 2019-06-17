package com.stanny.zxmvpdemo.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.stanny.zxmvpdemo.R;
import com.stanny.zxmvpdemo.ui.activity.WebActivity;
import com.stanny.zxmvpdemo.bean.BeautyEntity;
import com.stanny.zxmvpdemo.mvp.contract.BeautyContract;
import com.stanny.zxmvpdemo.mvp.model.BeautyModel;
import com.stanny.zxmvpdemo.mvp.presenter.BeautyPresenter;
import com.stanny.zxmvpdemo.widget.adapter.BeautyAdapter;
import com.zx.zxutils.views.SwipeRecylerView.ZXSRListener;
import com.zx.zxutils.views.SwipeRecylerView.ZXSwipeRecyler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Create By admin On 2017/7/11
 * 功能：笑话
 */
public class BeautyFragment extends BaseFragment<BeautyPresenter, BeautyModel> implements BeautyContract.View {

    @BindView(R.id.sr_content)
    ZXSwipeRecyler srBeauty;

    private List<BeautyEntity.ResultsBean> dataList = new ArrayList<>();

    public static BeautyFragment newInstance() {
        BeautyFragment mFragment = new BeautyFragment();
        return mFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_content;
    }

    @Override
    protected void initView() {
        srBeauty.setLayoutManager(new GridLayoutManager(getActivity(), 2))
                .setSimpleAdapter(new BeautyAdapter(dataList))
                .showLoadInfo(true)
                .setSRListener(new ZXSRListener<BeautyEntity.ResultsBean>() {
                    @Override
                    public void onItemClick(BeautyEntity.ResultsBean data, int i) {
                        WebActivity.startAction(getActivity(), "美女", data.getUrl());
                    }

                    @Override
                    public void onItemLongClick(BeautyEntity.ResultsBean data, int i) {

                    }

                    @Override
                    public void onRefresh() {
                        loadData();
                    }

                    @Override
                    public void onLoadMore() {
                        loadData();
                    }
                });
        loadData();
    }

    private void loadData() {
        mPresenter.getBeautyList((int) (Math.random()*56));
    }

    public void onViewClicked(View view) {

    }

    @Override
    public void onBeautyResult(List<BeautyEntity.ResultsBean> beautyListResult) {
        dataList.clear();
        dataList.addAll(beautyListResult);
        srBeauty.stopRefresh();
        srBeauty.notifyDataSetChanged();
        srBeauty.setLoadInfo("点击加载下一页");
        srBeauty.getRecyclerView().scrollToPosition(0);
    }
}
