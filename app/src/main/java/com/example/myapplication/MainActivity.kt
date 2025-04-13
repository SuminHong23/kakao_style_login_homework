package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // View 참조
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val forgotTextView = findViewById<TextView>(R.id.forgotTextView)
        val confirmButton = findViewById<Button>(R.id.confirmButton)

        // 비밀번호 입력란 클릭 시 비밀번호 찾기 문구 숨김
        passwordEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                forgotTextView.visibility = View.GONE
            } else {
                binding.forgotTextView.visibility = View.VISIBLE
            }
        }

        // 확인 버튼 클릭 시 비밀번호 확인
        confirmButton.setOnClickListener {
            val enteredPassword = passwordEditText.text.toString()
            if (enteredPassword == "1234") {
                Toast.makeText(this, "일치합니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "일치하지 않습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}