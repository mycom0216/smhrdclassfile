package com.example.ex20230209

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        // StartActivity 쪽
        // button id
        // btnMove, btnCall
        // btnBack

        val btnFinish = findViewById<Button>(R.id.btnFinish)
        val cl = findViewById<ConstraintLayout>(R.id.cl)

        val color = intent.getStringExtra("color")!!

        // 값을 확인하는 법
        // 1. print()
        // 2. Toast
        // 3. Log
        // d, e, i, v, w
        Log.d("색깔", color)

        try {
            val bgColor = Color.parseColor(color)
            cl.setBackgroundColor(bgColor)
        }catch (e : IllegalArgumentException){
            e.printStackTrace()
            cl.setBackgroundColor(Color.parseColor("yellow"))
        }




        btnFinish.setOnClickListener {

            // 명시적 intent 사용
            // FinishActivity -> StartActivity
           finish()
        }

    }
}


