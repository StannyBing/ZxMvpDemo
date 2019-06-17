package com.stanny.zxmvpdemo.mvp.presenter;

import com.frame.zxmvp.baserx.RxHelper;
import com.frame.zxmvp.baserx.RxSubscriber;
import com.stanny.zxmvpdemo.bean.BeautyEntity;
import com.stanny.zxmvpdemo.mvp.contract.BeautyContract;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class BeautyPresenter extends BeautyContract.Presenter {


    @Override
    public void getBeautyList(int pageNum) {
        mModel.beautyData(pageNum)
                .compose(RxHelper.bindToLifecycle(mView))
                .subscribe(new RxSubscriber<BeautyEntity>(mView) {
                    @Override
                    protected void _onNext(BeautyEntity beautyEntity) {
                        if (beautyEntity.getResults() != null && beautyEntity.getResults().size() > 0) {
                            mView.onBeautyResult(beautyEntity.getResults());
                        }
                    }

                    @Override
                    protected void _onError(String message) {
                        mView.showToast(message);
                    }
                });
    }
}