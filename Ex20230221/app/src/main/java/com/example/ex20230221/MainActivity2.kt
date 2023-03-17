package com.example.ex20230221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // 1. btnLogin을 눌렀을 때
        // 1) LoginActivity로 이동 (양방향 : Launch)
        // 2. LoginActivity에서 btnResult를 눌렀을 때
        // EditText에 적혀있는 id,pw값을 가져온다

        // id, pw값이 Main2로 가져와야 한다`

    }
}