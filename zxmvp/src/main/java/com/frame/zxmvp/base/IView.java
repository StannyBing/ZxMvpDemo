package com.frame.zxmvp.base;

/**
 * des:baseview
 * Created by xsf
 * on 2016.07.11:53
 */
public interface IView {
    //    /*******内嵌加载*******/
    void showLoading(String message);

    void dismissLoading();

    void showToast(String message);
}
