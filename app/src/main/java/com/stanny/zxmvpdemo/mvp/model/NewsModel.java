package com.stanny.zxmvpdemo.mvp.model;

import com.frame.zxmvp.base.BaseModel;
import com.frame.zxmvp.baserx.RxSchedulers;
import com.stanny.zxmvpdemo.api.service.ApiService;
import com.stanny.zxmvpdemo.bean.NewsEntity;
import com.stanny.zxmvpdemo.mvp.contract.NewsContract;

import java.util.Map;

import rx.Observable;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class NewsModel extends BaseModel implements NewsContract.Model {


    @Override
    public Observable<NewsEntity> newsData(Map<String, String> map) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getNewsList(map)
                .compose(RxSchedulers.io_main());
    }
}