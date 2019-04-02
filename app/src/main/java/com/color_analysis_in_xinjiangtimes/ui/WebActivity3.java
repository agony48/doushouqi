package com.color_analysis_in_xinjiangtimes.ui;

import android.webkit.WebView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.utils.SetWebViewTools;

/**
 * author 万强
 * date 16/5/11 下午8:08
 */
public class WebActivity3 extends TextHeaderActivity {

    private int type;
    private String url;

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_web);
        type = getIntent().getIntExtra(Constant.TYPE, Constant.WebType.REGISTER.ordinal());
    }

    @Override
    public void initTitleBar() {
        String title="";
            title = getIntent().getStringExtra(Constant.MESSAGE_EXTRA);
            url = getIntent().getStringExtra(Constant.STRING_EXTRA);
        initHeaderStyle(HeaderStyle.LEFT, title);
    }
    @Override
    public void initView() {
        final WebView webView = (WebView) findViewById(R.id.web_view);
        SetWebViewTools.setWebView(url,webView,WebActivity3.this);
    }
}
