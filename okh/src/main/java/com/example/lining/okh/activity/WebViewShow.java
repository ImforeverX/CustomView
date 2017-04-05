package com.example.lining.okh.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.example.lining.okh.R;

/**
 * Created by 李宁 on 2017/2/20.
 */

public class WebViewShow extends Activity {
    private WebView webview;
    int position=2;
//    List<Bean.ResultBean.ListBean> datas=new ArrayList<>();
//    private List<Bean.ResultBean.ListBean> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewshow);

        initView();
        initData();
    }
    private void initData() {

        Intent intent = getIntent();
        String extra = intent.getStringExtra("11");

        webview.loadUrl(extra);
    }
    private void initView() {
        webview = (WebView) findViewById(R.id.webview);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

    }
}
