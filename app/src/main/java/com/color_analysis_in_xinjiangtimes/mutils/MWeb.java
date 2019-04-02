package com.color_analysis_in_xinjiangtimes.mutils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;


public class MWeb extends Activity {
	WebView webView;
	String urlurl;

	boolean b=false;
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		webView=new WebView(this);
		setContentView(webView);
		WebSettings webSettings = webView.getSettings();

// 支持javascript
		webSettings.setJavaScriptEnabled(true);

// 支持使用localStorage(H5页面的支持)
		webSettings.setDomStorageEnabled(true);

// 支持数据库
		webSettings.setDatabaseEnabled(true);

// 支持缓存
		webSettings.setAppCacheEnabled(true);
		String appCaceDir = this.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
		webSettings.setAppCachePath(appCaceDir);

// 扩大比例的缩放
		webSettings.setSupportZoom(true);

		webSettings.setBuiltInZoomControls(true);

// 隐藏缩放按钮
		webSettings.setDisplayZoomControls(false);

// 自适应屏幕
		webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webSettings.setLoadWithOverviewMode(true);

// 隐藏滚动条
		webView.setHorizontalScrollBarEnabled(false);
		webView.setVerticalScrollBarEnabled(false);
// 进度显示及隐藏
		webView.setDownloadListener(new DownloadListener() {
			@Override
			public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
				downloadByBrowser(s);
			}
		});

// 处理网页内的连接（自身打开）
		webView.setWebViewClient(new WebViewClient() {


			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {



			}

			@Override
			public void onPageFinished(WebView view, String url) {

			}

			@Override
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
				super.onReceivedError(view, errorCode, description, failingUrl);

			}


			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {

				// 如下方案可在非微信内部WebView的H5页面中调出微信支付



				if (url.startsWith("weixin://wap/pay?") | url.startsWith("mqqapi") | url.startsWith("alipay")) {

					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setData(Uri.parse(url));

					WebBackForwardList backForwardList = webView.copyBackForwardList();
					int currentIndex = backForwardList.getCurrentIndex();
					int i=1;
					while (true) {
						WebHistoryItem historyItem = backForwardList.getItemAtIndex(currentIndex - i);
						if (historyItem != null) {
							String backPageUrl = historyItem.getUrl();
							//url拿到可以进行操作

							if (!isyou(backPageUrl,urlurl)){ webView.goBack();}else {
								webView.goBack();
								break;
							}

						}
						i++;
					}
					startActivity(intent);






					return true;
				} else if (parseScheme(url)) {
					try {
						Intent intent;
						intent = Intent.parseUri(url,
								Intent.URI_INTENT_SCHEME);
						intent.addCategory("android.intent.category.BROWSABLE");
						intent.setComponent(null);
						// intent.setSelector(null);
						//   webView.goBack();
						WebBackForwardList backForwardList = webView.copyBackForwardList();
						int currentIndex = backForwardList.getCurrentIndex();
						int i=1;
						while (true) {
							WebHistoryItem historyItem = backForwardList.getItemAtIndex(currentIndex - i);
							if (historyItem != null) {
								String backPageUrl = historyItem.getUrl();
								//url拿到可以进行操作
								if (!isyou(backPageUrl,urlurl)){ webView.goBack();}else {
									webView.goBack();
									break;
								}
							}
							i++;
						}
						startActivity(intent);

						return true;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}




				return false;




			}




		});

// 使用返回键的方式防止网页重定向
		webView.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
						webView.goBack();
						return true;
					}
				}
				return false;
			}
		});






//        Toast.makeText(this,getIntent().getStringExtra("url"),3000).show();
		if (getIntent().getStringExtra("url").contains("http://")|getIntent().getStringExtra("url").contains("https://"))
		{
			webView.loadUrl(getIntent().getStringExtra("url"));
			URL url = null;
			try {
				url = new URL(getIntent().getStringExtra("url"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			urlurl= url.getHost();// 获取主机名
		}else {
			webView.loadUrl("http://"+getIntent().getStringExtra("url"));

			URL url = null;
			try {
				url = new URL("http://"+getIntent().getStringExtra("url"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			urlurl= url.getHost();// 获取主机名

		}






		webView.setWebChromeClient(new WebChromeClient() {

			// Android 3.0 以下
			public void openFileChooser(ValueCallback<Uri> valueCallback) {
				uploadMessage = valueCallback;
				selectImage();
			}

			// Android 3~4.1
			public void openFileChooser(ValueCallback valueCallback, String acceptType) {
				uploadMessage = valueCallback;
				selectImage();
			}

			// Android  4.1以上
			public void openFileChooser(ValueCallback<Uri> valueCallback, String acceptType, String capture) {
				uploadMessage = valueCallback;
				selectImage();
			}

			// Android 5.0以上
			@Override
			public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
				uploadMessageAboveL = filePathCallback;
				selectImage();
				return true;
			}
		});




	}
	//全局声明，用于记录选择图片返回的地址值
	private ValueCallback<Uri> uploadMessage;
	private ValueCallback<Uri[]> uploadMessageAboveL;
	private void selectImage() {
		Intent i = new Intent(Intent.ACTION_GET_CONTENT);
		i.addCategory(Intent.CATEGORY_OPENABLE);
		i.setType("image/*");
		startActivityForResult(Intent.createChooser(i, "Image Chooser"), 15);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 15) {
			if (null == uploadMessage && null == uploadMessageAboveL) return;
			Uri result = data == null || resultCode != RESULT_OK ? null : data.getData();
			if (uploadMessageAboveL != null) {
				onActivityResultAboveL(requestCode, resultCode, data);
			} else if (uploadMessage != null) {
				uploadMessage.onReceiveValue(result);
				uploadMessage = null;
			}
		}
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	private void onActivityResultAboveL(int requestCode, int resultCode, Intent intent) {
		if (requestCode != 15 || uploadMessageAboveL == null)
			return;
		Uri[] results = null;
		if (resultCode == Activity.RESULT_OK) {
			if (intent != null) {
				String dataString = intent.getDataString();
				ClipData clipData = intent.getClipData();
				if (clipData != null) {
					results = new Uri[clipData.getItemCount()];
					for (int i = 0; i < clipData.getItemCount(); i++) {
						ClipData.Item item = clipData.getItemAt(i);
						results[i] = item.getUri();
					}
				}
				if (dataString != null)
					results = new Uri[]{Uri.parse(dataString)};
			}
		}
		uploadMessageAboveL.onReceiveValue(results);
		uploadMessageAboveL = null;
	}
	public boolean parseScheme(String url) {

		if (url.contains("platformapi/startapp")) {
			return true;
		} else if ((Build.VERSION.SDK_INT > 23)
				&& (url.contains("platformapi") && url.contains("startapp"))) {
			return true;
		} else {
			return false;
		}
	}

	private void downloadByBrowser(String url) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addCategory(Intent.CATEGORY_BROWSABLE);
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}


	public  boolean isyou(String s1, String s2){




		String str=s1;
		if(str.indexOf(s2)!=-1){

			return  true;

		}else{

			return  false;
		}
	}


	@Override
	protected void onResume() {
		super.onResume();
//		webView.reload();
	}

}