package com.example.ex20230228

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient


class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_2, container, false)
        // xml코드를 눈에보이는 뷰 객체로 바꿔준 view를 사용해서
        // fragment2.xml에 있는 요소들을 제어한다.
        // WebView를 사용해서 Naver홈페이지를 띄워준다!
        // 0. view의 도움을 받아 WebView의 id값찾아오기
        val wv = view.findViewById<WebView>(R.id.wv)
        // 1. 주소 지정
        val address = "http://www.naver.com"
        // 2. 설정 변경 ( JavaScript 사용가능하도록 )
        var ws = wv.settings
        ws.javaScriptEnabled = true
        // 3. WebView의 Client지정
        wv.webViewClient = WebViewClient()
        // 4. 주소 적용
        wv.loadUrl(address)

        return view
    }

}