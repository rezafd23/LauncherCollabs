package com.example.rezafd.launchercollabs;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView WebViewC;
    private SwipeRefreshLayout refreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebViewC=(WebView)findViewById(R.id.WebViewC);
        refreshLayout=(SwipeRefreshLayout)findViewById(R.id.SwipeRefresh);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);
                LoadView();
            }
        });

        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
                LoadView();
            }
        });


    }

    private void LoadView(){
        WebSettings webSettings = WebViewC.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebViewC.loadUrl("http://www.youtube.com");
        WebViewC.setWebViewClient(new WebViewClient());
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onBackPressed() {
        if (WebViewC.canGoBack()) {
            WebViewC.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
