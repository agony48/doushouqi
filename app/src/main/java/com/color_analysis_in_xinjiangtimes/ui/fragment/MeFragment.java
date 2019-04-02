package com.color_analysis_in_xinjiangtimes.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.color_analysis_in_xinjiangtimes.R;
import com.color_analysis_in_xinjiangtimes.module.Constant;
import com.color_analysis_in_xinjiangtimes.ui.BaseFragment;
import com.color_analysis_in_xinjiangtimes.ui.WebActivity2;

/**
 * author lishan
 * date 2016-08-30 14:12:56
 * desc 我的
 */
public class MeFragment extends BaseFragment {
    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catergory, container, false);
        final WebView webView = (WebView) view.findViewById(R.id.web_view);
        setWebView("http://m.24zbw.com/",webView);
        return view;
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
                if(url!=null&&(url.equals("http://m.aicai.com/league/concern/myConcernMatch?agentId=1&vt=5"))){
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("提示");
                    builder.setMessage("该功能暂未开放。就此给您带来的不便，敬请谅解！");
                    builder.setCancelable(false);
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            webview.loadUrl("http://m.aicai.com/newInfo/index.do?agentId=1&vt=5");
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            webview.loadUrl("http://m.aicai.com/newInfo/index.do?agentId=1&vt=5");
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                    return true;
                }
                if(url!=null&&!(url.equals("http://m.aicai.com/league/concern/myConcernMatch?agentId=1&vt=5"))){
                    Intent intent = new Intent(getActivity(), WebActivity2.class);
                    intent.putExtra(Constant.STRING_EXTRA, url);
                    startActivity(intent);
                    return true;
                }
                if(url!=null&&(url.equals("http://m.aicai.com/m/login.do?agentId=1&vt=5"))||(url.equals("http://m.aicai.com/m/login.do?vt=5&agentId=1"))){
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            getActivity());
                    builder.setTitle("提示");
                    builder.setMessage("应主管部门要求，当前各彩票网站均暂停售彩，已售出彩票兑奖不受影响。购买彩票建议您查询附近的实体网点。就此给您带来的不便，敬请谅解！");
                    builder.setCancelable(false);
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            webview.loadUrl(urlload);
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            webview.loadUrl(urlload);
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
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
