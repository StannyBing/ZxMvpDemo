package com.stanny.zxmvpdemo.mvp.model;

import com.frame.zxmvp.base.BaseModel;

import com.frame.zxmvp.baserx.RxSchedulers;
import com.stanny.zxmvpdemo.api.service.ApiService;
import com.stanny.zxmvpdemo.bean.CodeSorceEntity;
import com.stanny.zxmvpdemo.mvp.contract.CodeSourceContract;

import rx.Observable;

/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class CodeSourceModel extends BaseModel implements CodeSourceContract.Model {


    @Override
    public Observable<CodeSorceEntity> sourceData(int pageNum) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getSourceList("http://gank.io/api/data/Android/10/" + pageNum)
                .compose(RxSchedulers.io_main());
    }
}