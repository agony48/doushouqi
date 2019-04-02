package com.color_analysis_in_xinjiangtimes.ui;

import android.view.View;
import android.webkit.WebView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.utils.SetWebViewTools;

import cn.jpush.android.api.JPushInterface;

public class WebActivity2 extends BaseActivity {
    public static boolean isResume = false;
    private String url;
    private WebView webView;
    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_web2);
        webView = (WebView) findViewById(R.id.web_view);
        findViewById(R.id.back2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        url = getIntent().getStringExtra(Constant.STRING_EXTRA);
        initView();
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(isResume){
            isResume=false;
            SetWebViewTools.setWebView(url,webView,WebActivity2.this);
        }
    }
    public void initView() {
        String token = JPushInterface.getRegistrationID(this);
        SetWebViewTools.setWebView(url,webView,WebActivity2.this);
    }
}
