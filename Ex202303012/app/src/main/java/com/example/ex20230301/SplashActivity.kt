package com.example.ex20230301

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

private class
SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 3초간 화면에 보였다가 IntroActivity로 넘어가는 곳
        // Thread/Handler

        // OnCreate ---> 3초정도 있다가 코드를 실행 (Intent)
        // Handler().postDelayed({실행코드},duration) : 코드 실행을 지연
        Handler().postDelayed({
                              val intent = Intent(this@SplashActivity,
                              IntroActivity::class.java)
            startActivity(intent)
            finish()
        },
        3000)


    }
}