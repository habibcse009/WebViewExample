package com.example.habib.webbrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webview = findViewById(R.id.web);
        String getUrl = getIntent().getExtras().getString("url");

        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        if (getUrl.equals("offline")) {
            webview.loadUrl("file:///android_asset/mywebsite.html");
        } else {
            webview.loadUrl("http://" + getUrl);
        }
    }
    //for backpress in webview

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack();
            return true;
        } else {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
