package com.example.doit

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.doit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editTextId = binding.editTextId
        val editTextPw = binding.editTextPw
        val isCorrectPw = binding.isCorrectPw

        editTextId.setOnClickListener {
            if (editTextId.text.toString() == "아이디") {
                editTextId.setText("")
            }
        }

        editTextPw.setOnClickListener {
            if (editTextPw.text.toString() == "비밀번호") {
                editTextPw.setText("")
            }
        }

        binding.loginButton.setOnClickListener {
            val pw = binding.editTextPw.text.toString()
            if (pw == "1234") {
                isCorrectPw.text = "일치합니다."
                isCorrectPw.visibility = View.VISIBLE
            } else {
                isCorrectPw.text = "일치하지 않습니다."
                isCorrectPw.visibility = View.VISIBLE
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}