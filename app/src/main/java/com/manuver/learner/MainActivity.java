package com.manuver.learner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    WebView mainWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainScreenLinearLayout = new LinearLayout(getApplicationContext());
        setContentView(mainScreenLinearLayout);


        mainScreenLinearLayout.setPadding(10, 10, 10, 10);

        mainWebView = new WebView(getApplicationContext());
        mainWebView.setWebViewClient(new WebViewClient());
        mainWebView.getSettings().setJavaScriptEnabled(true);

        mainScreenLinearLayout.addView(mainWebView);
        String url = getIntent().getDataString();
        if (url == null) url = "https://duckduckgo.com";
        mainWebView.loadUrl(url);
        mainWebView.setMinimumHeight(400);
    }

    public void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
