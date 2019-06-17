package com.stanny.zxmvpdemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.stanny.zxmvpdemo.R;
import com.stanny.zxmvpdemo.mvp.contract.MainContract;
import com.stanny.zxmvpdemo.mvp.model.MainModel;
import com.stanny.zxmvpdemo.mvp.presenter.MainPresenter;
import com.stanny.zxmvpdemo.ui.fragment.BeautyFragment;
import com.stanny.zxmvpdemo.ui.fragment.NewsFragment;
import com.zx.zxutils.views.TabViewPager.ZXTabViewPager;

import butterknife.BindView;


/**
 * Create By admin On 2017/7/11
 * 功能：主页
 */
public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainContract.View {

    @BindView(R.id.tvp_main)
    ZXTabViewPager tvpMain;

    public static void startAction(Activity activity, boolean isFinish) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        if (isFinish) activity.finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        tvpMain.setManager(getSupportFragmentManager())
                .setTabLayoutGravity(ZXTabViewPager.TabGravity.GRAVITY_TOP)
                .setIndicatorHeight(6)
//                .addTab(CodeSourceFragment.newInstance(), "Android")
                .addTab(NewsFragment.newInstance(), "新闻")
                .addTab(BeautyFragment.newInstance(), "福利")
                .build();
    }

    public void onViewClicked(View view) {

    }

}
