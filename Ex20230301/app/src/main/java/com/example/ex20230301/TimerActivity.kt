package com.example.ex20230301

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class TimerActivity : AppCompatActivity() {

    lateinit var tvTimer : TextView
    lateinit var tvTimer2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        tvTimer = findViewById(R.id.tvTimer)
        tvTimer2 = findViewById(R.id.tvTimer2)
        val btnTimer = findViewById<Button>(R.id.btnTimer)
        val img = findViewById<ImageView>(R.id.img)

        val doThread = DoThread(img)
        doThread.start()


        btnTimer.setOnClickListener {
            val thread = TimerThread(tvTimer)
            thread.start()

            val thread2 = TimerThread(tvTimer2)
            thread2.start()

        }





    }

    inner class DoHandler() : Handler(Looper.getMainLooper()){
        // Ctrl + O : handleMessage()
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            val resId = msg.arg2
            val img = msg.obj as ImageView
            img.setImageResource(resId)


        }
    }

    inner class DoThread(val img : ImageView) : Thread(){

        // Ctrl + O : run()
        override fun run() {

            while(true){
                val offTime = Random().nextInt(300)
                sleep(offTime.toLong())

                val message = Message()
                message.arg2 = R.drawable.on
                message.obj = img

                val doHandler = DoHandler()
                doHandler.sendMessage(message)

                val onTime = Random().nextInt(500)
                sleep(onTime.toLong())

                val message2 = Message()
                message2.arg2 = R.drawable.off
                message2.obj = img

                val doHandler2 = DoHandler()
                doHandler2.sendMessage(message2)
            }





        }
    }



    inner class TimerHandler : Handler(Looper.getMainLooper()){
        // Main Thread 의 작업 Queue 에 Message 를 전달하는 역할

        // Ctrl + O : handleMessage()
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val time = msg.arg1
            val tv = msg.obj as TextView

            tv.setText(time.toString())

        }
    }

    inner class TimerThread(val tv : TextView) : Thread(){
        // ctrl + O
        override fun run() {

            for(i in 10 downTo 0){
                Log.d("시간", i.toString())

                val message = Message()

                message.arg1 = i
                message.obj = tv

                val handler = TimerHandler()
                handler.sendMessage(message)

                val random = Random()
                val ranInt = random.nextInt(500) + 500

                sleep(ranInt.toLong())
            }

        }
    }
}