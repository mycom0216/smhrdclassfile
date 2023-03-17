package com.example.ex20230209
// 경로
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// 현재 클래스에서 사용하고있는 기능
// 모든 뷰들은 경로가 widget

// : -> 상속(extends, implements
class MainActivity : AppCompatActivity() {

    //  전역변수
    // 변수 선언 1번만 이루어져야한다.
    private lateinit var tvHello : TextView
    // null
    // tvHello가 나중에 OnCreate안에서 반드시 초기화가 된다라는 것을 약속
    // : private Lateinit var









    // Javq main() == Oncreate()
    // 실행시킬 코드들은 onCreate안으로 넣어줘야 한다
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. activity에 있는 TextView의 색깔을 바꾸자
        // 0) View에 id가 달려있어야한다 (xml에서만 가능)
        // 1) id를 통해서 View를 찾아와야한다
        // <> : 자료형(클래스 자료형)
        // Int, String, Float
        // View ---> TextView, Button, ImageView
        // val 변수명 : 뷰의 자료형 = findViewById<뷰의 자료형>(R.id.id값)
        // + 자동완성하면 자동 import
        // import 단축키 : alt + enter
        // + 글씨체가 회색 ---> 사용이 안되고있는 변수/기능, 필요없는 코드
        tvHello = findViewById<TextView>(R.id.tvHello)
        // Button 3개를 id값을 통해서 사용할 수 있도록 만들어주세요
        val btnColor = findViewById<Button>(R.id.btnColor)
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnLog = findViewById<Button>(R.id.btnLog)
        // CastException : btnColor라는 id값을 가진 뷰가 TextView가 정말 맞는지 확인

        // Button에 클릭 Event를 달아주는 방법
        // 1) 속성 onClick <- 내가 만든 이벤트(함수)를 적용
        // 2) OnclickListener라는 인터페이스를 상속 -> 구현
        // 3) inner class를 사용한다 ---> Java
        // 4) 람다식으로 자동완성 시켜줌
        btnToast.setOnClickListener {
            // 클릭을 했을때 일어날 이벤트
            // Toast를 띄워보자
            // 화면정보를 의미하는 키워드 : this@MainActivity
            Toast.makeText(this@MainActivity, tvHello.text.toString(),
            Toast.LENGTH_SHORT).show()
        }


        // 2) 색깔을 바꿔주는 속성을 사용한다
        // tvHello.setTextColor(Color.parseColor("red"))
        // Color.parseColor ---> String으로 입력한 값을 Color타입으로 바꿔줌
        

    }
    // onCreate 밖에 function 만들기
    fun clickEvent(view : View) : Unit{
        // 속성으로 달아주는 이벤트
        // 매개변수 : View를 받아온다
        // view ---> 이벤트가 달려있는 뷰의 정보를 다 받아옴
        // 속성들.. id,width,height

        // view에서 id를 가져오자
        if(view.id == R.id.btnColor){
            tvHello.setTextColor(Color.parseColor("red"))
        }


    }


}

