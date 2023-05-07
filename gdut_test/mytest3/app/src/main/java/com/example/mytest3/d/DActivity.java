package com.example.mytest3.d;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.mytest3.R;

public class DActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        webView=findViewById(R.id.webView);
        //webView.loadUrl("https://www.codenong.com/625433/");


        //html
        //webView.loadUrl("file:///android_asset/html/html.html");


        //js
        webView.getSettings().setJavaScriptEnabled(true);//webView中可以使用JS
        webView.loadUrl("file:///android_asset/javaScript/javaScript.html");
    }
}