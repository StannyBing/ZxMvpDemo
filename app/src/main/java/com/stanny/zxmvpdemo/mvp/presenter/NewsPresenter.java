package com.stanny.zxmvpdemo.mvp.presenter;

import com.frame.zxmvp.baserx.RxHelper;
import com.frame.zxmvp.baserx.RxSubscriber;
import com.stanny.zxmvpdemo.bean.NewsEntity;
import com.stanny.zxmvpdemo.mvp.contract.NewsContract;

import java.util.List;
import java.util.Map;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class NewsPresenter extends NewsContract.Presenter {


    @Override
    public void getNewsInfo(Map<String, String> map) {
        mModel.newsData(map)
                .compose(RxHelper.bindToLifecycle(mView))
                .subscribe(new RxSubscriber<NewsEntity>(mView) {
                    @Override
                    protected void _onNext(NewsEntity newsBean) {
                        if (newsBean.getResult() != null && newsBean.getResult().getData() != null) {
                            List<NewsEntity.ResultBean.DataBean> dataList = newsBean.getResult().getData();
                            mView.onNewsListResult(dataList);
                        }
                    }

                    @Override
                    protected void _onError(String message) {
                        mView.showToast(message);
                    }
                });
    }
}