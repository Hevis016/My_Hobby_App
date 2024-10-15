package com.selara.myhobbyapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selara.myhobbyapp.databinding.ActivityProgsPageBinding

class ProgsPage : AppCompatActivity() {
    private lateinit var binding: ActivityProgsPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent (this, MainActivity2::class.java)
            startActivity(intent)
            // Додаємо анімацію переходу вправо
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }
}