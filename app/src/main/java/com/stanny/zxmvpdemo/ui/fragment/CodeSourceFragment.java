package com.stanny.zxmvpdemo.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.stanny.zxmvpdemo.R;
import com.stanny.zxmvpdemo.bean.CodeSorceEntity;
import com.stanny.zxmvpdemo.mvp.contract.CodeSourceContract;
import com.stanny.zxmvpdemo.mvp.model.CodeSourceModel;
import com.stanny.zxmvpdemo.mvp.presenter.CodeSourcePresenter;
import com.stanny.zxmvpdemo.ui.activity.WebActivity;
import com.stanny.zxmvpdemo.widget.adapter.CodeSourceAdapter;
import com.zx.zxutils.views.SwipeRecylerView.ZXSRListener;
import com.zx.zxutils.views.SwipeRecylerView.ZXSwipeRecyler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class CodeSourceFragment extends BaseFragment<CodeSourcePresenter, CodeSourceModel> implements CodeSourceContract.View {

    @BindView(R.id.sr_content)
    ZXSwipeRecyler srCode;

    private List<CodeSorceEntity.ResultsBean> dataList = new ArrayList<>();
    private int pageNum = 0;

    public static CodeSourceFragment newInstance() {
        CodeSourceFragment mFragment = new CodeSourceFragment();
        return mFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_content;
    }

    @Override
    public void initView() {
        srCode.setLayoutManager(new LinearLayoutManager(getActivity()))
                .setSimpleAdapter(new CodeSourceAdapter(dataList))
                .showLoadInfo(true)
                .setSRListener(new ZXSRListener<CodeSorceEntity.ResultsBean>() {
                    @Override
                    public void onItemClick(CodeSorceEntity.ResultsBean data, int i) {
                        WebActivity.startAction(getActivity(), data.getDesc(), data.getUrl());
                    }

                    @Override
                    public void onItemLongClick(CodeSorceEntity.ResultsBean data, int i) {

                    }

                    @Override
                    public void onRefresh() {
                        if (pageNum > 1) {
                            pageNum--;
                        }
                        mPresenter.getSourceList(pageNum);
                    }

                    @Override
                    public void onLoadMore() {
                        pageNum++;
                        mPresenter.getSourceList(pageNum);
                    }
                });
        mPresenter.getSourceList(pageNum);
    }


    public void onViewClicked(View view) {

    }

    @Override
    public void onSourceResult(List<CodeSorceEntity.ResultsBean> sourceListResult) {
        dataList.clear();
        dataList.addAll(sourceListResult);
        srCode.stopRefresh();
        srCode.notifyDataSetChanged();
        srCode.setLoadInfo("点击加载更多");
        srCode.getRecyclerView().scrollToPosition(0);
    }
}
