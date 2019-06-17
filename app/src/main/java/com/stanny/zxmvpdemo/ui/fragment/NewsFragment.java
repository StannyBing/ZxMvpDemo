package com.stanny.zxmvpdemo.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.stanny.zxmvpdemo.R;
import com.stanny.zxmvpdemo.ui.activity.WebActivity;
import com.stanny.zxmvpdemo.api.ApiParamUtil;
import com.stanny.zxmvpdemo.bean.NewsEntity;
import com.stanny.zxmvpdemo.mvp.contract.NewsContract;
import com.stanny.zxmvpdemo.mvp.model.NewsModel;
import com.stanny.zxmvpdemo.mvp.presenter.NewsPresenter;
import com.stanny.zxmvpdemo.widget.adapter.NewsAdapter;
import com.zx.zxutils.views.SwipeRecylerView.ZXSRListener;
import com.zx.zxutils.views.SwipeRecylerView.ZXSwipeRecyler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class NewsFragment extends BaseFragment<NewsPresenter, NewsModel> implements NewsContract.View {

    @BindView(R.id.sr_content)
    ZXSwipeRecyler srNews;

    private String[] newsType = {"top", "shehui", "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing", "shishang"};
    private int index = 0;
    private List<NewsEntity.ResultBean.DataBean> dataList = new ArrayList<>();

    public static NewsFragment newInstance() {
        NewsFragment mFragment = new NewsFragment();
        return mFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_content;
    }

    @Override
    protected void initView() {
        //ZXSwipeRecyler这个控件不属于ZxMvp框架，而是ZxUtils的类
        //这里可以用SwipeRefreshLayout+RecyclerView代替。
        //同样的，本项目中Zx...的绝大都不属于框架，可以自由替代
        srNews.setLayoutManager(new LinearLayoutManager(getActivity()))
                .showLoadInfo(false)
                .setSimpleAdapter(new NewsAdapter(dataList))
                .setSRListener(new ZXSRListener<NewsEntity.ResultBean.DataBean>() {
                    @Override
                    public void onItemClick(NewsEntity.ResultBean.DataBean data, int i) {
                        WebActivity.startAction(getActivity(), data.getTitle(), data.getUrl());
                    }

                    @Override
                    public void onItemLongClick(NewsEntity.ResultBean.DataBean data, int i) {

                    }

                    @Override
                    public void onRefresh() {
                        index--;
                        loadData();
                    }

                    @Override
                    public void onLoadMore() {
                        index++;
                        loadData();
                    }
                });
        loadData();
    }

    private void loadData() {
        if (index < 0) {
            index = newsType.length - 1;
        } else if (index > newsType.length - 1) {
            index = 0;
        }
        mPresenter.getNewsInfo(ApiParamUtil.getNewsList(newsType[index]));
    }

    public void onViewClicked(View view) {

    }

    @Override
    public void onNewsListResult(List<NewsEntity.ResultBean.DataBean> newsListResult) {
        srNews.setLoadInfo("点击加载下一模块");
        srNews.stopRefresh();
        dataList.clear();
        dataList.addAll(newsListResult);
        srNews.notifyDataSetChanged();
        srNews.getRecyclerView().scrollToPosition(0);
    }
}
