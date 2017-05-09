package com.example.game_assistent;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;

public class WebViewShow extends Activity {
	private WebView webView;
	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_view);
		url = getIntent().getStringExtra("url");
		webView = (WebView) findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setUseWideViewPort(false); // 将图片调整到适合webview的大小
		webView.getSettings().setSupportZoom(true); // 支持缩放
		webView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN); // 支持内容重新布局
		webView.getSettings().supportMultipleWindows(); // 多窗口
		webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); // 关闭webview中缓存
		webView.getSettings().setAllowFileAccess(true); // 设置可以访问文件
		webView.getSettings().setNeedInitialFocus(true); // 当webview调用requestFocus时为webview设置节点
		webView.getSettings().setBuiltInZoomControls(true); // 设置支持缩放控件的显示
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); // 支持通过JS打开新窗口
		webView.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小
		webView.getSettings().setLoadsImagesAutomatically(true); // 支持自动加载图片
		webView.loadUrl(url);
	}

}
