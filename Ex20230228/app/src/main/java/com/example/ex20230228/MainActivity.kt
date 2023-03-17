package com.example.ex20230228

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fragment (부분화면)
        // : Activity 위에서 동작하는 화면
        //   독립적으로 존재할 수 없다 무조건 Activity랑 같이 만들어야한다!

        // 1. View들의 id값 찾아오기
        val bnv = findViewById<BottomNavigationView>(R.id.bnv)
        val fl = findViewById<FrameLayout>(R.id.fl)

        // 2. bnv의 item 클릭을 감지 (이벤트 리스너)
        bnv.setOnItemSelectedListener { item ->
            // item -> bnv에서 클릭한 item에 대한 정보
           // item.itemId ----> tab1,tab2,... tab4

            if (item.itemId == R.id.tab1){
                // Fragment1이 FrameLayout위로 올라온다
                Toast.makeText(this@MainActivity,
                "Fragment1입니다.", Toast.LENGTH_SHORT).show()
                // FragmentManager ---> Fragment가 반영될  수 있도록
                supportFragmentManager.beginTransaction().replace(
                   // Fragment를 어디에 올릴껀지 ---> FrameLayout
                R.id.fl,
                    // 어떤 Fragment를 올릴껀지 ---> Fragment1
                Fragment1()
                ).commit()


            }else if (item.itemId == R.id.tab2){
                // Fragment2
                Toast.makeText(this@MainActivity,
                    "Fragment2입니다.", Toast.LENGTH_SHORT).show()

                supportFragmentManager.beginTransaction().replace(
                    R.id.fl,
                    Fragment2()
                ).commit()



            }else if (item.itemId == R.id.tab3){
                // Fragment3
                Toast.makeText(this@MainActivity,
                    "Fragment3입니다.", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().replace(
                    R.id.fl,
                    Fragment3()
                ).commit()

            }else if (item.itemId == R.id.tab4){
                // Fragment4
                Toast.makeText(this@MainActivity,
                    "Fragment4입니다.", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().replace(
                    R.id.fl,
                    Fragment4()
                ).commit()
            }
            // 클릭 이벤트가 끝나지 않았다고 판단
            // 색깔이나 커서모양이 변하지 않음
            true

        }
        // 3. 어떤 item인지에 따라서 Fragment를 FrameLayout에 띄워준다









    }
}