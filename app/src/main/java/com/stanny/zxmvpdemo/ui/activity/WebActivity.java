package com.stanny.zxmvpdemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.stanny.zxmvpdemo.R;
import com.zx.zxutils.util.ZXToastUtil;
import com.zx.zxutils.views.SwipeBack.ZXSwipeBackHelper;

/**
 * 如果简单activity不需要框架，也完全可以不继承BaseActivity
 */
public class WebActivity extends AppCompatActivity {

    private TextView tvTitle;
    private ImageView ivBack;
    private WebView webContent;

    public static void startAction(Activity activity, String title, String url) {
        Intent intent = new Intent(activity, WebActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        if (url.length() == 0) {
            ZXToastUtil.showToast("地址不可用");
            return;
        }
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ZXSwipeBackHelper.onCreate(this)
                .setSwipeBackEnable(true)
                .setSwipeRelateEnable(true);
        setContentView(R.layout.activity_web);
        tvTitle = (TextView) findViewById(R.id.tv_webTitle);
        ivBack = (ImageView) findViewById(R.id.iv_webBack);
        webContent = (WebView) findViewById(R.id.web_content);
        ivBack.setOnClickListener(view -> finish());
        tvTitle.setText(getIntent().getStringExtra("title"));
        webContent.loadUrl(getIntent().getStringExtra("url"));
        WebSettings webSettings = webContent.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setTextSize(WebSettings.TextSize.SMALLER);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webContent.canGoBack()) {
            webContent.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
