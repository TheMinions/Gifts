package com.example.administrator.liwushuo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.liwushuo.R;

public class HomeRaidersActivity extends AppCompatActivity {

    private String mWebUrl;
    private WebView mWebView;
    private WebViewClient mWebViewClient;
    private WebChromeClient mChromeClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_raiders);
        Intent intent = getIntent();
        mWebUrl = intent.getStringExtra("web");
        initView();
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.home_raiders);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        mWebView.setWebChromeClient(mChromeClient);
        mWebView.setWebViewClient(mWebViewClient);
        mWebView.loadUrl(mWebUrl);
    }
}
