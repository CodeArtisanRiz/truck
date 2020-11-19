package com.t3g.truck;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadWeb();
    }

    @SuppressLint("SetJavaScriptEnabled")
    public  void LoadWeb(){
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://alphatruck.tk");
        progressBar=(ProgressBar)findViewById(R.id.pro) ;
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged (WebView view, int newProgress){
                progressBar.setProgress(newProgress);
                if (newProgress==100){
                    progressBar.setVisibility(View.GONE);

                }else{
                    progressBar.setProgress(View.VISIBLE);

                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            finish();
        }
    }
}