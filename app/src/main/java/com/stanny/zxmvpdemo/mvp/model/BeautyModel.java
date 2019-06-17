package com.stanny.zxmvpdemo.mvp.model;

import com.frame.zxmvp.base.BaseModel;
import com.frame.zxmvp.baserx.RxSchedulers;
import com.stanny.zxmvpdemo.api.service.ApiService;
import com.stanny.zxmvpdemo.bean.BeautyEntity;
import com.stanny.zxmvpdemo.mvp.contract.BeautyContract;

import rx.Observable;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class BeautyModel extends BaseModel implements BeautyContract.Model {


    @Override
    public Observable<BeautyEntity> beautyData(int pageNum) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getBeautyList("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/" + pageNum)
                .compose(RxSchedulers.io_main());
    }
}