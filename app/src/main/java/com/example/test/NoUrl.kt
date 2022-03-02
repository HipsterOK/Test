package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class NoUrl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_url)

        val start: Button = findViewById(R.id.startBtn)!!
        start.setOnClickListener{
            startActivity(Intent(this, Spin::class.java))
            Log.i("InterEx", "null")
            finish()
        }
    }
}