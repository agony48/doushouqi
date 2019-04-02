package com.color_analysis_in_xinjiangtimes.ui;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;

public class WebActivity5 extends BaseActivity {
    @Override
    public void setContentLayout() {
        setContentView(R.layout.web5_layout);
        WebView webView = (WebView) findViewById(R.id.web_view);
        TextView titles = (TextView) findViewById(R.id.title);
        titles.setText(getIntent().getStringExtra(Constant.MESSAGE_EXTRA));
        setWebView(getIntent().getStringExtra(Constant.STRING_EXTRA),webView);
    }
    /**
     * 加载webView的方法
     */
    public void setWebView(final String urlload, final WebView webview) {
        //      对webView的设置
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        webview.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
                Uri uri = Uri.parse(s);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

            }
        });
        /**
         * 拿到当前页面的url
         */
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("TAG","url=>"+url);
                if(url!=null){
                    Intent intent = new Intent(WebActivity5.this, WebActivity2.class);
                    intent.putExtra(Constant.STRING_EXTRA, url);
                    startActivity(intent);
//                    finish();
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });
        webview.loadUrl(urlload);
    }
}
