package com.example.test

import android.os.Bundle
import android.view.View
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity

class Url : AppCompatActivity() {
    lateinit var web: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url)

        val func = Func()
        web = findViewById(R.id.web)

        val webSettings: WebSettings = web.settings
        webSettings.javaScriptEnabled = true
        web.webViewClient = WebViewClient()
        CookieManager.getInstance().setAcceptThirdPartyCookies(web, true);
        if(func.checkForInternet(this)){
            intent.getStringExtra("URL")?.let { web.loadUrl(it) }
        }
        else{
            func.onAlertDialog(View(this))
        }
    }

    override fun onBackPressed() {
        if (web.canGoBack()) {
            web.goBack()
        }
    }

    override fun onPause() {
        super.onPause()
        CookieSyncManager.getInstance().sync()
    }
}