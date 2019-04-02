package com.color_analysis_in_xinjiangtimes.ui;

import android.webkit.WebView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.utils.SetWebViewTools;

import cn.jpush.android.api.JPushInterface;

public class WebActivity4 extends BaseActivity {
    public static boolean isResume = false;
    private String url;
    private WebView webView;
    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_web4);
        webView = (WebView) findViewById(R.id.web_view);
        url = getIntent().getStringExtra(Constant.STRING_EXTRA);
        initView();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(isResume){
            isResume=false;
            SetWebViewTools.setWebView(url,webView,WebActivity4.this);
        }
    }
    public void initView() {
        String token = JPushInterface.getRegistrationID(this);
        SetWebViewTools.setWebView(url,webView,WebActivity4.this);
    }
}
