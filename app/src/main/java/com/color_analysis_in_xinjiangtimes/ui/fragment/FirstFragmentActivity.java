package com.color_analysis_in_xinjiangtimes.ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.ui.BaseActivity;


/**
 * Created by Administrator on 2017/9/13.
 */

public class FirstFragmentActivity extends BaseActivity {
//    public String START_URL ="http://m.500.com/info/kaijiang/moreexpect/sfc/";// "http://m.zgzcw.com/kaiJiangHall/show";//http://m.yicp.com/openPrize/openPrizeHall.php";//http://m.okooo.com/kaijiang/";  //未用
    public String START_URL ="https://m.zhibo8.cc/json/paihang/v2/main.html";// "http://m.zgzcw.com/kaiJiangHall/show";//http://m.yicp.com/openPrize/openPrizeHall.php";//http://m.okooo.com/kaijiang/";  //未用
//    http://tools.m.cjcp.com.cn/#&pages/qsfilter.html

    protected WebView appView;
    protected ProgressBar bar;
    RelativeLayout title_rl,rl_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstfragment);
        START_URL = getIntent().getStringExtra(Constant.STRING_EXTRA);
        TextView titles = (TextView) findViewById(R.id.titles);
        titles.setText(getIntent().getStringExtra(Constant.MESSAGE_EXTRA));
        initView();
    }

    /*
     * 初始化view
     */
    private void initView() {

        appView = (WebView) findViewById(R.id.webview);
        bar = (ProgressBar) findViewById(R.id.myProgressBar);
        title_rl = (RelativeLayout) findViewById(R.id.title_rl);
        rl_back = (RelativeLayout) findViewById(R.id.rl_back);
//        rl_back.setVisibility(View.GONE);
        initMethod();
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (appView != null && appView.canGoBack() && !appView.getUrl().equals(START_URL)) {
                    appView.goBack();
                }else{
                    finish();
                }
            }
        });
    }

    private void initMethod() {
        WebSettings webSettings = appView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setDomStorageEnabled(true);
        webSettings.setBlockNetworkImage(false);
        webSettings.setAllowContentAccess(true);
        appView.loadUrl(START_URL);
        //设置webview属性可以对js进行操作
        appView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
                Uri uri = Uri.parse(s);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        appView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    bar.setVisibility(View.GONE);
                } else {
                    bar.setVisibility(View.VISIBLE);
                    bar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        appView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                        if (appView != null && appView.canGoBack() && !appView.getUrl().equals(START_URL)) {
                            appView.goBack();
                            return true;
                        } else {
//                        exit();
                            return false;
                        }

                    }
                    return true;
                }
                return false;
            }
        });
        appView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {


                super.onPageFinished(view, url);
//                String js = ADFilterTool.getClearAdDivJs(getActivity());
//                Log.v("adJs", js);
//                appView.loadUrl(js);
                String hsstr=   "javascript:var adDiv=document.getElementsByClassName(\"header\")[0];adDiv.parentNode.removeChild(adDiv)";

                String hsstr2=   "javascript:var adDiv=document.getElementsByClassName(\"touzhu\")[0];adDiv.parentNode.removeChild(adDiv)";

                String hsstr3=   "javascript:var adDiv=document.getElementsByClassName(\"footer\")[0];adDiv.parentNode.removeChild(adDiv)";
                String hsstr4=   "javascript:var adDiv=document.getElementsByTagName(\"iframe\")[0];adDiv.parentNode.removeChild(adDiv)";
                String hsstr5=   "javascript:var adDiv=document.getElementsByTagName(\"iframe\")[0];adDiv.parentNode.removeChild(adDiv)";
                String hsstr7=   "javascript:var adDiv=document.getElementsByTagName(\"iframe\")[0];adDiv.parentNode.removeChild(adDiv)";
                String hsstr8=   "javascript:var adDiv=document.getElementsByTagName(\"iframe\")[0];adDiv.parentNode.removeChild(adDiv)";


                String hsstr6=   "javascript:var adDiv=document.getElementsByClassName(\"home\")[0];adDiv.parentNode.removeChild(adDiv)";

                String hsstr9=   "javascript:var adDiv=document.getElementsByClassName(\"cz\")[0];adDiv.parentNode.removeChild(adDiv)";

                String hsstr10=   "javascript:var adDiv=document.getElementsByClassName(\"pic_container\")[0];adDiv.parentNode.removeChild(adDiv)";

//                appView.loadUrl(hsstr);
                appView.loadUrl(hsstr2);
//                appView.loadUrl(hsstr3);
//                appView.loadUrl(hsstr4);
//                appView.loadUrl(hsstr5);
//                appView.loadUrl(hsstr6);
//                appView.loadUrl(hsstr7);
//                appView.loadUrl(hsstr8);
//                appView.loadUrl(hsstr9);
//                appView.loadUrl(hsstr10);
//                if (url.equals(START_URL)){
//                    rl_back.setVisibility(View.GONE);
//                }else {
//                    rl_back.setVisibility(View.VISIBLE);
//                }

            }

        });


    }

    @Override
    public void setContentLayout() {

    }
}