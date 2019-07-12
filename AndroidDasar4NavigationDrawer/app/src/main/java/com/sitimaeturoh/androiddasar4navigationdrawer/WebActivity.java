package com.sitimaeturoh.androiddasar4navigationdrawer;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebActivity extends AppCompatActivity {

    WebView web;
    ProgressDialog proggres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.activity_web);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        proggres = new ProgressDialog(WebActivity.this);
        proggres.setMessage("Waiting......");
        proggres.show();

        web = findViewById(R.id.webView);

        web.loadUrl("http://www.idn.id");

        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                proggres.dismiss();
                getSupportActionBar().setTitle(web.getTitle());
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()){
            web.goBack();;
        }else{
            super.onBackPressed();
        }

    }
}
