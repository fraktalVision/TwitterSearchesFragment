package com.deitel.twittersearches;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;

public class TwitterWebFragment extends WebViewFragment {

    private static final String URL_STRING = "url";
    private String urlString;

    public TwitterWebFragment() { super(); }

    public static TwitterWebFragment newInstance(String url) {
        TwitterWebFragment twitter = new TwitterWebFragment();
        Bundle args = new Bundle();
        args.putString(URL_STRING, url);
        twitter.setArguments(args);
        return twitter;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            urlString = getArguments().getString(URL_STRING);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        launchWeb(urlString);
    }

    private void launchWeb(String urlString) {
        WebView web = getWebView();
        if (web != null) {
            WebSettings settings = web.getSettings();
            web.setBackgroundColor(Color.BLUE);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setUseWideViewPort(true);
            web.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    view.setVisibility(View.VISIBLE);
                    return true;
                }
            });

            web.loadUrl(urlString);
        }
    }
}
