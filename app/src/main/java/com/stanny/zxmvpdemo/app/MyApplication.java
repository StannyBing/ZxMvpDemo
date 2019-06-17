package com.stanny.zxmvpdemo.app;

import android.content.Context;

import com.frame.zxmvp.baseapp.BaseApplication;
import com.frame.zxmvp.di.component.AppComponent;
import com.zx.zxutils.ZXApp;
import com.zx.zxutils.util.ZXSharedPrefUtil;

public class MyApplication extends BaseApplication {


    private static Context sContext;
    public static ZXSharedPrefUtil mSharedPrefUtil;
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        ZXApp.init(this, true);
        MyApplication.sContext = getApplicationContext();
        mSharedPrefUtil = new ZXSharedPrefUtil();
        appComponent = getAppComponent();
    }
}
