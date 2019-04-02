package com.color_analysis_in_xinjiangtimes.ui;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;

/**
 * author 万强
 * date 16/5/11 下午8:08
 */
public class WebActivity1 extends TextHeaderActivity {

    private String url;

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_web);
    }

    @Override
    public void initTitleBar() {
        String title="";
        title = getIntent().getStringExtra(Constant.STRING_EXTRA2);
        url = getIntent().getStringExtra(Constant.STRING_EXTRA);
        initHeaderStyle(HeaderStyle.LEFT, title);
    }
    @Override
    public void initView() {
        final WebView webView = (WebView) findViewById(R.id.web_view);
        webView.loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
//        webView.getSettings().setDomStorageEnabled(true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setSaveFormData(false);
        webSettings.setLoadsImagesAutomatically(true);
        // http请求的时候，模拟为火狐的UA会造成实时公交那边的页面存在问题，所以模拟iPhone的ua来解决这个问题
        String user_agent =
                "Mozilla/5.0 (Macintosh; U; PPC Mac OS X; en) AppleWebKit/124 (KHTML, like Gecko) Safari/125.1";
        webSettings.setUserAgentString(user_agent);
        webSettings.setSupportZoom(false);
    }
}
