package com.hong.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.hong.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val correctPassword = getString(R.string.password)
        var count = 0
        var pressed = false

        binding.inputButton.setOnClickListener {
            val userInput = binding.editTextNumberPassword.text.toString()
            if (userInput == correctPassword) {
                binding.resultTextView.setTextColor(getColor(android.R.color.holo_green_light))
                binding.resultTextView.text = "올바른 비밀번호입니다!"
                count = 0
                binding.hahaImageView.visibility=View.INVISIBLE

            } else {
                binding.resultTextView.setTextColor(getColor(android.R.color.holo_red_dark))
                binding.resultTextView.text = "비밀번호가 틀렸습니다. 다시 입력해 주세요."
                count +=1
                if(count >= 3){
                    binding.hahaImageView.visibility=View.VISIBLE
                }


            }
        }
        binding.jokeButton.setOnClickListener {
            if(pressed == false) {
                binding.jokeTextView.text = "아직 다음 화면으로 넘어가는 법을 안 배워서 해 드릴수 있는게 없습니다ㅋㅋ"
                pressed = true
            }
            else{
                binding.jokeTextView.text = ""
                pressed = false
            }
        }
    }


    }
