package com.color_analysis_in_xinjiangtimes.ui;

import android.os.Bundle;
import android.webkit.WebView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.utils.SetWebViewTools;

import cn.jpush.android.api.JPushInterface;

public class WebActivity6 extends BaseActivity {
    public static boolean isResume = false;
    private String url;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web6);
        webView = (WebView) findViewById(R.id.web_view);
        url = getIntent().getStringExtra(Constant.STRING_EXTRA);
        initView();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(isResume){
            isResume=false;
            SetWebViewTools.setWebView(url,webView,WebActivity6.this);
        }
    }

    @Override
    public void setContentLayout() {

    }

    public void initView() {
        String token = JPushInterface.getRegistrationID(this);
//        Log.e("TAG","url->"+url);
        SetWebViewTools.setWebView(url,webView,WebActivity6.this);
    }
//    private long exitTime;
//    @Override
//    public void onBackPressed() {
//        if ((System.currentTimeMillis() - exitTime) > 2000) {
//            showShortToast(getString(R.string.tips_exit_str));
//            exitTime = System.currentTimeMillis();
//        } else {
//            finish();
//            System.exit(0);
//        }
//    }
}
