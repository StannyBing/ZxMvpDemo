package com.stanny.zxmvpdemo.mvp.presenter;

import com.frame.zxmvp.baserx.RxHelper;
import com.frame.zxmvp.baserx.RxSubscriber;
import com.stanny.zxmvpdemo.bean.CodeSorceEntity;
import com.stanny.zxmvpdemo.mvp.contract.CodeSourceContract;


/**
 * Create By admin On 2017/7/11
 * 功能：
 */
public class CodeSourcePresenter extends CodeSourceContract.Presenter {


    @Override
    public void getSourceList(int pageNum) {
        mModel.sourceData(pageNum)
                .compose(RxHelper.bindToLifecycle(mView))
                .subscribe(new RxSubscriber<CodeSorceEntity>() {
                    @Override
                    protected void _onNext(CodeSorceEntity codeSorceEntity) {
                        if (codeSorceEntity.getResults() != null && codeSorceEntity.getResults().size() > 0) {
                            mView.onSourceResult(codeSorceEntity.getResults());
                        }
                    }

                    @Override
                    protected void _onError(String message) {
                        mView.showToast(message);
                    }
                });
    }
}