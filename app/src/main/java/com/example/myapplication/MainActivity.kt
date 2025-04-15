package com.example.myapplication

import android.os.Bundle
import android.graphics.Color // Color 관련 클래스 import
import android.widget.* // EditText, Button, TextView 클래스들 import

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // activity_main.xml에서 해당 ID로 뷰를 초기화
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText) // 비밀번호 입력 EditText
        val checkPasswordButton = findViewById<Button>(R.id.checkPasswordButton) // 확인 버튼
        val resultTextView = findViewById<TextView>(R.id.resultTextView) // 결과를 보여줄 TextView

        // 버튼 클릭 시 비밀번호 확인
        checkPasswordButton.setOnClickListener {
            val inputPassword = passwordEditText.text.toString() // 입력된 비밀번호

            // 비밀번호가 맞으면
            if (inputPassword == "1234") {
                resultTextView.text = "비밀번호가 맞습니다!" // 비밀번호가 맞을 때
                resultTextView.setTextColor(Color.parseColor("#2E7D32")) // 초록색
            } else {
                // 비밀번호가 틀리면
                resultTextView.text = "비밀번호가 틀립니다!" // 비밀번호가 틀릴 때
                resultTextView.setTextColor(Color.parseColor("#C62828")) // 빨간색
            }
        }
    }
}
