package com.stanny.zxmvpdemo.ui.activity;

import android.os.Handler;

import com.frame.zxmvp.base.BaseModel;
import com.frame.zxmvp.base.BasePresenter;
import com.frame.zxmvp.base.RxBaseActivity;
import com.zx.zxutils.util.ZXDialogUtil;
import com.zx.zxutils.util.ZXSharedPrefUtil;
import com.zx.zxutils.util.ZXToastUtil;

/**
 * Created by Xiangb on 2017/6/29.
 * 功能：
 */

public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends RxBaseActivity<T, E> {
    public ZXSharedPrefUtil mSharedPrefUtil = new ZXSharedPrefUtil();
    public Handler handler = new Handler();


    @Override
    public void showToast(String message) {
        ZXToastUtil.showToast(message);
    }

    @Override
    public void showLoading(String message) {
        ZXDialogUtil.showLoadingDialog(this, message);
    }

    @Override
    public void dismissLoading() {
        ZXDialogUtil.dismissLoadingDialog();
    }

}
