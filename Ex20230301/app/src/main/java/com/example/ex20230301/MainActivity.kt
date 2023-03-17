package com.example.ex20230301

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etId = findViewById<EditText>(R.id.etId)
        val etPw = findViewById<EditText>(R.id.etPw)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val sharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val isLogin = sharedPreferences.getBoolean("isLogin", false)

//        if(isLogin == true){
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//        }

        val loginId = sharedPreferences.getString("id", "")
        val loginPw = sharedPreferences.getString("pw", "")

        etId.setText(loginId)
        etPw.setText(loginPw)

        btnLogin.setOnClickListener {

            val id = etId.text.toString()
            val pw = etPw.text.toString()

            if(id == "nayeho" && pw == "1234"){
                // 로그인 성공

                val intent = Intent(this, HomeActivity::class.java)

                val editor = sharedPreferences.edit()
                editor.putBoolean("isLogin", true)

                editor.putString("id", id)
                editor.putString("pw", pw)

                editor.commit()

                startActivity(intent)




            }else{
                // 로그인 실패
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }

        }


    }
}