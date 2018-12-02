package com.arianroid.betterokhttp.tools.views.web;


import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CustomeWebViewClient extends WebViewClient {

    private static boolean isDataLoaded = false;
    private boolean isRedirected;

    public static boolean isDataLoaded() {
        return isDataLoaded;
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Log.i("LogMe", "shouldOverrideUrlLoading: N Android verison");
        view.loadUrl(request.getUrl().toString());
        isRedirected = true;
        return false;

    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.i("LogMe", "shouldOverrideUrlLoading: ");
        view.loadUrl(url);
        isRedirected = true;
        return false;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if (!isRedirected) {
            Log.i("LogMe", "onPageStarted: ");
            super.onPageStarted(view, url, favicon);
        }
        isRedirected = false;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if (!isRedirected) {
            Log.i("LogMe", "onPageFinished: ");
            super.onPageFinished(view, url);
            isDataLoaded = true;
        }
    }
}
