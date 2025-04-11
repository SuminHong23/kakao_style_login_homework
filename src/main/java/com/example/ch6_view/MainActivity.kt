package com.example.ch6_view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ch6_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding= ActivityMainBinding.inflate(layoutInflater)
        val correctPassword = "1234"
        setContentView(binding.root)
        binding.Checkbutton.setOnClickListener({
            val inputPassWord = binding.inputPW.text.toString()
            if (inputPassWord == correctPassword) {
                binding.checkPW.text = getString(R.string.correct)
            } else {
                binding.checkPW.text = getString(R.string.not_correct)
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}