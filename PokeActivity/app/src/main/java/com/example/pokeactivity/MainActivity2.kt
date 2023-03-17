package com.example.pokeactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // 1. 화면에서 RecyclerView의 위치 정해주기
        // 2. 한칸에 들어갈 디자인 만들기 (xml)
        // 3. 데이터 만들기
        // 포켓몬 이름, 스킬, 레벨 + 이미지(R.drawable.p1) ---> Int
        // PokeMonVO("피카츄", "백만볼트", "level 3", R.drawable.p1)
        // name, skill, lv , img : Int -----> PokeMonVO
        // ArrayList<PokeMonVo>
        // 4. PokeMonAdapter 만들기 ---> RecyclerView.Adapter를 상속
        // 5. adapter 적용시키기
        // ---> LinearLayoutManager로 배치





    }
}