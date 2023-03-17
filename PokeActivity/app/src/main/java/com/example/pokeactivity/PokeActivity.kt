package com.example.pokeactivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class PokeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke)

        // AdapterView 사용 6단계
        // 1. Container 결정 : LvPoke
        val lvPoke = findViewById<ListView>(R.id.lvPoke)
        // 2. Template 결정 : poke_List.xml
        // 3. Item 결정 : ArrayList<PokeVO>
        val data = ArrayList<PokeVO>()
        data.add(PokeVO("이상해씨","5"))
        data.add(PokeVO("파이리","5"))
        data.add(PokeVO("꼬부기","5"))
        data.add(PokeVO("피카츄","5"))
        data.add(PokeVO("버터풀","5"))
        data.add(PokeVO("피죤","5"))
        data.add(PokeVO("이상해씨","5"))
        data.add(PokeVO("파이리","5"))
        data.add(PokeVO("꼬부기","5"))
        data.add(PokeVO("피카츄","5"))
        data.add(PokeVO("버터풀","5"))
        data.add(PokeVO("피죤","5"))
        // 4. Adapter 결정
        // 만약, Template의 최상위 Layout 이 단순히 TextView 라면
        // ArrayAdapter 를 쓰자!!
        // 아니라면, 만들자
        val adapter = PokeAdapter(this, data)

        // 5. Container 에 Adapter 부착
        lvPoke.adapter = adapter

        // 6. Event 처리
    }
}