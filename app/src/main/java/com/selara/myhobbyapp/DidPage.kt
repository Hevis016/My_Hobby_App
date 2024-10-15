package com.selara.myhobbyapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.selara.myhobbyapp.databinding.ActivityDidPageBinding
import com.selara.myhobbyapp.databinding.ActivityProgsPageBinding

class DidPage : AppCompatActivity() {
    private lateinit var binding: ActivityDidPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDidPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            // Додаємо анімацію переходу вправо
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }
}