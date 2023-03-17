package com.example.ex20230221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)
        // 1. ListView에 있는 아이템을 클릭감지
        // 어떤 아이템을 클릭했는지 감지하기

        val lv = findViewById<ListView>(R.id.lv)
        lv.setOnItemClickListener { adapterView, view, i, l ->
            // adopterView : ListView에 대한 정보
            // view : ListView가 있는 현재 페이지에 대한 정보
            // i (postion) : 내가 클릭한 itme의 위치 정보
            // ---> index값처럼 0부터 시작!
            // L(Long) : 내가 클릭한 item의 id값
            var color = ""


            if (i == 0){
                // Pink
                color = "#FFFF00"
            }else if(i == 1){
                // blue
                color = "#FF0F00"
            }else if(i == 2){
                // green
                color = "#04FF00"
            }

            // color에 내가 선택한 항목에 대한 색상문자가 들어가있는 상태
            // color를 MainActivity로 보내주자!
            // putExtra : intent에 데이터를 넣어주는 작업
            // (키값, value)
            intent.putExtra("color", color)
            setResult(RESULT_OK, intent)
            finish() // 이전 화면으로 돌아가기




        }



    }
}