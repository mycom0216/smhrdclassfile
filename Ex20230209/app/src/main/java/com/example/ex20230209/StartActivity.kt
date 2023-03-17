package com.example.ex20230209

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        val btnMove = findViewById<Button>(R.id.btnMove)
        val btnCall = findViewById<Button>(R.id.btnCall)
        val etColor = findViewById<EditText>(R.id.etColor)
        // btnMove 를 눌렀을 때, FinishActivity 를 호출하자

        // Intent 사용법
        // 1) 명시적 사용법 Intent(출발, 도착)
        // 2) 묵시적 사용법 Intent(액션, 데이터)

        btnCall.setOnClickListener {
            val tel = Uri.parse("tel:01028748675")
            val intent = Intent(Intent.ACTION_CALL, tel)

            // Android 6.0(Mashmellow)이상에서
            // Critical한 행동을 할 때,
            // 예 : 전화 걸기, 인터넷 통신, 주소록 열기, 문자 열기, 사진 찍기

            // 1. AndroidManifest.xml에 권한 허용!!
            // 2. user에게 권한 승인 팝업!!

            // if(CALL_PHONE 권한 체크 != 허용){
            //      권한 허용하시겠습니까? 팝업!!
            // }else{
            //      startActivity(intent)
            // }

            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CALL_PHONE), 1250
                )

            } else {
                startActivity(intent)
            }

            btnMove.setOnClickListener {
                val intent = Intent(this@StartActivity, FinishActivity::class.java)
                val color = etColor.text.toString()
                intent.putExtra("color", color)

                startActivity(intent)
            }
        }
    }
}




