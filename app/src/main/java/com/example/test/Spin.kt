package com.example.test

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class Spin : AppCompatActivity() {
    var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spin)

        val btnSpin:Button = findViewById(R.id.btnSpin)
        val ivWheel:ImageView = findViewById(R.id.ivWheel)
        val txtView:TextView = findViewById(R.id.textView)

        val random = Random()

        btnSpin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {

                btnSpin.setEnabled(false)

                var spin: Int = random.nextInt(20) + 10

                spin = spin * 36

                timer = object : CountDownTimer((spin * 10).toLong(), 1) {
                    override fun onTick(l: Long) {
                        // rotate the wheel
                        val rotation: Float = ivWheel.getRotation() + 2
                        ivWheel.setRotation(rotation)
                    }

                    override fun onFinish() {
                        // enabling the button again
                        txtView.setText("Score: ${random.nextInt(100)*10}")
                        btnSpin.setEnabled(true)
                    }
                }.start()
            }
        })
    }
}