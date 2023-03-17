package com.example.ex20230221

import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private lateinit var con : ConstraintLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. listView에 있는 아이템을 클릭감지
        // 어떤 아이템을 클릭했는지 감지하기
        val btnChoice = findViewById<Button>(R.id.btnChoice)
        con = findViewById(R.id.con)

        btnChoice.setOnClickListener {
            // MainActivity에서 ColorActivity로 이동 ----> 명시적 인텐트
            // 1) intent 생성하기
            // intent에 전달인자로 사용되는 것들은 javaClass 타입을 가지고 있어야한다.
            var intent
            = Intent(this@MainActivity, ColorActivity::class.java)
            // 2) 실행
            // startActivity(intent) ---> 단방향
            // 양방향 : 데이터를 주고받고 싶다~
            // 맞는지 구분하기위해 작성
            // startActivityForResult(intent,1004)
            forResult.launch(intent)
            // callback함수 실행시킬때 Launch() 사용한다.

        }

        // 2. 클릭하면 색상 코드를 가지고 이전화면(MainActivity)
        // 로 돌아가기
        // ( 두 번째 화면에서 데이터를 가지고 가는 양방향 Intent구현)

    }// oncreate밖


    // OnActivityResult라는 함수를 Override하자!
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        // requestCode : 1004
//        // resultCode : RESULT_OK
//        // data : Intent?
//
//        if (requestCode == 1004){
//            if (resultCode == RESULT_OK){
//                // data를 꺼내자!
//                // 자료형확인하는 단축키 : ctrl + shift + p
//                val text = data?.getStringExtra("color")
//                Log.d("color", text.toString())
//                // text ---> String?
//                // Color.parColor()
//                con.setBackgroundColor(Color.parseColor(text))
//            }
//        }
//    }
    private val forResult
            = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        // it : resultCode, data

        if (it.resultCode == RESULT_OK){
            // ColorActivity에서 보낸 데이터가 맞음
            val text = it.data?.getStringExtra("color")
            // it.data -- Intent?
            con.setBackgroundColor(Color.parseColor(text))
        }

    }

    }

    // callback 함수
    // 1. 다른 함수의 인자로 사용되는 함수
    // 2. 어떤 이벤트에 의해 호출되어지는 함수
    // ---> 버튼을 클릭하면 Intent를 실행시키면서 동시에 호출할 수 있는 함수

    // ActivityResultLauncher 사용
    // : 액티비티에서 데이터를 받아올 때 사용
    // bitmap, vector

    // 일급객체
    // 객체지향 프로그래밍 : 클래스
    // 함수형 프로그래밍 : 함수







