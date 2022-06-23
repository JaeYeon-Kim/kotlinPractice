package com.kjy.kotlinpractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import java.text.ParseException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

// 인터페이스
/*
인터페이스는 추상화와 비교하면 가장 명확하게 이해할 수 있는데 실행 코드 없이 메서드 이름만 가진 추상 클래스
누군가 설계해놓은 개념 클래스 중에 실행 코드가 한 줄 이라도 있으면 추상화, 코드 없이 메서드 이름만 나열되어 있으면 있으면 인터페이스
인터페이스는 상속 관계의 설계보다는 외부 모듈에서 내가 만든 모듈을 사용할 수 있도록 메서드의 이름을 나열해둔 일종의 명세서로 제공.

interface 인터페이스명 {
    var 변수: String
    fun 메서드1()
    fun 메서드2()
}
 */





