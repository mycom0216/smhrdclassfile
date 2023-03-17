package com.example.ex20230209

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)


        // 내가 id를 부여한 view객체들을 초기화하자!!
        val img = findViewById<ImageView>(R.id.img)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnPre = findViewById<Button>(R.id.btnPre)



        btnNext.setText("->")
        btnPre.setText("<-")
        btnNext.setTextSize(32f)
        btnPre.setTextSize(32f)

        val imgs = arrayOf<Int>(R.drawable.yellow, R.drawable.pink, R.drawable.black,
        R.drawable.red, R.drawable.blue)

        var index = 0
        img.setImageResource(imgs.get(index))

        // btnPre를 눌렀을 때, 이전 이미지로 바꾸기
        btnPre.setOnClickListener {
            index--

            if(index == -1){
                index = 4
            }

            img.setImageResource(imgs.get(index))
        }






        img.setImageResource(R.drawable.yellow)

        // btnNext를 눌렀을 때, 다음 이미지로 바꾸기!!
        btnNext.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                index++

                // 만약 index가 5라면, index를 0으로 만들어주자
                if(index == 5){
                    index = 0
                }
                img.setImageResource(imgs.get(index))



            }
        })


    }


}
