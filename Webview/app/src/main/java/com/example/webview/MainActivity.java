package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView mweb=findViewById(R.id.webView);
        mweb.getSettings().setJavaScriptEnabled(true);
        mweb.loadUrl("https://youtube.com/");
    }
}