package com.fourbitechnology.coffee_up;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView WebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = WebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        WebView.loadUrl("https://barapptest.altervista.org");

        WebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView viewx, String urlx) {
                viewx.loadUrl(urlx);
                return false;
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView WebView = (WebView) findViewById(R.id.webview);
        // Controllo se il tasto indietro è stato premuto e posso tornare indietro
        if ((keyCode == KeyEvent.KEYCODE_BACK) && WebView.canGoBack()) {
            WebView.goBack();
            return true;
        }
        //Se non si puù tornare indietro, sollevo l'input al SO
        return super.onKeyDown(keyCode, event);
    }
}

